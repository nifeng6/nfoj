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
  adminMenuIdList: []
}

export interface IAddRoleParams {
  name: string
  roleKey: string
  adminMenuIdList: []
}

export interface IUpdateRoleParams {
  id: number
  name: string
  roleKey: string
  adminMenuIdList: []
}

export interface IMenuData {
  id: number
  name: string
  path: string
  status: number
  icon: string
  createTime: string
  updateTime: string
  parentId: number
  permission: string
  menuType: string
  childMenuList: IMenuData[]
}
