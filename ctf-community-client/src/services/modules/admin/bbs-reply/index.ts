import request from '@/services/request'
import type {
  IReplyListParams,
  IDataType,
  IReplyData,
  IUpdateReplyParams
} from '@/types/admin/bbs-reply'

export function getList(params: IReplyListParams) {
  return request.get<IDataType<IReplyData[]>>({
    url: '/admin/bbs/reply/list',
    params
  })
}

export function deleteById(id: number) {
  return request.delete<IDataType>({
    url: '/admin/bbs/reply/delete',
    params: {
      id
    }
  })
}

export function deleteList(ids: string) {
  return request.delete<IDataType>({
    url: '/admin/bbs/reply/delete/list',
    params: {
      ids
    }
  })
}

export function updateById(data: IUpdateReplyParams) {
  return request.post<IDataType>({
    url: '/admin/bbs/reply/update',
    data
  })
}
