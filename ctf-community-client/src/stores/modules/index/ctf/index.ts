import { defineStore } from 'pinia'
import {
  getCtfTypeList,
  getCtfTagList,
  getCtfList,
  startCtfLab,
  getCtfLabDetail,
  closeCtfLab,
  submitFlag
} from '@/services'
import type {
  ICtfType,
  ICtfTag,
  ICtfList,
  IPage
} from '@/types/index/ctf/index'
import { ElNotification } from 'element-plus'
import 'element-plus/theme-chalk/el-notification.css'

const useIndexCtfStore = defineStore('index-ctf', {
  state: () => ({
    ctfTypeList: [] as Array<ICtfType>,
    ctfTagList: [] as Array<ICtfTag>,
    ctfList: [] as Array<ICtfList>,
    page: {
      currentPage: 1,
      pageSize: 10,
      total: 0,
      pages: 0
    } as IPage,
    currentType: 0,
    keywords: '',
    labInfo: {
      intro: '',
      expTime: 0,
      isExist: 0,
      isSuccess: 0,
      labId: 0
    },
    startLabLoading: false,
    closeLabLoading: false,
    labDetailLoading: false
  }),
  actions: {
    async getCtfTypeListAction() {
      return getCtfTypeList()
        .then((res) => {
          if (res.code === 200) {
            this.ctfTypeList = res.data
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
    },
    // 获取靶场标签列表
    async getCtfTagListAction() {
      return getCtfTagList()
        .then((res) => {
          if (res.code === 200) {
            this.ctfTagList = res.data
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
    },
    // 获取靶场列表
    async getCtfListAction() {
      const params = {
        currentPage: this.page.currentPage,
        pageSize: this.page.pageSize,
        type: this.currentType,
        keywords: this.keywords
      }
      return getCtfList(params)
        .then((res) => {
          if (res.code === 200) {
            this.ctfList = res.data
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
      // const res = await getCtfList(params)
      // this.ctfList = res.data
      // this.page = { ...res.page } as IPage
    },
    // 开启靶场
    async startCtfLabAction(labId: number) {
      this.startLabLoading = true
      this.labInfo.labId = labId

      return startCtfLab(labId)
        .then((res) => {
          if (res.code === 200) {
            this.labInfo.intro = res.data.intro
            this.labInfo.expTime = res.data.expTime
            this.labInfo.isSuccess = res.data.isSuccess
            this.labInfo.isExist = res.data.isExist
            ElNotification.success({
              title: '成功',
              message: res.msg
            })
            this.startLabLoading = false
            return true
          } else {
            ElNotification.error({
              title: '失败',
              message: res.msg
            })
            this.startLabLoading = false
            return false
          }
        })
        .catch(() => {
          ElNotification.error({
            title: '失败',
            message: '网络连接失败，请重试或联系管理员'
          })
          this.startLabLoading = false
          return false
        })

      // const res = await startCtfLab(labId)
      // if (res.code === 200) {
      //   this.labInfo.intro = res.data.intro
      //   this.labInfo.expTime = res.data.expTime
      //   this.labInfo.isSuccess = res.data.isSuccess
      //   this.labInfo.isExist = res.data.isExist
      //   ElMessage.success('开启成功')
      //   this.startLabLoading = false
      //   return true
      // } else {
      //   ElMessage.error('开启失败')
      //   this.startLabLoading = false
      //   return false
      // }
    },
    // 关闭靶场
    async closeCtfLabAction(labId: number) {
      this.closeLabLoading = true
      this.labInfo.labId = labId
      return closeCtfLab(labId)
        .then((res) => {
          if (res.code === 200) {
            this.labInfo.intro = ''
            this.labInfo.expTime = 0
            this.labInfo.isExist = 0
            ElNotification.success({
              title: '成功',
              message: res.msg
            })
            this.closeLabLoading = false
            return true
          } else {
            ElNotification.error({
              title: '失败',
              message: res.msg
            })
            this.closeLabLoading = false
            return false
          }
        })
        .catch(() => {
          ElNotification.error({
            title: '失败',
            message: '网络连接失败，请重试或联系管理员'
          })
          this.closeLabLoading = false
          return false
        })

      // const res = await closeCtfLab(labId)
      // if (res.code === 200) {
      //   this.labInfo.intro = ''
      //   this.labInfo.expTime = 0
      //   this.labInfo.isExist = 0
      //   ElMessage.success('关闭成功')
      //   this.closeLabLoading = false
      //   return true
      // } else {
      //   ElMessage.error('关闭失败')
      //   this.closeLabLoading = false
      //   return false
      // }
    },
    // 获取靶场详情
    async getCtfLabDetailAction(labId: number) {
      this.labDetailLoading = true
      this.labInfo.labId = labId

      return getCtfLabDetail(labId)
        .then((res) => {
          if (res.code === 200) {
            this.labInfo.intro = res.data.intro
            this.labInfo.isExist = res.data.isExist
            this.labInfo.expTime = res.data.expTime
            this.labInfo.isSuccess = res.data.isSuccess
            this.labDetailLoading = false
            return true
          } else {
            ElNotification.error({
              title: '失败',
              message: res.msg
            })
            this.labDetailLoading = false
            return false
          }
        })
        .catch(() => {
          ElNotification.error({
            title: '失败',
            message: '网络连接失败，请重试或联系管理员'
          })
          this.labDetailLoading = false
          return false
        })

      // const res = await getCtfLabDetail(labId)
      // if (res.code === 200) {
      //   this.labInfo.intro = res.data.intro
      //   this.labInfo.isExist = res.data.isExist
      //   this.labInfo.expTime = res.data.expTime
      //   this.labInfo.isSuccess = res.data.isSuccess
      //   this.labDetailLoading = false
      //   return true
      // } else {
      //   this.labDetailLoading = false
      //   return false
      // }
    },
    // 提交flag
    async submitFlagAction(flag: string) {
      return submitFlag(this.labInfo.labId, flag)
        .then((res) => {
          if (res.code === 200) {
            ElNotification.error({
              title: '成功',
              message: res.msg
            })
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

      // const res = await submitFlag(this.labInfo.labId, flag)
      // if (res.code === 200) {
      //   ElMessage.success(res.msg)
      //   return true
      // } else {
      //   ElMessage.error(res.msg)
      //   return false
      // }
    }
  }
})

export default useIndexCtfStore
