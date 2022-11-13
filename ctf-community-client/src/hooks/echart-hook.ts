import * as echarts from 'echarts'
import ChainMapData from '../components/comm/Echart/data/china.json'

echarts.registerMap('china', ChainMapData)

function echartsHook(el: any) {
  const echartsInstance = echarts.init(el)

  const setOption = (option: any) => {
    echartsInstance.setOption(option)
  }

  const setResize = () => {
    echartsInstance.resize()
  }

  window.addEventListener('resize', () => {
    echartsInstance.resize()
  })

  return {
    setOption,
    setResize
  }
}

export default echartsHook
