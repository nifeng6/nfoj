import request from '@/services/request'
import type {
  IDataType,
  IArticle,
  IArticleParams,
  IArticleReplyParams,
  IArticleReply,
  IArticleAddReplyParams
} from '@/types/index/article'

export const getArticleDetail = (params: { id: number }) => {
  return request.get<IDataType<IArticle>>({
    url: '/index/article/detail',
    params
  })
}

export const getArticleReplyList = (params: IArticleReplyParams) => {
  return request.get<IDataType<IArticleReply[]>>({
    url: '/index/article/reply/list',
    params
  })
}

export const addArticleReply = (data: IArticleAddReplyParams) => {
  return request.post<IDataType>({
    url: '/index/article/reply/add',
    data
  })
}
