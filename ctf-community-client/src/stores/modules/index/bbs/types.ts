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

export interface IArticleType {
  id: number
  name: string
}

export interface IArticleParams {
  title: string
  tags: string
  sortId: number
  content: string
}
