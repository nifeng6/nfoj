export interface ILogin {
  token: string
}

export interface ILoginParams {
  username: string
  password: string
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
