<template>
  <div class="register">
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
      <el-form-item prop="repassword">
        <el-input
          size="large"
          v-model="ruleForm.repassword"
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
          v-model="ruleForm.email"
          placeholder="请输入邮箱号"
        >
          <template #prefix>
            <el-icon class="el-input__icon"><Message /></el-icon>
          </template>
        </el-input>
      </el-form-item>
      <el-form-item>
        <el-button style="width: 100%" type="primary" size="large"
          >登录</el-button
        >
      </el-form-item>
    </el-form>
  </div>
</template>

<script setup lang="ts">
import { ref, computed } from 'vue'
import { User, Lock, Message } from '@element-plus/icons-vue'
import type { FormInstance } from 'element-plus'

const ruleForm = reactive({
  username: '',
  password: '',
  repassword: '',
  email: ''
})

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

const rules = reactive({
  username: [{ required: true, message: '请输入用户名', trigger: 'blur' }],
  password: [{ required: true, message: '请输入密码', trigger: 'blur' }],
  repassword: [{ required: true, message: '请再次输入密码', trigger: 'blur' }],
  email: [{ required: true, message: '请输入邮箱号', trigger: 'blur' }]
})

const ruleFormRef = ref<FormInstance>()
</script>

<style scoped lang="less"></style>
