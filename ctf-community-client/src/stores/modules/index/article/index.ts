import { defineStore } from 'pinia'
import type { IArticle } from './types'
import { getArticleDetail } from '@/services/modules/index/article'

const useIndexArticleStore = defineStore('index-article', {
  state: () => ({
    article: {} as IArticle
  }),
  actions: {
    async getArticleDetailAction(id: number) {
      const res = await getArticleDetail({ id })
      if (res.code === 200) {
        this.article = res.data
      }
    }
  }
})

export default useIndexArticleStore
