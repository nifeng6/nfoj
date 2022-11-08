import { defineStore } from 'pinia'
import { getLogin, getUserInfo } from '@/services/modules/common/account'
import { ElMessage, ElMessageBox } from 'element-plus'
// 导入message的样式
import 'element-plus/theme-chalk/el-message.css'
import 'element-plus/theme-chalk/el-message-box.css'
import type { ILoginParams, IUser } from './types'

const useCommonAccountStore = defineStore('common-account', {
  state: () => ({
    token: localStorage.getItem('token') || '',
    user: (JSON.parse(localStorage.getItem('user') as string) as IUser) || {}
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
        ElMessageBox.alert(res.msg, '温馨提示', {
          confirmButtonText: '重新登录',
          callback: () => {
            localStorage.removeItem('token')
          }
        })
      }
    }
  }
})

export default useCommonAccountStore
