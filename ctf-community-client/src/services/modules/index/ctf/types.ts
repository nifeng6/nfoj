// 响应参数
export interface IDataType<T = any> {
  data: T
  code: number
  page?: IPage
}

export interface ICtfType {
  id: number
  name: string
}

export interface ICtfTag {
  id: number
  name: string
}

export interface ICtfList {
  id: number
  title: string
  needCoin: number
  count: number
  successCount: number
}

export interface IPage {
  currentPage: number
  pageSize: number
  total: number
  pages: number
}


// 请求参数
export interface ICtfListParams {
  currentPage: number
  pageSize: number
}
