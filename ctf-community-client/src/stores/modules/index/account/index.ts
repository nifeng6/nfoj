import { defineStore } from 'pinia'
import {
  getAccountCoinRecordList,
  getAccountQiandao,
  updatePassword
} from '@/services/modules/index/account'
import type { ICoinRecord, IPage } from '@/types/index/account/index'
import { ElNotification } from 'element-plus'
import 'element-plus/theme-chalk/el-notification.css'

const useIndexAccountStore = defineStore('index-account', {
  state: () => ({
    coinRecordList: [] as ICoinRecord[],
    page: {
      currentPage: 1,
      pageSize: 5,
      total: 0,
      pages: 0
    } as IPage
  }),
  actions: {
    async getAccountCoinRecordListAction() {
      return getAccountCoinRecordList(this.page)
        .then((res) => {
          if (res.code === 200) {
            this.coinRecordList = res.data
            this.page = res.page as IPage
          } else {
            ElNotification.error({
              title: '失败',
              message: res.msg
            })
          }
        })
        .catch(() => {
          ElNotification.error({
            title: '失败',
            message: '网络连接失败，请重试或联系管理员'
          })
        })
    },
    async getAccountQiandaoAction() {
      return getAccountQiandao()
        .then((res) => {
          if (res.code === 200) {
            ElNotification.success({
              title: '成功',
              message: res.msg
            })
          } else {
            ElNotification.error({
              title: '失败',
              message: res.msg
            })
          }
        })
        .catch(() => {
          ElNotification.error({
            title: '失败',
            message: '网络连接失败，请重试或联系管理员'
          })
        })
    },
    async updatePasswordAction(data: { oldPass: string; newPass: string }) {
      return updatePassword(data)
        .then((res) => {
          if (res.code === 200) {
            ElNotification.success({
              title: '成功',
              message: res.msg
            })
            return true
          } else {
            ElNotification.error({
              title: '失败',
              message: res.msg
            })
            return false
          }
        })
        .catch(() => {
          ElNotification.error({
            title: '失败',
            message: '网络连接失败，请重试或联系管理员'
          })
          return false
        })
      // const res = await updatePassword(data)
      // if (res.code === 200) {
      //   ElMessage.success('修改成功')
      //   return true
      // } else {
      //   ElMessage.error(res.msg)
      //   return false
      // }
    }
  }
})

export default useIndexAccountStore
