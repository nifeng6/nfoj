import { defineStore } from 'pinia'
import type {
  IRoleData,
  IPage,
  IAddRoleParams,
  IUpdateRoleParams
} from '@/types/admin/role'
import {
  getList,
  addRole,
  updateRole,
  deleteById,
  deleteList
} from '@/services/modules/admin/role/index'

const useAdminRoleStore = defineStore('admin-role', {
  state: () => ({
    roleList: [] as IRoleData[],
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
    editActiveItem: {} as IRoleData,
    selectList: [] as number[]
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
            this.roleList = res.data
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
    async deleteListAction() {
      const ids = this.selectList.join(',')
      return deleteList(ids)
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
    async addToolsAction(data: IAddRoleParams) {
      return addRole(data)
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
    async updateToolsAction(data: IUpdateRoleParams) {
      return updateRole(data)
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

export default useAdminRoleStore
