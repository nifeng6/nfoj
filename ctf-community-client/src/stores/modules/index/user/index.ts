import { defineStore } from 'pinia'
import type {
  IUser,
  IUserRecord,
  IPage,
  IArticle,
  ICtfRecord
} from '@/types/index/user/index'
import {
  getUserInfo,
  getUserRecord,
  getUserArticleList,
  getUserCtfRecordList
} from '@/services/modules/index/user'
import { ElNotification } from 'element-plus'
import 'element-plus/theme-chalk/el-notification.css'

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
      return getUserInfo({ id })
        .then((res) => {
          if (res.code === 200) {
            this.user = res.data
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

      // const res = await getUserInfo({ id })
      // if (res.code === 200) {
      //   this.user = res.data
      // }
    },
    async getUserRecordAction(id: number) {
      return getUserRecord({ id })
        .then((res) => {
          if (res.code === 200) {
            this.record = res.data
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

      // const res = await getUserRecord({ id })
      // if (res.code === 200) {
      //   this.record = res.data
      // }
    },
    async getUserArticleListAction(id: number) {
      const params = {
        id,
        ...this.articlePage
      }
      return getUserArticleList(params)
        .then((res) => {
          if (res.code === 200) {
            this.articleList = res.data
            this.articlePage = res.page as IPage
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

      // const res = await getUserArticleList(params)
      // if (res.code === 200) {
      //   this.articleList = res.data
      //   this.articlePage = res.page as IPage
      // }
    },
    async getUserCtfListAction(id: number) {
      const params = {
        id,
        ...this.ctfPage
      }
      return getUserCtfRecordList(params)
        .then((res) => {
          if (res.code === 200) {
            this.ctfList = res.data
            // this.ctfPage = res.page as IPage
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
      // const res = await getUserCtfRecordList(params)
      // if (res.code === 200) {
      //   this.ctfList = res.data
      // }
    }
  }
})

export default useIndexUserStore
