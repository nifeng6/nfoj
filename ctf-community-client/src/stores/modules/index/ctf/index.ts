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
import { ElMessage } from 'element-plus'

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
    },
    async startCtfLabAction(labId: number) {
      this.startLabLoading = true
      this.labInfo.labId = labId
      const res = await startCtfLab(labId)
      if (res.code === 200) {
        this.labInfo.intro = res.data.intro
        this.labInfo.expTime = res.data.expTime
        this.labInfo.isSuccess = res.data.isSuccess
        this.labInfo.isExist = res.data.isExist
        ElMessage.success('开启成功')
        this.startLabLoading = false
        return true
      } else {
        ElMessage.error('开启失败')
        this.startLabLoading = false
        return false
      }
    },
    async closeCtfLabAction(labId: number) {
      this.closeLabLoading = true
      this.labInfo.labId = labId
      const res = await closeCtfLab(labId)
      if (res.code === 200) {
        this.labInfo.intro = ''
        this.labInfo.expTime = 0
        this.labInfo.isExist = 0
        ElMessage.success('关闭成功')
        this.closeLabLoading = false
        return true
      } else {
        ElMessage.error('关闭失败')
        this.closeLabLoading = false
        return false
      }
    },
    async getCtfLabDetailAction(labId: number) {
      this.labDetailLoading = true
      this.labInfo.labId = labId
      const res = await getCtfLabDetail(labId)
      if (res.code === 200) {
        this.labInfo.intro = res.data.intro
        this.labInfo.isExist = res.data.isExist
        this.labInfo.expTime = res.data.expTime
        this.labInfo.isSuccess = res.data.isSuccess
        this.labDetailLoading = false
        return true
      } else {
        this.labDetailLoading = false
        return false
      }
    },
    // 提交flag
    async submitFlagAction(flag: string) {
      const res = await submitFlag(this.labInfo.labId, flag)
      if (res.code === 200) {
        ElMessage.success(res.msg)
        return true
      } else {
        ElMessage.error(res.msg)
        return false
      }
    }
  }
})

export default useIndexCtfStore
