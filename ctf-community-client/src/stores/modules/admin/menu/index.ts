import { defineStore } from 'pinia'
import {
  getList,
  deleteById,
  updateMenu,
  addMenu
} from '@/services/modules/admin/menu'
import type {
  IMenuData,
  IAddMenuParams,
  IPage,
  IUpdateMenuParams
} from '@/types/admin/menu'
import { ElNotification } from 'element-plus'
import 'element-plus/theme-chalk/el-message.css'

const useAdminMenuStore = defineStore('admin-menu', {
  state: () => ({
    menuList: [] as IMenuData[],
    page: {
      currentPage: 1,
      pageSize: 10,
      total: 0,
      pages: 0
    } as IPage,
    searchForm: {
      keywords: undefined
    },
    addDialogVisible: false,
    editDialogVisible: false,
    editActiveItem: {} as IMenuData
  }),
  actions: {
    async getListAction() {
      const params = {
        currentPage: this.page.currentPage,
        pageSize: this.page.pageSize,
        keywords: this.searchForm.keywords
      }
      return getList(params)
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
    },
    async deleteAction(id: number) {
      return deleteById(id)
        .then((res) => {
          if (res.code === 200) {
            ElNotification.success({
              title: '成功',
              message: res.msg
            })
            this.getListAction()
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
            message: '删除失败，请稍后重试'
          })
        })
    },

    async addToolsAction(data: IAddMenuParams) {
      return addMenu(data)
        .then((res) => {
          if (res.code === 200) {
            ElNotification.success({
              title: '成功',
              message: res.msg
            })
            this.addDialogVisible = false
            this.getListAction()
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
            message: '添加失败，请稍后重试'
          })
        })
    },
    async updateToolsAction(data: IUpdateMenuParams) {
      return updateMenu(data)
        .then((res) => {
          if (res.code === 200) {
            ElNotification.success({
              title: '成功',
              message: res.msg
            })
            this.editDialogVisible = false
            this.getListAction()
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
            message: '更新失败，请稍后重试'
          })
        })
    }
  }
})

export default useAdminMenuStore
