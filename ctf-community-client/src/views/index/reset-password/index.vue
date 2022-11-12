<template>
  <div class="reset-password">
    <el-card>
      <h3>重置密码</h3>
      <el-form :model="resetPasswordForm" :rules="formRule">
        <el-form-item prop="username">
          <el-input
            disabled
            size="large"
            v-model="resetPasswordForm.username"
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
            v-model="resetPasswordForm.password"
            placeholder="请输入新密码"
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
            v-model="resetPasswordForm.repassword"
            placeholder="确认新密码"
          >
            <template #prefix>
              <el-icon class="el-input__icon"><Lock /></el-icon>
            </template>
          </el-input>
        </el-form-item>
        <el-form-item prop="emailCode">
          <el-input
            size="large"
            v-model="resetPasswordForm.emailCode"
            placeholder="验证码"
          >
            <template #prefix>
              <el-icon class="el-input__icon"><Lock /></el-icon>
            </template>
          </el-input>
        </el-form-item>
        <el-form-item>
          <el-button
            size="large"
            style="width: 100%"
            type="primary"
            @click="resetClickHandle"
          >
            重置密码
          </el-button>
        </el-form-item>
      </el-form>
    </el-card>
  </div>
</template>

<script setup lang="ts">
import { reactive } from 'vue'
import { Lock, User } from '@element-plus/icons-vue'
import { useRoute } from 'vue-router'
import useCommonAccountStore from '@/stores/modules/common/account'

const commonAccountStore = useCommonAccountStore()
const route = useRoute()
const resetPasswordForm = reactive({
  username: route.query.username as string,
  password: '',
  repassword: '',
  emailCode: route.query.code as string
})

const formRule = reactive({
  password: [
    {
      required: true,
      message: '请输入密码',
      trigger: 'blur'
    }
  ],
  repassword: [
    {
      required: true,
      message: '请再次输入密码',
      trigger: 'blur'
    },
    {
      validator: (rule: any, value: any, callback: any) => {
        if (value !== resetPasswordForm.password) {
          callback(new Error('两次输入密码不一致!'))
        } else {
          callback()
        }
      },
      trigger: 'blur'
    }
  ],
  emailCode: [
    {
      required: true,
      message: '请输入验证码',
      trigger: 'blur'
    }
  ]
})

const resetClickHandle = () => {
  commonAccountStore.resetPasswordAction(resetPasswordForm)
}
</script>

<style scoped lang="less">
.reset-password {
  max-width: 600px;
  margin: 20px auto;
  border-radius: 5px;
  h3 {
    text-align: center;
    margin-bottom: 20px;
  }
}
</style>
