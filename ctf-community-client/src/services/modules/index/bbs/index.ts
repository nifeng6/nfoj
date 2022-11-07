import request from '@/services/request'
import type { IArticle, IDataType, IArticleParams, IArticleType } from './types'

export const getArticleList = (params: IArticleParams) => {
  return request.get<IDataType<IArticle[]>>({
    url: '/index/bbs/list',
    params
  })
}

export const getArticleTypeList = () => {
  return request.get<IDataType<IArticleType[]>>({
    url: '/index/bbs/type/list'
  })
}
