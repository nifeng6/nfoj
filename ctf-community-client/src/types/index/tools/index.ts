// 响应参数
export interface IDataType<T = any> {
  data: T
  code: number
  msg: string
  page?: IPage
}

export interface IToolTag {
  id: number
  name: string
}

export interface IToolType {
  id: number
  name: string
}

export interface ITool {
  id: number
  title: string
  url: string
  tags: string
  intro: string
  website: string
  download: string
  createTime: number
  updateTime: number
  avatarUrl: string
}

export interface IPage {
  currentPage: number
  pageSize: number
  total: number
  pages: number
}

export interface IToolListParams {
  currentPage: number
  pageSize: number
  type: number
  keywords: string
}
