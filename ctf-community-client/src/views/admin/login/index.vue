<template>
  <div class="admin-login">
    <div class="login-container">
      <h1>欢迎登录后台管理系统</h1>
      <div class="login-form">
        <el-form :model="formData" :rules="formRules" ref="loginFormRef">
          <el-form-item prop="username">
            <el-input
              v-model="formData.username"
              placeholder="请输入用户账号"
              size="large"
            ></el-input>
          </el-form-item>
          <el-form-item prop="password">
            <el-input
              v-model="formData.password"
              placeholder="请输入用户密码"
              size="large"
              type="password"
            ></el-input>
          </el-form-item>
          <el-form-item prop="captchaCode">
            <el-row :gutter="10">
              <el-col :span="15">
                <el-input
                  v-model="formData.captchaCode"
                  placeholder="请输入验证码"
                  size="large"
                ></el-input>
              </el-col>
              <el-col :span="9">
                <img :src="captchaURL" alt="验证码" @click="flushCaptcha" />
              </el-col>
            </el-row>
          </el-form-item>
          <el-form-item>
            <el-button
              style="width: 100%"
              size="large"
              type="primary"
              @click="loginClickHandle"
            >
              用户登录
            </el-button>
          </el-form-item>
        </el-form>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import { ref } from 'vue'
import type { FormInstance } from 'element-plus'
import useCommonAccountStore from '@/stores/modules/common/account/index'
import { useRouter } from 'vue-router'

const router = useRouter()
const captchaURL = ref(import.meta.env.VITE_CAPTCHA_URL)
const commonAccountStore = useCommonAccountStore()
const loginFormRef = ref<FormInstance>()

const formData = ref({
  username: '',
  password: '',
  captchaCode: ''
})

// 刷新验证码
const flushCaptcha = () => {
  captchaURL.value =
    import.meta.env.VITE_CAPTCHA_URL + '?time=' + new Date().getTime()
}

const formRules = ref({
  username: [{ required: true, message: '请输入用户账号', trigger: 'blur' }],
  password: [{ required: true, message: '请输入用户密码', trigger: 'blur' }],
  captchaCode: [{ required: true, message: '请输入验证码', trigger: 'blur' }]
})

const loginClickHandle = () => {
  loginFormRef.value?.validate((valid) => {
    if (valid) {
      const data = {
        ...formData.value
      }
      commonAccountStore.getLoginAction(data).then((res) => {
        router.push('/admin')
      })
    }
  })
}
</script>

<style scoped lang="less">
.admin-login {
  height: 100vh;
  width: 100vw;
  background-color: #1e9fff;
  .login-container {
    width: 300px;
    // height: 300px;
    background-color: #fff;
    border-radius: 10px;
    position: absolute;
    padding: 20px 15px;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    h1 {
      font-size: 20px;
      text-align: center;
      color: #1e9fff;
    }
    .login-form {
      margin-top: 30px;
      img {
        width: 100%;
        height: 100%;
      }
    }
  }
}
</style>
