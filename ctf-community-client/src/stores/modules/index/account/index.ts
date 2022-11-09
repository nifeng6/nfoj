import { defineStore } from 'pinia'
import {
  getAccountCoinRecordList,
  getAccountQiandao
} from '@/services/modules/index/account'
import type { ICoinRecord, IPage } from './types'
import { ElMessage } from 'element-plus'

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
      const res = await getAccountCoinRecordList(this.page)
      if (res.code === 200) {
        this.coinRecordList = res.data
        this.page = res.page as IPage
      }
    },
    async getAccountQiandaoAction() {
      const res = await getAccountQiandao()
      if (res.code === 200) {
        ElMessage.success('签到成功')
      } else {
        ElMessage.error(res.msg)
      }
    }
  }
})

export default useIndexAccountStore
