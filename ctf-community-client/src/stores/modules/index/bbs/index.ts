import { defineStore } from 'pinia'
import { addArticle, getArticleList, getArticleTypeList } from '@/services'
import type {
  IArticle,
  IPage,
  IArticleType,
  IArticleAddParams
} from '@/types/index/bbs/index'
import { ElNotification } from 'element-plus'
import 'element-plus/theme-chalk/el-notification.css'

const useIndexBbsStore = defineStore('index-bbs', {
  state: () => ({
    articleList: [] as Array<IArticle>,
    articleTypeList: [] as Array<IArticleType>,
    page: {
      currentPage: 1,
      pageSize: 10,
      total: 0,
      pages: 0
    } as IPage,
    currentType: 0,
    keywords: ''
  }),
  actions: {
    // 获取文章列表
    async getArticleListAction() {
      const params = {
        currentPage: this.page.currentPage,
        pageSize: this.page.pageSize,
        type: this.currentType,
        keywords: this.keywords
      }
      return getArticleList(params)
        .then((res) => {
          if (res.code === 200) {
            this.articleList = res.data
            this.page = res.page as IPage
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
      // const res = await getArticleList(params)
      // this.articleList = res.data
      // this.page = { ...res.page } as IPage
    },
    // 获取文章类型列表
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
            title: '失败',
            message: '网络连接失败，请重试或联系管理员'
          })
        })

      // const res = await getArticleTypeList()
      // this.articleTypeList = res.data
    },
    // 增加文章
    async addArticleAction(data: IArticleAddParams) {
      return addArticle(data)
        .then((res) => {
          if (res.code === 200) {
            ElNotification.success({
              title: '成功',
              message: res.msg
            })
            this.getArticleListAction()
            return true
          } else {
            ElNotification.error({
              title: '失败',
              message: res.msg
            })
            return false
          }
        })
        .catch(() => {
          ElNotification.error({
            title: '失败',
            message: '网络连接失败，请重试或联系管理员'
          })
          return false
        })

      // const res = await addArticle(data)
      // if (res.code === 200) {
      //   this.getArticleListAction()
      //   ElMessage.success('发布成功')
      //   return true
      // } else {
      //   ElMessage.error(res.data)
      //   return false
      // }
    }
  }
})

export default useIndexBbsStore
