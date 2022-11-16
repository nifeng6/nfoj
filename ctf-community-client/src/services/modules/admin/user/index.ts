import request from '@/services/request'
import type {
  IUserListParams,
  IDataType,
  IUserData,
  IAddUserParams,
  IUpdateUserParams
} from '@/types/admin/user'

export function getList(params: IUserListParams) {
  return request.get<IDataType<IUserData[]>>({
    url: '/admin/user/list',
    params
  })
}

export function deleteById(id: number) {
  return request.delete<IDataType>({
    url: '/admin/user/delete',
    params: {
      id
    }
  })
}

export function deleteList(ids: string) {
  return request.delete<IDataType>({
    url: '/admin/user/delete/list',
    params: {
      ids
    }
  })
}

export function addUser(data: IAddUserParams) {
  return request.post<IDataType>({
    url: '/admin/user/add',
    data
  })
}

export function updateUser(data: IUpdateUserParams) {
  return request.post<IDataType>({
    url: '/admin/user/update',
    data
  })
}
