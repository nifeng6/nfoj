import request from '@/services/request'
import type {
  IDataType,
  ICtfType,
  ICtfTag,
  ICtfList,
  ICtfListParams
} from './types'

export const getCtfTypeList = () => {
  return request.get<IDataType<ICtfType[]>>({
    url: '/index/ctf/type/list'
  })
}

export const getCtfTagList = () => {
  return request.get<IDataType<ICtfTag[]>>({
    url: '/index/ctf/tag/list'
  })
}

export const getCtfList = (params: ICtfListParams) => {
  return request.get<IDataType<ICtfList[]>>({
    url: `/index/ctf/list`,
    params
  })
}
