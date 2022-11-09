export interface IDataType<T = any> {
  code: number
  data: T
  msg: string
}

export interface ILoginParams {
  username: string
  password: string
}

export interface ILogin {
  token: string
}

export interface IDataContent {
  user: IUser
  permission: Array<string>
}

export interface IUser {
  id: number
  username: string
  nickName: string
  avatarUrl: string
  email: string
  phone: string
  createTime: string
  updateTime: string
  description: string
}
