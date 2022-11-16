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

export interface IUserListParams {
  currentPage: number
  pageSize: number
  keywords?: string
}

export interface IUserData {
  id: number
  username: string
  nickName: string
  coin: number
  avatarUrl: string
  email: string
  phone: string
  createTime: string
  description: string
  status: number
}

export interface IAddUserParams {
  username: string
  nickName: string
  coin: number
  avatarUrl: string
  email: string
  phone: string
  description: string
  status: number
}

export interface IUpdateUserParams {
  id: number
  username: string
  nickName: string
  coin: number
  avatarUrl: string
  email: string
  phone: string
  description: string
  status: number
}
