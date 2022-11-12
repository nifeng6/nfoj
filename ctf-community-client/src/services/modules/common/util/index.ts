import request from '@/services/request'

export const getCaptchaCode = () => {
  return request.get({
    url: '/common/util/captcha'
  })
}
