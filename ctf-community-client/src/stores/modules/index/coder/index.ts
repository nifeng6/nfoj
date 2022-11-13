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
import { ElMessage } from 'element-plus'

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
      this.loading = true
      const res = await codeRun(data)
      if (res.code === 200) {
        this.runResult = res.data
      }
      this.loading = false
    },
    async codeShareAction(data: ICodeShareParams) {
      this.shareCodeLoading = true
      const res = await shareCode(data)
      if (res.code === 200) {
        this.shareResult = res.data
        ElMessage.success('二维码生成成功，可以分享给好友了！')
        this.shareCodeLoading = false
        return true
      } else {
        this.shareCodeLoading = false
        ElMessage.error(res.msg)
        return false
      }
    },
    async getShareCodeAction(key: string) {
      const res = await getShareCode(key)
      if (res.code === 200) {
        this.shareCode.content = res.data.content
        this.shareCode.onlyKey = res.data.onlyKey
        this.shareCode.type = res.data.type
        return true
      } else {
        ElMessage.error(res.msg)
        return false
      }
    }
  }
})

export default useIndexCoderStore
