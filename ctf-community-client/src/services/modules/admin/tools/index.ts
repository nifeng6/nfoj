import request from '@/services/request'
import type {
  IToolsListParams,
  IDataType,
  IToolsData,
  IUpdateToolsParams,
  IAddToolsParams,
  IToolsType
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

export function addTools(data: IAddToolsParams) {
  return request.post<IDataType>({
    url: '/admin/tools/add',
    data
  })
}

export function updateTools(data: IUpdateToolsParams) {
  return request.post<IDataType>({
    url: '/admin/tools/update',
    data
  })
}

export function getToolsTypeList() {
  return request.get<IDataType<IToolsType[]>>({
    url: '/admin/tools/type/list'
  })
}
