export interface IDataType<T = any> {
  code: number
  data: T
  msg: string
}

export interface ILoginParams {
  username: string
  password: string
  captchaCode: string
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
  role: IRole
}

export interface IRole {
  id: number
  name: string
  createTime: string
  updateTime: string
  roleKey: string
}

export interface IRegisterParams {
  username: string
  password: string
  email: string
}

// export interface ILoginForm {
//   username: string
//   password: string
//   captchaCode: string
// }

export interface IRegisterForm {
  username: string
  password: string
  email: string
  emailCode: string
  repassword: string
}

export interface IResetPasswordParams {
  password: string
  emailCode: string
  username: string
}
