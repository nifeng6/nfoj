import { defineStore } from 'pinia'
import type { IDashboardCountListData } from '@/types/admin/dashboard'
import { getCountList } from '@/services/modules/admin/dashboard'

const useAdminDashboardStore = defineStore('admin=dashboard', {
  state: () => ({
    countList: {} as IDashboardCountListData
  }),
  actions: {
    async getCountList() {
      return getCountList().then((res) => {
        if (res.code === 200) {
          this.countList = res.data
        }
      })
    }
  }
})

export default useAdminDashboardStore