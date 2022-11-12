<template>
  <div class="register">
    <el-form ref="ruleFormRef" :model="registerForm" status-icon :rules="rules">
      <el-form-item prop="username">
        <el-input
          size="large"
          v-model="registerForm.username"
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
          size="large"
          v-model="registerForm.password"
          placeholder="密码"
        >
          <template #prefix>
            <el-icon class="el-input__icon"><Lock /></el-icon>
          </template>
        </el-input>
      </el-form-item>
      <el-form-item prop="repassword">
        <el-input
          type="password"
          size="large"
          v-model="registerForm.repassword"
          placeholder="请再次输入密码"
        >
          <template #prefix>
            <el-icon class="el-input__icon"><Lock /></el-icon>
          </template>
        </el-input>
      </el-form-item>
      <el-form-item prop="email">
        <el-input
          size="large"
          v-model="registerForm.email"
          placeholder="请输入邮箱号"
        >
          <template #prefix>
            <el-icon class="el-input__icon"><Message /></el-icon>
          </template>
          <template #append>
            <el-button @click="sendEmailHandle">发送验证码</el-button>
          </template>
        </el-input>
      </el-form-item>
      <el-form-item prop="emailCode">
        <el-input
          size="large"
          v-model="registerForm.emailCode"
          placeholder="请输入邮箱验证码"
        >
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
          @click="sumbitRegisterHandle"
          >注册</el-button
        >
      </el-form-item>
    </el-form>
  </div>
</template>

<script setup lang="ts">
import { ref, computed } from 'vue'
import { User, Lock, Message } from '@element-plus/icons-vue'
import type { FormInstance } from 'element-plus'
import useCommonAccountStore from '@/stores/modules/common/account'
import type { IRegisterForm } from '@/types/common/account'

const commonAccountStore = useCommonAccountStore()
var confirmValidatePass = (rule: any, value: any, callback: any) => {
  if (value === '') {
    callback(new Error('请再次输入密码'))
  } else if (value !== registerForm.value.password) {
    callback(new Error('两次输入密码不一致!'))
  } else {
    callback()
  }
}

const emit = defineEmits([
  'update:dialogVisible',
  'update:registerForm',
  'registerHandle'
])
const props = defineProps<{
  dialogVisible: boolean
  registerForm: IRegisterForm
}>()

const sendEmailHandle = () => {
  commonAccountStore.registerEmailSendAction({
    email: props.registerForm.email
  })
}

const registerForm = computed({
  get() {
    return props.registerForm
  },
  set(val) {
    emit('update:registerForm', val)
  }
})

const dialogVisible = computed({
  get() {
    return props.dialogVisible
  },
  set(val) {
    emit('update:dialogVisible', val)
  }
})

const rules = reactive({
  username: [
    { required: true, message: '请输入2~15位用户名', trigger: 'blur' }
  ],
  password: [{ required: true, message: '请输入6~20位密码', trigger: 'blur' }],
  repassword: [
    { required: true, validator: confirmValidatePass, trigger: 'blur' }
  ],
  email: [{ required: true, message: '请输入邮箱号', trigger: 'blur' }]
})
const ruleFormRef = ref<FormInstance>()

// 提交注册信息
const sumbitRegisterHandle = () => {
  ruleFormRef.value?.validate((valid) => {
    if (valid) {
      emit('registerHandle')
    }
  })
}
</script>

<style scoped lang="less"></style>
