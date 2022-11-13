export interface ICoinRecord {
  id: number
  userId: number
  amount: number
  count: number
  createTime: string
  remark: string
}

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
