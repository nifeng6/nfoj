import request from '@/services/request'
import type {
  IArticleListParams,
  IDataType,
  IArticleData
} from '@/types/admin/bbs-article'

export function getArticleList(params: IArticleListParams) {
  return request.get<IDataType<IArticleData[]>>({
    url: '/admin/bbs/article/list',
    params
  })
}

export function deleteArticle(id: number) {
  return request.delete<IDataType>({
    url: '/admin/bbs/article/delete',
    params: {
      id
    }
  })
}

export function deleteArticleList(ids: string) {
  return request.delete<IDataType>({
    url: '/admin/bbs/article/delete/list',
    params: {
      ids
    }
  })
}
