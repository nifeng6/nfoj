import request from '@/services/request'
import type {
  ILabsDockerListParams,
  IDataType,
  ILabsDockerData
} from '@/types/admin/labs-docker'

export function getList(params: ILabsDockerListParams) {
  return request.get<IDataType<ILabsDockerData[]>>({
    url: '/admin/labs/docker/list',
    params
  })
}

export function deleteById(id: number) {
  return request.delete<IDataType>({
    url: '/admin/labs/docker/delete',
    params: {
      id
    }
  })
}

export function deleteList(ids: string) {
  return request.delete<IDataType>({
    url: '/admin/labs/docker/delete/list',
    params: {
      ids
    }
  })
}
