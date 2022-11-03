import mainRequest from '../request'

export function getHomeMultidata() {
  return mainRequest.get({
    url: '/home/multidata'
  })
}
