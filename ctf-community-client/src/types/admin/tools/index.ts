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

export interface IToolsListParams {
  currentPage: number
  pageSize: number
  keywords?: string
  type?: number
}

export interface IToolsData {
  id: number
  title: string
  intro: string
  tags: string
  createTime: string
  website: string
  download: string
  avatarUrl: string
  type: IToolsType
}

export interface IToolsType {
  id: number
  name: string
}

