import { defineStore } from 'pinia'
import type {
  ICodeRunParams,
  ICodeRun,
  ICodeShare,
  ICodeShareParams
} from '@/types/index/coder/index'
import {
  codeRun,
  shareCode,
  getShareCode
} from '@/services/modules/index/coder/index'
import { ElNotification } from 'element-plus'
import 'element-plus/theme-chalk/el-notification.css'

const useIndexCoderStore = defineStore('index-coder', {
  state: () => ({
    runResult: {
      content: '',
      runTime: 0,
      code: 0
    } as ICodeRun,
    shareResult: {
      qrcode: '',
      key: ''
    } as ICodeShare,
    shareCode: {
      content: '',
      type: 'JAVA',
      onlyKey: ''
    },
    loading: false,
    shareCodeLoading: false
  }),
  actions: {
    async codeRunAction(data: ICodeRunParams) {
      try {
        this.loading = true
        const res = await codeRun(data)
        if (res.code === 200) {
          this.runResult = res.data
        } else {
          ElNotification.error({
            title: '失败',
            message: res.msg
          })
        }
        this.loading = false
      } catch {
        this.loading = false
        ElNotification.error({
          title: '失败',
          message: '网络连接失败，请重试或联系管理员'
        })
      }
    },
    async codeShareAction(data: ICodeShareParams) {
      this.shareCodeLoading = true

      return shareCode(data)
        .then((res) => {
          if (res.code === 200) {
            this.shareResult = res.data
            ElNotification.success({
              title: '成功',
              message: res.msg
            })
            this.shareCodeLoading = false
            return true
          } else {
            ElNotification.error({
              title: '失败',
              message: res.msg
            })
            this.shareCodeLoading = false
            return false
          }
        })
        .catch(() => {
          this.shareCodeLoading = false
          ElNotification.error({
            title: '失败',
            message: '网络连接失败，请重试或联系管理员'
          })
          return false
        })

      // const res = await shareCode(data)
      // if (res.code === 200) {
      //   this.shareResult = res.data
      //   ElMessage.success('二维码生成成功，可以分享给好友了！')
      //   this.shareCodeLoading = false
      //   return true
      // } else {
      //   this.shareCodeLoading = false
      //   ElMessage.error(res.msg)
      //   return false
      // }
    },
    async getShareCodeAction(key: string) {
      return getShareCode(key)
        .then((res) => {
          if (res.code === 200) {
            this.shareCode.content = res.data.content
            this.shareCode.onlyKey = res.data.onlyKey
            this.shareCode.type = res.data.type
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

      // const res = await getShareCode(key)
      // if (res.code === 200) {
      //   this.shareCode.content = res.data.content
      //   this.shareCode.onlyKey = res.data.onlyKey
      //   this.shareCode.type = res.data.type
      //   return true
      // } else {
      //   ElMessage.error(res.msg)
      //   return false
      // }
    }
  }
})

export default useIndexCoderStore
