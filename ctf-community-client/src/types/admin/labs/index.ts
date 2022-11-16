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
  intro: string
  level: number
  label: string
  flag: string
  dockerId: number
  typeId: number
  needCoin: number
  goldCoin: number
  createTime: string
}

export interface IAddLabsListParams {
  title: string
  intro: string
  level: number
  label: string
  flag: string
  needCoin: number
  goldCoin: number
  typeId: number
  dockerId: number
}

export interface ILabsTypeData {
  id: number
  name: string
}

export interface ILabsDockerData {
  id: number
  name: string
  createShell: string
  flagAddr: string
  intro: string
  nginxShell: string
}

export interface IAddLabsParams {
  title: string
  intro: string
  level: number
  label: string
  dockerId: number
  typeId: number
  flag: string
  needCoin: number
  goldCoin: number
}

export interface IUpdateLabsParams {
  id: number
  title: string
  intro: string
  level: number
  label: string
  dockerId: number
  typeId: number
  flag: string
  needCoin: number
  goldCoin: number
}
