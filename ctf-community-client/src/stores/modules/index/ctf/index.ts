import { defineStore } from 'pinia'
import { getCtfTypeList, getCtfTagList, getCtfList } from '@/services'
import type { ICtfType, ICtfTag, ICtfList, IPage } from './types'

const useIndexCtfStore = defineStore('city', {
  state: () => ({
    ctfTypeList: [] as Array<ICtfType>,
    ctfTagList: [] as Array<ICtfTag>,
    ctfList: [] as Array<ICtfList>,
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
    async getCtfTypeListAction() {
      const res = await getCtfTypeList()
      this.ctfTypeList = res.data
    },
    async getCtfTagListAction() {
      const res = await getCtfTagList()
      this.ctfTagList = res.data
    },
    async getCtfListAction() {
      const params = {
        currentPage: this.page.currentPage,
        pageSize: this.page.pageSize,
        type: this.currentType,
        keywords: this.keywords
      }
      const res = await getCtfList(params)
      this.ctfList = res.data
      this.page = { ...res.page } as IPage
    }
  }
})

export default useIndexCtfStore
