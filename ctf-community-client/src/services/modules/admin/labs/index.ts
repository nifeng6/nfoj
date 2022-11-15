import request from '@/services/request'
import type { ILabsListParams, IDataType, ILabsData } from '@/types/admin/labs'

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
