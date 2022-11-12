import request from '@/services/request'
import type {
  IDataType,
  ILoginParams,
  ILogin,
  IDataContent,
  IUser,
  IRegisterParams,
  IResetPasswordParams
} from '@/types/common/account/index'

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

export const updateUserInfo = (data: IUser) => {
  return request.post<IDataType>({
    url: '/common/account/update',
    data
  })
}

export const registerUser = (data: IRegisterParams) => {
  return request.post<IDataType>({
    url: '/common/account/register',
    data
  })
}

export const registerEmailSend = (data: { email: string }) => {
  return request.post<IDataType>({
    url: '/common/account/register/email',
    data
  })
}

export const resetPasswordEmailSend = (data: { email: string }) => {
  return request.post<IDataType>({
    url: '/common/account/reset/password/email',
    data
  })
}

export const resetPassword = (data: IResetPasswordParams) => {
  return request.post<IDataType>({
    url: '/common/account/reset/password',
    data
  })
}
