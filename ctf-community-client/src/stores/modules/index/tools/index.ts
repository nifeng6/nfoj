import { defineStore } from 'pinia'
import { getToolTagList, getToolTypeList, getToolList } from '@/services'
import type {
  IToolTag,
  IToolType,
  ITool,
  IPage
} from '@/types/index/tools/index'
import { ElNotification } from 'element-plus'
import 'element-plus/theme-chalk/el-notification.css'

const useIndexToolStore = defineStore('index-tool', {
  state: () => ({
    toolTagList: [] as Array<IToolTag>,
    toolTypeList: [] as Array<IToolType>,
    toolList: [] as Array<ITool>,
    page: {
      currentPage: 1,
      pageSize: 16,
      total: 0,
      pages: 0
    } as IPage,
    currentType: 0,
    keywords: ''
  }),
  actions: {
    async getToolTagListAction() {
      return getToolTagList()
        .then((res) => {
          if (res.code === 200) {
            this.toolTagList = res.data
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

      // const res = await getToolTagList()
      // this.toolTagList = res.data
    },

    async getToolTypeListAction() {
      return getToolTypeList()
        .then((res) => {
          if (res.code === 200) {
            this.toolTypeList = res.data
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

      // const res = await getToolTypeList()
      // this.toolTypeList = res.data
    },

    async getToolListAction() {
      const params = {
        currentPage: this.page.currentPage,
        pageSize: this.page.pageSize,
        type: this.currentType,
        keywords: this.keywords
      }

      return getToolList(params)
        .then((res) => {
          if (res.code === 200) {
            this.toolList = res.data
            this.page = { ...res.page } as IPage
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

      // const res = await getToolList(params)
      // this.toolList = res.data
      // this.page = { ...res.page } as IPage
    }
  }
})

export default useIndexToolStore
