import { defineStore } from 'pinia'
import type { IUser, IUserRecord, IPage, IArticle, ICtfRecord } from './types'
import {
  getUserInfo,
  getUserRecord,
  getUserArticleList,
  getUserCtfRecordList
} from '@/services/modules/index/user'

const useIndexUserStore = defineStore('index-user', {
  state: () => ({
    user: {} as IUser,
    record: {} as IUserRecord,
    articleList: [] as IArticle[],
    ctfList: [] as ICtfRecord[],
    articlePage: {
      currentPage: 1,
      pageSize: 5,
      total: 0,
      pages: 0
    } as IPage,
    ctfPage: {
      currentPage: 1,
      pageSize: 5,
      total: 0,
      pages: 0
    } as IPage
  }),
  actions: {
    async getUserInfoAction(id: number) {
      const res = await getUserInfo({ id })
      if (res.code === 200) {
        this.user = res.data
      }
    },
    async getUserRecordAction(id: number) {
      const res = await getUserRecord({ id })
      if (res.code === 200) {
        this.record = res.data
      }
    },
    async getUserArticleListAction(id: number) {
      const params = {
        id,
        ...this.articlePage
      }
      const res = await getUserArticleList(params)
      if (res.code === 200) {
        this.articleList = res.data
        this.articlePage = res.page as IPage
      }
    },
    async getUserCtfListAction(id: number) {
      const params = {
        id,
        ...this.ctfPage
      }
      const res = await getUserCtfRecordList(params)
      if (res.code === 200) {
        this.ctfList = res.data
      }
    }
  }
})

export default useIndexUserStore
