import request from '@/services/request'
import type {
  IDataType,
  IToolTag,
  IToolType,
  ITool,
  IToolListParams
} from './types'

export const getToolTagList = () => {
  return request.get<IDataType<IToolTag[]>>({
    url: '/index/tools/tag/list'
  })
}

export const getToolTypeList = () => {
  return request.get<IDataType<IToolType[]>>({
    url: '/index/tools/type/list'
  })
}

export const getToolList = (params: IToolListParams) => {
  return request.get<IDataType<ITool[]>>({
    url: '/index/tools/list',
    params
  })
}
