<template>
  <div class="echart-line">
    <BaseEchart :option="option" />
  </div>
</template>

<script setup lang="ts">
import { computed } from 'vue'
import BaseEchart from './Base.vue'
const props = defineProps<{
  width: String
  height: String
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

const option = {
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
    data: legendData
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
  series: seriesData
}
</script>

<style scoped lang="less"></style>
