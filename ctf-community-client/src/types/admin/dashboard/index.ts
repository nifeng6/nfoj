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

export interface IDashboardCountListData {
  userCount: number
  articleCount: number
  todayRecordCount: number
}
