<template>
  <div class="account-dialog">
    <el-dialog
      v-model="accountDialogVisible"
      width="25%"
      :before-close="closeHandle"
    >
      <template #header>
        <h2 class="title">
          {{ menuList[currentType as keyof typeof menuList] }}
        </h2>
      </template>

      <template v-if="currentType === 'login'">
        <Login v-model:dialogVisible="dialogVisible" />
      </template>
      <template v-else-if="currentType === 'register'">
        <Register v-model:dialogVisible="dialogVisible" />
      </template>
      <template v-else-if="currentType === 'forgot'">
        <ForgotPassword v-model:dialogVisible="dialogVisible" />
      </template>

      <div class="dialog-footer">
        <template v-if="currentType === 'login'">
          <div class="login-footer">
            <span @click="currentType = 'register'">还没账号？点击注册！</span>
            <span @click="currentType = 'forgot'">忘记密码</span>
          </div>
        </template>
        <template v-else-if="currentType === 'register'">
          <div class="register-footer">
            <span @click="currentType = 'login'">已有账号？点击登录！</span>
          </div>
        </template>
        <template v-else-if="currentType === 'forgot'">
          <div class="forgot-password">
            <span @click="currentType = 'login'">账号记起来了？点击登录！</span>
          </div>
        </template>
      </div>
    </el-dialog>
  </div>
</template>

<script setup lang="ts">
import { withDefaults, computed } from 'vue'
import Login from './components/Login.vue'
import Register from './components/Register.vue'
import ForgotPassword from './components/ForgotPassword.vue'

const emit = defineEmits(['update:statusType', 'update:dialogVisible'])
// 设置props默认值
const props = withDefaults(
  defineProps<{
    statusType: string
    dialogVisible: boolean
  }>(),
  {
    statusType: 'login',
    dialogVisible: false
  }
)

const accountDialogVisible = computed({
  get: () => props.dialogVisible,
  set: (val) => emit('update:dialogVisible', val)
})

const currentType = computed({
  get() {
    return props.statusType
  },
  set(val) {
    emit('update:statusType', val)
  }
})

// const accountDialogVisible = ref(true)

const menuList = {
  login: '用户登录',
  register: '用户注册',
  forgot: '忘记密码'
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
