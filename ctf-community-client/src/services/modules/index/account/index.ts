import request from '@/services/request'
import type { IDataType, ICoinRecord, IPage } from './types'

export const getAccountCoinRecordList = (params: IPage) => {
  return request.get<IDataType<ICoinRecord[]>>({
    url: '/index/account/coinRecord/list',
    params
  })
}

export const getAccountQiandao = () => {
  return request.post<IDataType>({
    url: '/index/account/qiandao'
  })
}

export const updatePassword = (data: { oldPass: string; newPass: string }) => {
  return request.post<IDataType>({
    url: '/index/account/password/update',
    data
  })
}
