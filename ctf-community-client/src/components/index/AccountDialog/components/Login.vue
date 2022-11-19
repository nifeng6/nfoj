<template>
  <div class="login">
    <el-form ref="ruleFormRef" :model="loginForm" status-icon :rules="rules">
      <el-form-item prop="username">
        <el-input
          size="large"
          v-model="loginForm.username"
          placeholder="用户名"
        >
          <template #prefix>
            <el-icon class="el-input__icon"><User /></el-icon>
          </template>
        </el-input>
      </el-form-item>
      <el-form-item prop="password">
        <el-input
          type="password"
          show-password
          size="large"
          v-model="loginForm.password"
          placeholder="密码"
        >
          <template #prefix>
            <el-icon class="el-input__icon"><Lock /></el-icon>
          </template>
        </el-input>
      </el-form-item>
      <el-form-item prop="captchaCode">
        <div class="captcha">
          <el-input
            size="large"
            v-model="loginForm.captchaCode"
            placeholder="验证码"
          >
            <template #prefix>
              <el-icon class="el-input__icon"><Lock /></el-icon>
            </template>
          </el-input>
          <img :src="captchaURL" alt="验证码" @click="flushCaptcha" />
        </div>
      </el-form-item>
      <el-form-item>
        <el-button
          style="width: 100%"
          type="primary"
          size="large"
          @click="loginHandle"
          :loading="loginLoading"
          >登录</el-button
        >
      </el-form-item>
    </el-form>
  </div>
</template>

<script setup lang="ts">
import { ref, computed } from 'vue'
import { User, Lock } from '@element-plus/icons-vue'
import type { FormInstance } from 'element-plus'
import useCommonAccountStore from '@/stores/modules/common/account'
import { storeToRefs } from 'pinia'
import type { ILoginParams } from '@/types/common/account'

const commonAccountStore = useCommonAccountStore()
const { loginLoading } = storeToRefs(commonAccountStore)
const ruleFormRef = ref<FormInstance>()

const captchaURL = ref(import.meta.env.VITE_CAPTCHA_URL)
const emit = defineEmits(['update:dialogVisible', 'update:loginForm'])
const props = defineProps<{
  dialogVisible: boolean
  loginForm: ILoginParams
}>()

const dialogVisible = computed({
  get() {
    return props.dialogVisible
  },
  set(val) {
    emit('update:dialogVisible', val)
  }
})

const loginForm = computed({
  get() {
    return props.loginForm
  },
  set(val) {
    emit('update:loginForm', val)
  }
})
// 刷新验证码
const flushCaptcha = () => {
  captchaURL.value =
    import.meta.env.VITE_CAPTCHA_URL + '?time=' + new Date().getTime()
}
const rules = reactive({
  username: [{ required: true, message: '请输入用户名', trigger: 'blur' }],
  password: [{ required: true, message: '请输入密码', trigger: 'blur' }],
  captchaCode: [{ required: true, message: '请输入验证码', trigger: 'blur' }]
})

const loginHandle = () => {
  ruleFormRef.value?.validate((valid) => {
    if (valid) {
      commonAccountStore.getLoginAction(loginForm.value).then((res) => {
        if (res) {
          dialogVisible.value = false
        }
      })
    }
  })
}
</script>

<style scoped lang="less">
.login {
  .captcha {
    display: flex;
    img {
      width: 35%;
      margin-left: 10px;
    }
  }
}
</style>
