import request from '@/services/request'
import type { IDataType, IUser, IUserRecord, ICtfRecord } from './types'

export const getUserInfo = (params: object) => {
  return request.get<IDataType<IUser>>({
    url: '/index/user/info',
    params
  })
}

export const getUserRecord = (params: object) => {
  return request.get<IDataType<IUserRecord>>({
    url: '/index/user/record',
    params
  })
}

export const getUserArticleList = (params: object) => {
  return request.get<IDataType>({
    url: '/index/user/article/list',
    params
  })
}

export const getUserCtfRecordList = (params: object) => {
  return request.get<IDataType<ICtfRecord[]>>({
    url: '/index/user/ctf/list',
    params
  })
}
