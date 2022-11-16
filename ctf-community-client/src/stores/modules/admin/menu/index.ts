import { defineStore } from 'pinia'
import { getMenuList } from '@/services/modules/admin/menu'
import type { IMenuData } from '@/types/admin/menu'

const useAdminMenuStore = defineStore('admin-menu', {
  state: () => ({
    menuList: [] as IMenuData[]
  }),
  actions: {
    async getMenuList() {
      return getMenuList().then((res) => {
        if (res.code === 200) {
          this.menuList = res.data
        }
      })
    }
  }
})

export default useAdminMenuStore
