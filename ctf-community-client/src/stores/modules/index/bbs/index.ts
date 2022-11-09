import { defineStore } from 'pinia'
import { addArticle, getArticleList, getArticleTypeList } from '@/services'
import type { IArticle, IPage, IArticleType, IArticleParams } from './types'
import { ElMessage } from 'element-plus'
import 'element-plus/theme-chalk/el-message.css'

const useIndexBbsStore = defineStore('index-bbs', {
  state: () => ({
    articleList: [] as Array<IArticle>,
    articleTypeList: [] as Array<IArticleType>,
    page: {
      currentPage: 1,
      pageSize: 5,
      total: 0,
      pages: 0
    } as IPage,
    currentType: 0,
    keywords: ''
  }),
  actions: {
    async getArticleListAction() {
      const params = {
        currentPage: this.page.currentPage,
        pageSize: this.page.pageSize,
        type: this.currentType,
        keywords: this.keywords
      }
      const res = await getArticleList(params)
      this.articleList = res.data
      this.page = { ...res.page } as IPage
    },
    async getArticleTypeListAction() {
      const res = await getArticleTypeList()
      this.articleTypeList = res.data
    },
    async addArticleAction(data: IArticleParams) {
      const res = await addArticle(data)
      if (res.code === 200) {
        this.getArticleListAction()
        ElMessage.success('发布成功')
        return true
      } else {
        ElMessage.error(res.data)
        return false
      }
    }
  }
})

export default useIndexBbsStore
