// 响应参数
export interface IDataType<T = any> {
  data: T
  code: number
  page?: IPage
}

export interface IArticle {
  id: number
  title: string
  tags: string
  sortId: number
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

export interface IArticleData {
  title: string
  tags: string
  sortId: number
  content: string
}
