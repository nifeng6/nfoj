// 响应参数
export interface IDataType<T = any> {
  data: T
  code: number
  msg: string
  page?: IPage
}

export interface IArticle {
  id: number
  title: string
  tags: string
  typeId: number
  userId: number
  view: number
  createTime: string
  updateTime: string
}

export interface IPage {
  currentPage: number
  pageSize: number
  total: number
  pages: number
}

export interface IArticleParams {
  currentPage: number
  pageSize: number
  type: number
  keywords: string
}

export interface IArticleType {
  id: number
  name: string
}

export interface IArticleAddParams {
  title: string
  tags: string
  typeId: number
  content: string
}
