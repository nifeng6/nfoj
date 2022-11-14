import { defineStore } from 'pinia'
import {
  getNoticeList,
  getDynamicList,
  getNewLabList,
  getWeekRecord
} from '@/services/modules/index/home'
import type { IPage } from '@/types/index/home'
import type { IWeekRecordData } from '@/types/index/home/index'

const useIndexHomeStore = defineStore('index-home', {
  state: () => ({
    noticeList: [] as any[],
    dynamicList: [] as any[],
    newLabList: [] as any[],
    weekRecord: {} as IWeekRecordData,
    noticePage: {
      currentPage: 1,
      pageSize: 10,
      total: 0,
      pages: 0
    } as IPage,
    dynamicPage: {
      currentPage: 1,
      pageSize: 10,
      total: 0,
      pages: 0
    } as IPage,
    newLabPage: {
      currentPage: 1,
      pageSize: 10,
      total: 0,
      pages: 0
    } as IPage
  }),
  actions: {
    async getNoticeListAction() {
      const params = {
        currentPage: this.noticePage.currentPage,
        pageSize: this.noticePage.pageSize
      }
      return getNoticeList(params).then((res) => {
        this.noticeList = res.data
        this.noticePage.currentPage = res.page!.currentPage
        this.noticePage.pageSize = res.page!.pageSize
      })
    },
    async getNoticePageAction() {
      const params = {
        currentPage: this.noticePage.currentPage,
        pageSize: this.noticePage.pageSize
      }
      return getDynamicList(params).then((res) => {
        this.dynamicList = res.data
        this.dynamicPage.currentPage = res.page!.currentPage
        this.dynamicPage.pageSize = res.page!.pageSize
      })
    },
    async getNewLabListAction() {
      const params = {
        currentPage: this.newLabPage.currentPage,
        pageSize: this.newLabPage.pageSize
      }
      return getNewLabList(params).then((res) => {
        this.newLabList = res.data
        this.newLabPage.currentPage = res.page!.currentPage
        this.newLabPage.pageSize = res.page!.pageSize
      })
    },
    async getWeekRecordAction() {
      return getWeekRecord().then((res) => {
        this.weekRecord = res.data
      })
    }
  }
})

export default useIndexHomeStore
