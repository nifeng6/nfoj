import axios from 'axios'
import type { AxiosInstance, AxiosRequestConfig } from 'axios'
import { BASE_URL, TIMEOUT } from './config'
import NProgress from 'nprogress'
import 'nprogress/nprogress.css'

class MainRequest {
  instance: AxiosInstance
  constructor(baseURL: string, timeout: number = 10000) {
    this.instance = axios.create({
      baseURL,
      timeout
    })

    this.instance.interceptors.request.use(
      (config) => {
        NProgress.start()
        // 给请求添加token
        const token = localStorage.getItem('token')
        if (token) {
          config.headers!.Authorization = token
        }
        return config
      },
      (err) => {
        return err
      }
    )

    this.instance.interceptors.response.use(
      (config) => {
        NProgress.done()
        return config
      },
      (err) => {
        return err
      }
    )
  }

  request<T>(config: AxiosRequestConfig): Promise<T> {
    return new Promise((resolve, reject) => {
      this.instance.request(config).then(
        (res) => {
          resolve(res.data)
        },
        (err) => {
          reject(err)
        }
      )
    })
  }

  get<T>(config: AxiosRequestConfig): Promise<T> {
    return this.request({ ...config, method: 'GET' })
  }

  post<T>(config: AxiosRequestConfig): Promise<T> {
    return this.request({ ...config, method: 'POST' })
  }
}

export default new MainRequest(BASE_URL, TIMEOUT)
