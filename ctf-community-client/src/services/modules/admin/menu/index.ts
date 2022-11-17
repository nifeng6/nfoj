import request from '@/services/request'
import type {
  IMenuData,
  IDataType,
  IAddMenuParams,
  IMenuParams,
  IUpdateMenuParams
} from '@/types/admin/menu'

export function getMenuList() {
  return request.get<IDataType<IMenuData[]>>({
    url: '/admin/menu/role-list'
  })
}

export function getList(params: IMenuParams) {
  return request.get<IDataType<IMenuData[]>>({
    url: '/admin/menu/list',
    params
  })
}

export function deleteById(id: number) {
  return request.delete<IDataType>({
    url: '/admin/menu/delete',
    params: {
      id
    }
  })
}

export function addMenu(data: IAddMenuParams) {
  return request.post<IDataType>({
    url: '/admin/menu/add',
    data
  })
}

export function updateMenu(data: IUpdateMenuParams) {
  return request.post<IDataType>({
    url: '/admin/menu/update',
    data
  })
}
