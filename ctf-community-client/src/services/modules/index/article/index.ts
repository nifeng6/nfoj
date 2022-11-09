import request from '@/services/request'
import type { IDataType, IArticle, IArticleParams } from './types'

export const getArticleDetail = (params: IArticleParams) => {
  return request.get<IDataType<IArticle>>({
    url: '/index/article/detail',
    params
  })
}
