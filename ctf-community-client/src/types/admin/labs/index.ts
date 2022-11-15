export interface IDataType<T = any> {
  code: number
  data: T
  msg: string
  page?: IPage
}

export interface IPage {
  currentPage: number
  pageSize: number
  total: number
  pages: number
}

export interface ILabsListParams {
  currentPage: number
  pageSize: number
  keywords?: string
  type?: number
}

export interface ILabsData {
  id: number
  title: string
  content: string
  level: number
  label: string
  flag: string
  needCoin: number
  goldCoin: number
  createTime: string
}
