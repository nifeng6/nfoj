import { defineStore } from 'pinia'
import type {
  IArticle,
  IPage,
  IArticleReply,
  IArticleAddReplyParams
} from '@/types/index/article'
import {
  getArticleDetail,
  getArticleReplyList,
  addArticleReply
} from '@/services/modules/index/article'
import { ElNotification } from 'element-plus'
import 'element-plus/theme-chalk/el-notification.css'

const useIndexArticleStore = defineStore('index-article', {
  state: () => ({
    article: {} as IArticle,
    replyList: [] as IArticleReply[],
    replyPage: {
      currentPage: 1,
      pageSize: 5,
      total: 0,
      pages: 0
    } as IPage
  }),
  actions: {
    // 获取文章详情
    async getArticleDetailAction(id: number) {
      return getArticleDetail({ id })
        .then((res) => {
          if (res.code === 200) {
            this.article = res.data
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

      // const res = await getArticleDetail({ id })
      // if (res.code === 200) {
      //   this.article = res.data
      // }
    },
    // 获取文章评论列表
    async getArticleReplyListAction(id: number) {
      const params = {
        id,
        currentPage: this.replyPage.currentPage,
        pageSize: this.replyPage.pageSize
      }
      return getArticleReplyList(params)
        .then((res) => {
          if (res.code === 200) {
            this.replyList = res.data
            this.replyPage = res.page as IPage
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
      // const res = await getArticleReplyList(params)
      // if (res.code === 200) {
      //   this.replyList = res.data
      //   this.replyPage = res.page as IPage
      // }
    },
    // 增加评论
    async addArticleReplyAction(data: IArticleAddReplyParams) {
      return addArticleReply(data)
        .then((res) => {
          if (res.code === 200) {
            ElNotification.success({
              title: '成功',
              message: res.msg
            })
            this.getArticleReplyListAction(data.articleId)
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

      // const res = await addArticleReply(data)
      // if (res.code === 200) {
      //   this.getArticleReplyListAction(data.articleId)
      //   ElMessage.success('评论成功')
      //   return true
      // } else {
      //   ElMessage.error('评论失败')
      //   return false
      // }
    }
  }
})

export default useIndexArticleStore
