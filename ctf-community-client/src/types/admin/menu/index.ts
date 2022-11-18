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

export interface IMenuParams {
  currentPage: number
  pageSize: number
  keywords?: string
}

export interface IAddMenuParams {
  id: number
  name: string
  path: string
  status: number
  icon: string
  parentId: number
  permission: string
}

export interface IUpdateMenuParams {
  id: number
  name: string
  path: string
  status: number
  icon: string
  parentId: number
  permission: string
}
