<template>
  <div class="account-dialog">
    <el-dialog
      v-model="accountDialogVisible"
      width="25%"
      :before-close="closeHandle"
    >
      <template #header>
        <h2 class="title">
          {{ menuList[accountDialogType as keyof typeof menuList] }}
        </h2>
      </template>

      <template v-if="accountDialogType === 'login'">
        <Login
          v-model:login-form="loginForm"
          v-model:dialog-visible="accountDialogVisible"
        />
      </template>
      <template v-else-if="accountDialogType === 'register'">
        <Register
          @registerHandle="registerHandle"
          v-model:register-form="registerForm"
          v-model:dialogVisible="accountDialogVisible"
        />
      </template>
      <template v-else-if="accountDialogType === 'forgot'">
        <ForgotPassword v-model:dialogVisible="accountDialogVisible" />
      </template>

      <div class="dialog-footer">
        <template v-if="accountDialogType === 'login'">
          <div class="login-footer">
            <span @click="accountDialogType = 'register'"
              >还没账号？点击注册！</span
            >
            <span @click="accountDialogType = 'forgot'">忘记密码</span>
          </div>
        </template>
        <template v-else-if="accountDialogType === 'register'">
          <div class="register-footer">
            <span @click="accountDialogType = 'login'"
              >已有账号？点击登录！</span
            >
          </div>
        </template>
        <template v-else-if="accountDialogType === 'forgot'">
          <div class="forgot-password">
            <span @click="accountDialogType = 'login'"
              >账号记起来了？点击登录！</span
            >
          </div>
        </template>
      </div>
    </el-dialog>
  </div>
</template>

<script setup lang="ts">
import Login from './components/Login.vue'
import Register from './components/Register.vue'
import ForgotPassword from './components/ForgotPassword.vue'
import useCommonAccountStore from '@/stores/modules/common/account'
import { storeToRefs } from 'pinia'
import { reactive } from 'vue'

const loginForm = reactive({
  username: '',
  password: '',
  captchaCode: '',
  emailCode: ''
})
const registerForm = reactive({
  username: '',
  password: '',
  repassword: '',
  email: ''
})

const commonAccountStore = useCommonAccountStore()

const { accountDialogVisible, accountDialogType } =
  storeToRefs(commonAccountStore)

const menuList = {
  login: '用户登录',
  register: '用户注册',
  forgot: '忘记密码'
}

// 用户注册处理
const registerHandle = () => {
  commonAccountStore.registerAction(registerForm).then((status) => {
    if (status) {
      accountDialogType.value = 'login'
      loginForm.username = registerForm.username
      loginForm.password = registerForm.password
    }
  })
}

const closeHandle = () => {
  accountDialogVisible.value = false
}
</script>

<style scoped lang="less">
.account-dialog {
  .title {
    text-align: center;
    color: #4e4e4e;
  }

  .dialog-footer {
    span {
      cursor: pointer;
      color: #409eff;
    }
    .login-footer {
      display: flex;
      justify-content: space-between;
    }
    .register-footer {
      display: flex;
      justify-content: center;
    }
    .forgot-password {
      display: flex;
      justify-content: center;
    }
  }
}
</style>
