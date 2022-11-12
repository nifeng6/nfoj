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

export interface IRegisterParams {
  username: string
  password: string
  email: string
}

export interface ILoginForm {
  username: string
  password: string
  captchaCode: string
}

export interface IRegisterForm {
  username: string
  password: string
  email: string
  emailCode: string
  repassword: string
}
