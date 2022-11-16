import request from '@/services/request'
import type {
  ILabsListParams,
  IDataType,
  ILabsData,
  ILabsTypeData,
  ILabsDockerData
} from '@/types/admin/labs'

export function getList(params: ILabsListParams) {
  return request.get<IDataType<ILabsData[]>>({
    url: '/admin/labs/list',
    params
  })
}

export function deleteById(id: number) {
  return request.delete<IDataType>({
    url: '/admin/labs/delete',
    params: {
      id
    }
  })
}

export function deleteList(ids: string) {
  return request.delete<IDataType>({
    url: '/admin/labs/delete/list',
    params: {
      ids
    }
  })
}

export function getLabsTypeList() {
  return request.get<IDataType<ILabsTypeData[]>>({
    url: '/admin/labs/type/list'
  })
}

export function getLabsDockerList() {
  return request.get<IDataType<ILabsDockerData[]>>({
    url: '/admin/labs/rule/list'
  })
}

export function addLabs(data: any) {
  return request.post<IDataType>({
    url: '/admin/labs/add',
    data
  })
}

export function updateLabs(data: any) {
  return request.post<IDataType>({
    url: '/admin/labs/update',
    data
  })
}
