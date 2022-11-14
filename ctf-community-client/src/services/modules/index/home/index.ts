import request from '@/services/request'
import type {
  INoticeData,
  IDataType,
  IDynamicData,
  ISafeLab,
  IWeekRecordData
} from '@/types/index/home/index'

export const getNoticeList = (params: {
  currentPage: number
  pageSize: number
}) => {
  return request.get<IDataType<INoticeData[]>>({
    url: '/index/home/notice/list',
    params
  })
}

export const getDynamicList = (params: {
  currentPage: number
  pageSize: number
}) => {
  return request.get<IDataType<IDynamicData[]>>({
    url: '/index/home/dynamic/list',
    params
  })
}

export const getNewLabList = (params: {
  currentPage: number
  pageSize: number
}) => {
  return request.get<IDataType<ISafeLab[]>>({
    url: '/index/home/lab/list',
    params
  })
}

export const getWeekRecord = () => {
  return request.get<IDataType<IWeekRecordData>>({
    url: '/index/home/week/record'
  })
}
