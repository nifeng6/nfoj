export interface ICtfType {
  id: number
  name: string
}

export interface ICtfList {
  id: number
  title: string
  needCoin: number
  count: number
  successCount: number
}

export interface IPage {
  currentPage: number
  pageSize: number
  total: number
  pages: number
}
