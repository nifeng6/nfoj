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

export interface IReplyListParams {
  currentPage: number
  pageSize: number
  keywords?: string
  type?: number
}

export interface IReplyData {
  id: number
  content: string
  article: IArticle
  user: IUser
  createTime: string
  updateTime: string
}

export interface IArticle {
  id: number
  title: string
  content: string
  tags: string
  view: number
  createTime: string
  updateTime: string
}

export interface IUser {
  id: number
  username: string
  nickeName: string
  createTime: string
  avatarUrl: string
}
