import { defineStore } from 'pinia'
import type { IToolsData, IPage } from '@/types/admin/tools'
import {
  getList,
  deleteById,
  deleteList
} from '@/services/modules/admin/tools/index'
import { ElNotification } from 'element-plus'
import 'element-plus/theme-chalk/el-message.css'
import 'element-plus/theme-chalk/el-notification.css'

const useAdminToolsStore = defineStore('admin-tools', {
  state: () => ({
    replyList: [] as IToolsData[],
    editForm: {} as IToolsData,
    editDialogVisible: false,
    // 被选中的那条回复
    editActiveItem: {} as IToolsData,
    addDialogVisible: false,
    addForm: {} as IToolsData,
    page: {
      currentPage: 1,
      pageSize: 10,
      total: 0,
      pages: 0
    } as IPage,
    searchForm: {
      keywords: undefined,
      type: undefined,
      createTime: undefined
    },
    keywords: '',
    selectList: [] as number[]
  }),
  actions: {
    async getListAction() {
      const params = {
        currentPage: this.page.currentPage,
        pageSize: this.page.pageSize,
        keywords: this.searchForm.keywords
          ? this.searchForm.keywords
          : undefined,
        type: this.searchForm.type ? this.searchForm.type : undefined,
        createTime: this.searchForm.createTime
          ? this.searchForm.createTime
          : undefined
      }
      return getList(params).then((res) => {
        this.page = res.page as IPage
        this.replyList = res.data
      })
    },
    async deleteAction(id: number) {
      return deleteById(id)
        .then((res) => {
          if (res.code === 200) {
            ElNotification.success({
              title: '成功',
              message: '删除成功'
            })
            this.getListAction()
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
              message: '删除成功'
            })
            this.getListAction()
          } else {
            ElNotification.error({
              title: '失败',
              message: '删除失败，请稍后重试'
            })
          }
        })
        .catch(() => {
          ElNotification.error({
            title: '失败',
            message: '删除失败，请稍后重试'
          })
        })
    }
  }
})

export default useAdminToolsStore
