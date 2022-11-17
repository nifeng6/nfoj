import { defineStore } from 'pinia'
import type {
  ILabsData,
  IPage,
  ILabsTypeData,
  ILabsDockerData,
  IAddLabsListParams,
  IUpdateLabsParams
} from '@/types/admin/labs'
import {
  getList,
  deleteById,
  deleteList,
  getLabsDockerList,
  getLabsTypeList,
  addLabs,
  updateLabs
} from '@/services/modules/admin/labs/index'
import { ElNotification } from 'element-plus'
import 'element-plus/theme-chalk/el-notification.css'

const useAdminLabsStore = defineStore('admin-labs', {
  state: () => ({
    replyList: [] as ILabsData[],
    editForm: {} as ILabsData,
    editDialogVisible: false,
    labsTypeList: [] as ILabsTypeData[],
    labsDockerList: [] as ILabsDockerData[],
    // 被选中的那条回复
    editActiveItem: {} as ILabsData,
    addDialogVisible: false,
    addForm: {} as ILabsData,
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
    async getLabsTypeListAction() {
      return getLabsTypeList().then((res) => {
        this.labsTypeList = res.data
      })
    },
    async getLabsDockerListAction() {
      return getLabsDockerList().then((res) => {
        this.labsDockerList = res.data
      })
    },
    async addLabsAction(params: IAddLabsListParams) {
      return addLabs(params)
        .then((res) => {
          if (res.code === 200) {
            ElNotification.success({
              title: '成功',
              message: '添加成功'
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
    async updateLabsAction(params: IUpdateLabsParams) {
      return updateLabs(params)
        .then((res) => {
          if (res.code === 200) {
            ElNotification.success({
              title: '成功',
              message: '修改成功'
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
            message: '修改失败，请稍后重试'
          })
        })
    }
  }
})

export default useAdminLabsStore
