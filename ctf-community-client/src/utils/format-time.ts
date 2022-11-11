import dayjs from 'dayjs'

//  秒数转化为时分秒
export const formatSeconds = (second: number) => {
  //  分
  let minute = 0
  //  小时
  let hour = 0
  //  天
  //  let day = 0
  //  如果秒数大于60，将秒数转换成整数
  if (second > 60) {
    //  获取分钟，除以60取整数，得到整数分钟
    minute = second / 60
    //  获取秒数，秒数取佘，得到整数秒数
    second = second % 60
    //  如果分钟大于60，将分钟转换成小时
    if (minute > 60) {
      //  获取小时，获取分钟除以60，得到整数小时
      hour = minute / 60
      //  获取小时后取佘的分，获取分钟除以60取佘的分
      minute = minute % 60
    }
  }

  minute = Math.floor(minute)
  second = Math.floor(second)
  hour = Math.floor(hour)

  let result = '' + second
  if (minute > 0) {
    result = '' + minute + ':' + result
  }
  if (hour > 0) {
    result = '' + hour + ':' + result
  }

  return result
}

export function timeBeautifulFormat(timestamp: any) {
  var mistiming = Math.round(
    (Date.now() - new Date(timestamp).getTime()) / 1000
  )
  var postfix = mistiming > 0 ? '前' : '后'
  mistiming = Math.abs(mistiming)
  var arrr = ['年', '个月', '星期', '天', '小时', '分钟', '秒']
  var arrn = [31536000, 2592000, 604800, 86400, 3600, 60, 1]

  for (var i = 0; i < 7; i++) {
    var inm = Math.floor(mistiming / arrn[i])
    if (inm != 0) {
      return inm + arrr[i] + postfix
    }
  }
}

export function formatTime(date: string, chinese = true) {
  return chinese
    ? dayjs(new Date(date)).format('YYYY年MM月DD日 HH时mm分ss秒')
    : dayjs(new Date(date)).format('YYYY-MM-DD HH:mm:ss')
}
