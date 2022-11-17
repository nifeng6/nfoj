import { defineStore } from 'pinia'
import type {
  IArticleParams,
  IArticleType,
  IPage,
  IUpdateArticleParams
} from '@/types/admin/bbs-article'
import type { IArticleData } from '@/types/admin/bbs-article'
import {
  getArticleList,
  deleteArticle,
  deleteArticleList,
  getArticleTypeList,
  addArticle,
  updateArticle
} from '@/services/modules/admin/bbs-article'
import { ElNotification } from 'element-plus'
import 'element-plus/theme-chalk/el-message.css'
import 'element-plus/theme-chalk/el-notification.css'

const useAdminBbsArticleStore = defineStore('admin-bbs-article', {
  state: () => ({
    articleList: [] as IArticleData[],
    articleTypeList: [] as IArticleType[],
    // editForm: {} as IArticleData,
    editDialogVisible: false,
    // 被选中的那个文章
    editActiveItem: {} as IArticleData,
    addDialogVisible: false,
    addForm: {} as IArticleData,
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
    async getArticleListAction() {
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
      return getArticleList(params)
        .then((res) => {
          if (res.code === 200) {
            this.page = res.page as IPage
            this.articleList = res.data
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
            message: '文章列表获取失败'
          })
        })
    },
    async deleteArticleAction(id: number) {
      return deleteArticle(id)
        .then((res) => {
          if (res.code === 200) {
            ElNotification.success({
              title: '成功',
              message: '删除成功'
            })
            this.getArticleListAction()
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
    async deleteArticleListAction() {
      const ids = this.selectList.join(',')
      return deleteArticleList(ids)
        .then((res) => {
          if (res.code === 200) {
            ElNotification.success({
              title: '成功',
              message: '删除成功'
            })
            this.getArticleListAction()
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
    },
    async getArticleTypeListAction() {
      return getArticleTypeList()
        .then((res) => {
          if (res.code === 200) {
            this.articleTypeList = res.data
          } else {
            ElNotification.error({
              title: '失败',
              message: res.msg
            })
          }
        })
        .catch(() => {
          ElNotification.error({
            title: '错误',
            message: '文章类型获取失败'
          })
        })
    },
    async addArticleAction(data: IArticleParams) {
      return addArticle(data)
        .then((res) => {
          if (res.code === 200) {
            ElNotification.success({
              title: '成功',
              message: '文章添加成功'
            })
            this.getArticleListAction()
            this.addDialogVisible = false
          } else {
            ElNotification.error({
              title: '错误',
              message: '文章添加失败'
            })
          }
        })
        .catch(() => {
          ElNotification.error({
            title: '错误',
            message: '文章添加失败'
          })
        })
    },
    async updateArticleAction(data: IUpdateArticleParams) {
      return updateArticle(data)
        .then((res) => {
          if (res.code === 200) {
            ElNotification.success({
              title: '成功',
              message: '文章更新成功'
            })
            this.editDialogVisible = false
            this.getArticleListAction()
          } else {
            ElNotification.error({
              title: '错误',
              message: '文章更新失败'
            })
          }
        })
        .catch(() => {
          ElNotification.error({
            title: '错误',
            message: '文章更新失败'
          })
        })
    }
  }
})

export default useAdminBbsArticleStore
