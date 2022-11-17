import request from '@/services/request'
import type {
  IDataType,
  IRoleData,
  IRoleParams,
  IAddRoleParams,
  IUpdateRoleParams
} from '@/types/admin/role'

export function getList(params: IRoleParams) {
  return request.get<IDataType<IRoleData[]>>({
    url: '/admin/role/list',
    params
  })
}

export function deleteById(id: number) {
  return request.delete<IDataType>({
    url: '/admin/role/delete',
    params: {
      id
    }
  })
}

export function deleteList(ids: string) {
  return request.delete<IDataType>({
    url: '/admin/role/delete/list',
    params: {
      ids
    }
  })
}

export function addRole(data: IAddRoleParams) {
  return request.post<IDataType>({
    url: '/admin/role/add',
    data
  })
}

export function updateRole(data: IUpdateRoleParams) {
  return request.post<IDataType>({
    url: '/admin/role/update',
    data
  })
}
