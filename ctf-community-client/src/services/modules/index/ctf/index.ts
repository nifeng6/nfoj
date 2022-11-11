import request from '@/services/request'
import type {
  IDataType,
  ICtfType,
  ICtfTag,
  ICtfList,
  ICtfListParams
} from '@/types/index/ctf/index'

export const getCtfTypeList = () => {
  return request.get<IDataType<ICtfType[]>>({
    url: '/index/ctf/type/list'
  })
}

// 获取页面标签数据
export const getCtfTagList = () => {
  return request.get<IDataType<ICtfTag[]>>({
    url: '/index/ctf/tag/list'
  })
}

// 获取靶场列表
export const getCtfList = (params: ICtfListParams) => {
  return request.get<IDataType<ICtfList[]>>({
    url: `/index/ctf/list`,
    params
  })
}

// 开启靶场
export const startCtfLab = (labId: number) => {
  return request.post<IDataType>({
    url: '/index/ctf/start/lab',
    data: {
      labId
    }
  })
}

// 关闭靶场
export const closeCtfLab = (labId: number) => {
  return request.post<IDataType>({
    url: '/index/ctf/close/lab',
    data: {
      labId
    }
  })
}

// 获取靶场详情
export const getCtfLabDetail = (labId: number) => {
  return request.post<IDataType>({
    url: '/index/ctf/lab/detail',
    data: {
      labId
    }
  })
}

// 提交flag
export const submitFlag = (labId: number, flag: string) => {
  return request.post<IDataType>({
    url: '/index/ctf/submit/flag',
    data: {
      labId,
      flag
    }
  })
}
