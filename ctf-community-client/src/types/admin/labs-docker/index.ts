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

export interface ILabsDockerListParams {
  currentPage: number
  pageSize: number
  keywords?: string
}

export interface ILabsDockerData {
  id: number
  createShell: string
  flagAddr: string
  intro: string
  nginxShell: string
  introText: string
}
