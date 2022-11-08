import request from '@/services/request'
import type { IDataType, ILoginParams, ILogin, IDataContent } from './types'

export const getLogin = (data: ILoginParams) => {
  return request.post<IDataType<ILogin>>({
    url: '/common/account/login',
    data
  })
}

export const getUserInfo = () => {
  return request.post<IDataType<IDataContent>>({
    url: '/common/account/info'
  })
}
