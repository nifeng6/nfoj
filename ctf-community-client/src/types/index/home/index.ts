export interface IDataType<T = any> {
  data: T
  code: number
  page?: IPage
}

export interface IPage {
  currentPage: number
  pageSize: number
  total: number
  pages: number
}

export interface INoticeData {
  id: number
  title: string
  tags: string
  userId: number
  view: number
  createTime: string
  updateTime: string
  content: string
  user: IUser
  sort: ISort
}

export interface IDynamicData {
  id: number
  createTime: string
  endTime: string
  isSuccess: number
  safeLabs: ISafeLab
  user: IUser
}

export interface ISafeLab {
  id: number
  title: string
  createTime: string
}

export interface IUser {
  id: number
  username: string
  createTime: string
  avatarUrl: string
}

export interface ISort {
  id: number
  name: string
}

export interface IWeekRecordData {
  total: number[]
  time: string[]
  success: number[]
}
