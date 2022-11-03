import axios from 'axios'
import type { AxiosInstance, AxiosRequestConfig } from 'axios'
import { BASE_URL, TIMEOUT } from './config'

class MainRequest {
  instance: AxiosInstance
  constructor(baseURL: string, timeout: number = 10000) {
    this.instance = axios.create({
      baseURL,
      timeout
    })

    this.instance.interceptors.request.use(
      (config) => {
        return config
      },
      (err) => {
        return err
      }
    )

    this.instance.interceptors.response.use(
      (config) => {
        return config
      },
      (err) => {
        return err
      }
    )
  }

  request(config: AxiosRequestConfig) {
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

  get(config: AxiosRequestConfig) {
    return this.request({ ...config, method: 'GET' })
  }

  post(config: AxiosRequestConfig) {
    return this.request({ ...config, method: 'POST' })
  }
}

export default new MainRequest(BASE_URL, TIMEOUT)
