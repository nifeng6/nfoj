export interface IDataType<T = any> {
  data: T
  code: number
  page?: IPage
}

export interface IPage {
  currentPage: number
  pageSize: number
  total: number
  pages: number
}

export interface IArticleParams {
  id: number
}

export interface IArticle {
  id: number
  title: string
  tags: string
  userId: number
  view: number
  createTime: string
  updateTime: string
  content: string
  user: IUser
  sort: ISort
}

export interface IUser {
  id: number
  username: string
  createTime: string
  avatarUrl: string
}

export interface ISort {
  id: number
  name: string
}
