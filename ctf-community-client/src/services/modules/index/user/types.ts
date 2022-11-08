export interface IDataType<T = any> {
  data: T
  code: number
  page?: IPage
}

export interface IUser {
  id: number
  username: string
  createTime: string
}

export interface IUserRecord {
  articleCount: number
  safeRecordCount: number
  coinCount: number
}

export interface IPage {
  currentPage: number
  pageSize: number
  total: number
  pages: number
}
