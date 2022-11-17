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

export interface IArticleListParams {
  currentPage: number
  pageSize: number
  keywords?: string
  type?: number
  createTime?: string
}

export interface IArticleData {
  id: number
  title: string
  content: string
  tags: string
  type: IArticleType
  user: IUser
  view: number
  typeId: number
  createTime: string
  updateTime: string
}

export interface IArticleType {
  id: number
  name: string
}

export interface IUser {
  id: number
  username: string
  nickeName: string
  createTime: string
  avatarUrl: string
}

export interface IArticleParams {
  title: string
  tags: string
  typeId: number
  content: string
}

export interface IUpdateArticleParams {
  id: number
  title: string
  tags: string
  typeId: number
  content: string
}
