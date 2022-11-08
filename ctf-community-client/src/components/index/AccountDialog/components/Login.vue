<template>
  <div class="login">
    <el-form ref="ruleFormRef" :model="ruleForm" status-icon :rules="rules">
      <el-form-item prop="username">
        <el-input size="large" v-model="ruleForm.username" placeholder="用户名">
          <template #prefix>
            <el-icon class="el-input__icon"><User /></el-icon>
          </template>
        </el-input>
      </el-form-item>
      <el-form-item prop="password">
        <el-input size="large" v-model="ruleForm.password" placeholder="密码">
          <template #prefix>
            <el-icon class="el-input__icon"><Lock /></el-icon>
          </template>
        </el-input>
      </el-form-item>
      <el-form-item>
        <el-button
          style="width: 100%"
          type="primary"
          size="large"
          @click="loginHandle"
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

const commonAccountStore = useCommonAccountStore()
const ruleFormRef = ref<FormInstance>()

const emit = defineEmits(['update:dialogVisible'])
const props = defineProps<{
  dialogVisible: boolean
}>()

const dialogVisible = computed({
  get() {
    return props.dialogVisible
  },
  set(val) {
    emit('update:dialogVisible', val)
  }
})

const ruleForm = reactive({
  username: '',
  password: ''
})

const rules = reactive({
  username: [{ required: true, message: '用输入用户名', trigger: 'blur' }],
  password: [{ required: true, message: '用输入密码', trigger: 'blur' }]
})

const loginHandle = () => {
  ruleFormRef.value?.validate((valid) => {
    if (valid) {
      commonAccountStore.getLoginAction(ruleForm).then((res) => {
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
}
</style>
