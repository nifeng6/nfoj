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
  name: string
  createShell: string
  flagAddr: string
  intro: string
  nginxShell: string
}

export interface ILabsDockerParams {
  name: string
  createShell: string
  flagAddr: string
  intro: string
  nginxShell: string
}

export interface IUpdateLabsDockerParams {
  id: number
  name: string
  createShell: string
  flagAddr: string
  intro: string
  nginxShell: string
}
