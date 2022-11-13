import request from '@/services/request'
import type {
  IArticle,
  IDataType,
  IArticleParams,
  IArticleType,
  IArticleAddParams
} from '@/types/index/bbs/index'

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

export const addArticle = (data: IArticleAddParams) => {
  return request.post<IDataType>({
    url: '/index/bbs/add',
    data
  })
}
