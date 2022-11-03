import type { AxiosRequestConfig } from 'axios'

export interface RequestInterceptor {
  requestInterceptor?: (config: AxiosRequestConfig) => AxiosRequestConfig
  requestInterceptorCatch?: (error: any) => any
  responseInterceptor?: (config: any) => any
  responseInterceptorCatch?: (error: any) => any
}

export interface RequestConfig extends AxiosRequestConfig {
  interceptor?: RequestInterceptor
  showLoading?: boolean
}
