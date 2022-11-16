import request from '@/services/request'
import type {
  ILabsDockerListParams,
  IDataType,
  ILabsDockerData,
  ILabsDockerParams,
  IUpdateLabsDockerParams
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

export function addLabsDocker(data: ILabsDockerParams) {
  return request.post<IDataType>({
    url: '/admin/labs/docker/add',
    data
  })
}

export function updateLabsDocker(data: IUpdateLabsDockerParams) {
  return request.post<IDataType>({
    url: '/admin/labs/docker/update',
    data
  })
}
