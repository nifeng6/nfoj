import request from '@/services/request'
import type { IDataType, IUser, IUserRecord } from './types'

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
