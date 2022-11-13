import request from '@/services/request'
import type {
  IDataType,
  ICodeRunParams,
  ICodeRun,
  ICodeShare,
  ICodeShareParams
} from '@/types/index/coder/index'

export const codeRun = (data: ICodeRunParams) => {
  return request.post<IDataType<ICodeRun>>({
    url: '/index/coder/run',
    data
  })
}

export const shareCode = (data: ICodeShareParams) => {
  return request.post<IDataType<ICodeShare>>({
    url: '/index/coder/share/code',
    data
  })
}

export const getShareCode = (key: string) => {
  return request.get<IDataType<any>>({
    url: '/index/coder/share/code/detail',
    params: {
      key
    }
  })
}
