export interface IDataType<T = any> {
    data: T
    code: number
    page?: IPage
  }
  
  export interface IUser {
    id: number
    username: string
    createTime: string
  }
  
  export interface IUserRecord {
    articleCount: number
    safeRecordCount: number
    coinCount: number
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
    createTime: string
    sort: IArticleSort
  }
  
  export interface IArticleSort {
    id: number
    name: string
  }
  
  export interface ICtfType {
    id: number
    name: string
  }
  
  export interface ICtfLab {
    id: number
    title: string
    intro: string
    type: ICtfType
  }
  
  export interface ICtfRecord {
    id: number
    title: string
    createTime: string
    isSuccess: number
    lab: ICtfLab
  }
  