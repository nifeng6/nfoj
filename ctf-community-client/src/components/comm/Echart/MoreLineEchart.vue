<template>
  <div class="echart-line">
    <BaseEchart :option="option" />
  </div>
</template>

<script setup lang="ts">
import { computed, withDefaults } from 'vue'
import BaseEchart from './Base.vue'

// 设置props 默认值
const props = defineProps<{
  values: Array<{ name: string; data: Array<number> }>
  xData: Array<string>
}>()

const seriesData = computed(() => {
  return props.values.map((item) => {
    return {
      name: item.name,
      type: 'line',
      stack: 'Total',
      areaStyle: {},
      emphasis: {
        focus: 'series'
      },
      data: item.data
    }
  })
})

const legendData = computed(() => {
  return props.values.map((item) => {
    return item.name
  })
})

const option = computed(() => {
  return {
    tooltip: {
      trigger: 'axis',
      axisPointer: {
        type: 'cross',
        label: {
          backgroundColor: '#6a7985'
        }
      }
    },
    legend: {
      data: legendData.value
    },
    toolbox: {
      feature: {
        saveAsImage: {}
      }
    },
    grid: {
      left: '3%',
      right: '4%',
      bottom: '3%',
      containLabel: true
    },
    xAxis: [
      {
        type: 'category',
        boundaryGap: false,
        data: props.xData
      }
    ],
    yAxis: [
      {
        type: 'value'
      }
    ],
    series: seriesData.value
  }
})
</script>

<style scoped lang="less"></style>
