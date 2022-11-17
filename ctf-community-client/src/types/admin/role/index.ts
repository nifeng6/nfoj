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

export interface IRoleParams {
  currentPage: number
  pageSize: number
  keywords?: string
}

export interface IRoleData {
  id: number
  name: string
  createTime: string
  updateTime: string
  roleKey: string
}

export interface IAddRoleParams {
  name: string
  roleKey: string
}

export interface IUpdateRoleParams {
  id: number
  name: string
  roleKey: string
}
