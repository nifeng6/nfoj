import { defineStore } from 'pinia'
import {
  getLogin,
  getUserInfo,
  updateUserInfo
} from '@/services/modules/common/account'
import { ElMessage, ElMessageBox } from 'element-plus'
// 导入message的样式
import 'element-plus/theme-chalk/el-message.css'
import 'element-plus/theme-chalk/el-message-box.css'
import type { ILoginParams, IUser } from './types'

const useCommonAccountStore = defineStore('common-account', {
  state: () => ({
    token: localStorage.getItem('token') || '',
    user: (JSON.parse(localStorage.getItem('user') as string) as IUser) || {},
    accountDialogVisible: false,
    accountDialogType: 'login'
  }),
  actions: {
    async getLoginAction(data: ILoginParams) {
      const res = await getLogin(data)
      if (res.code === 200) {
        this.getUserInfoAction()
        ElMessage.success('登录成功')
        this.token = res.data.token
        window.localStorage.setItem('token', res.data.token)
        return true
      } else {
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
    }
  }
})

export default useCommonAccountStore
