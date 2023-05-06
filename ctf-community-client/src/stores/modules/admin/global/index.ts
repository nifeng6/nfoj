import { defineStore } from 'pinia'
import { getMenuList } from '@/services/modules/admin/menu'
import type { IMenuData } from '@/types/admin/menu'
import { ElNotification } from 'element-plus'

const useAdminGlobalStore = defineStore('', {
  state: () => ({
    isFold: false,
    menuList: [] as IMenuData[]
  }),
  actions: {
    async getMenuList() {
      return getMenuList()
        .then((res) => {
          if (res.code === 200) {
            this.menuList = res.data
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
    }
  }
})

export default useAdminGlobalStore
