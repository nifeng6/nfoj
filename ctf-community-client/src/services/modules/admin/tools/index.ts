import request from '@/services/request'
import type {
  IToolsListParams,
  IDataType,
  IToolsData
} from '@/types/admin/tools'

export function getList(params: IToolsListParams) {
  return request.get<IDataType<IToolsData[]>>({
    url: '/admin/tools/list',
    params
  })
}

export function deleteById(id: number) {
  return request.delete<IDataType>({
    url: '/admin/tools/delete',
    params: {
      id
    }
  })
}

export function deleteList(ids: string) {
  return request.delete<IDataType>({
    url: '/admin/tools/delete/list',
    params: {
      ids
    }
  })
}
