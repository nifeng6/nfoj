import { defineStore } from 'pinia'
import {
  getLogin,
  getUserInfo,
  updateUserInfo,
  registerUser,
  registerEmailSend
} from '@/services/modules/common/account'
import { ElMessage, ElMessageBox } from 'element-plus'
// 导入message的样式
import 'element-plus/theme-chalk/el-message.css'
import 'element-plus/theme-chalk/el-message-box.css'
import type {
  ILoginParams,
  IUser,
  IRegisterParams
} from '@/types/common/account/index'

const useCommonAccountStore = defineStore('common-account', {
  state: () => ({
    token: localStorage.getItem('token') || '',
    user: (JSON.parse(localStorage.getItem('user') as string) as IUser) || {},
    accountDialogVisible: false,
    accountDialogType: 'login',
    loginLoading: false,
    registerLoading: false
  }),
  actions: {
    async getLoginAction(data: ILoginParams) {
      this.loginLoading = true
      const res = await getLogin(data)
      if (res.code === 200) {
        this.loginLoading = false
        this.getUserInfoAction()
        ElMessage.success('登录成功')
        this.token = res.data.token
        window.localStorage.setItem('token', res.data.token)
        return true
      } else {
        this.loginLoading = false
        ElMessage.error(res.msg)
        return false
      }
    },
    async userLogoutAction() {
      ElMessageBox.confirm('确定退出登录吗？', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(async () => {
        this.token = ''
        this.user = {} as IUser
        window.localStorage.removeItem('token')
        window.localStorage.removeItem('user')
        ElMessage.success('退出成功')
      })
    },
    async getUserInfoAction() {
      const res = await getUserInfo()
      if (res.code === 200) {
        window.localStorage.setItem('user', JSON.stringify(res.data.user))
        this.user = res.data.user
      } else {
        ElMessage.error(res.msg)
        localStorage.removeItem('token')
        localStorage.removeItem('user')
        this.token = ''
        this.user = {} as IUser
        window.location.reload()
      }
    },
    async updateUserAction(data: IUser) {
      const res = await updateUserInfo(data)
      if (res.code === 200) {
        this.user = data
        window.localStorage.setItem('user', JSON.stringify(data))
        ElMessage.success('修改成功')
      } else {
        ElMessage.error(res.msg)
      }
    },
    async registerAction(data: IRegisterParams) {
      const res = await registerUser(data)
      if (res.code === 200) {
        this.registerLoading = false
        ElMessage.success('注册成功')
        return true
      } else {
        this.registerLoading = false
        ElMessage.error(res.msg)
        return false
      }
    },
    async registerEmailSendAction(data: { email: string }) {
      const res = await registerEmailSend(data)
      if (res.code === 200) {
        ElMessage.success('发送成功')
      } else {
        ElMessage.error(res.msg)
      }
    }
  }
})

export default useCommonAccountStore
