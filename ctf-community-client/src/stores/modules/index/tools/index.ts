import { defineStore } from 'pinia'
import { getToolTagList, getToolTypeList, getToolList } from '@/services'
import type { IToolTag, IToolType, ITool, IPage } from './types'

const useIndexToolStore = defineStore('tool', {
  state: () => ({
    toolTagList: [] as Array<IToolTag>,
    toolTypeList: [] as Array<IToolType>,
    toolList: [] as Array<ITool>,
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
    async getToolTagListAction() {
      const res = await getToolTagList()
      this.toolTagList = res.data
    },

    async getToolTypeListAction() {
      const res = await getToolTypeList()
      this.toolTypeList = res.data
    },

    async getToolListAction() {
      const params = {
        currentPage: this.page.currentPage,
        pageSize: this.page.pageSize,
        type: this.currentType,
        keywords: this.keywords
      }

      const res = await getToolList(params)
      this.toolList = res.data
      this.page = { ...res.page } as IPage
    }
  }
})

export default useIndexToolStore
