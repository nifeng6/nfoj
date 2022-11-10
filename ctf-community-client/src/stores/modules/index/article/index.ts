import { defineStore } from 'pinia'
import type {
  IArticle,
  IPage,
  IArticleReply,
  IArticleAddReplyParams
} from './types'
import {
  getArticleDetail,
  getArticleReplyList,
  addArticleReply
} from '@/services/modules/index/article'
import { ElMessage } from 'element-plus'
import 'element-plus/theme-chalk/el-message.css'

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
    async getArticleDetailAction(id: number) {
      const res = await getArticleDetail({ id })
      if (res.code === 200) {
        this.article = res.data
      }
    },
    async getArticleReplyListAction(id: number) {
      const params = {
        id,
        currentPage: this.replyPage.currentPage,
        pageSize: this.replyPage.pageSize
      }
      const res = await getArticleReplyList(params)
      if (res.code === 200) {
        this.replyList = res.data
        this.replyPage = res.page as IPage
      }
    },
    async addArticleReplyAction(data: IArticleAddReplyParams) {
      const res = await addArticleReply(data)
      if (res.code === 200) {
        this.getArticleReplyListAction(data.articleId)
        ElMessage.success('评论成功')
        return true
      } else {
        ElMessage.error('评论失败')
        return false
      }
    }
  }
})

export default useIndexArticleStore
