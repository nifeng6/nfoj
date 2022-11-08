import { defineStore } from 'pinia'
import type { IUser, IUserRecord } from './types'
import { getUserInfo, getUserRecord } from '@/services/modules/index/user'

const useIndexUserStore = defineStore('index-user', {
  state: () => ({
    user: {} as IUser,
    record: {} as IUserRecord
  }),
  actions: {
    async getUserInfoAction(id: number) {
      const res = await getUserInfo({ id })
      if (res.code === 200) {
        this.user = res.data
      }
    },
    async getUserRecordAction(id: number) {
      const res = await getUserRecord({ id })
      if (res.code === 200) {
        this.record = res.data
      }
    }
  }
})

export default useIndexUserStore
