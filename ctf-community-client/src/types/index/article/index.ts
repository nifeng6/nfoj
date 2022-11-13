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

export interface IArticleReplyParams {
  pageSize: number
  currentPage: number
  id: number
}

export interface IArticleReply {
  id: number
  content: string
  userId: number
  articleId: number
  createTime: string
  replyId: number
  replyUserName: string
  user: IUser
  replyUser: IUser
  replyList: IArticleReply[]
}

export interface IArticleAddReplyParams {
  content: string
  articleId: number
  replyId?: number
  replyUserId?: number
  replyFatherId?: number
  type: number
}

export interface IArticleParams {
  title: string
  tags: string
  sortId: number
  content: string
}
