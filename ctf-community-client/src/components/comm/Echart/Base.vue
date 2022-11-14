<template>
  <div class="echart" ref="divRef" :style="{ width, height }"></div>
</template>

<script setup lang="ts">
import { ref, onMounted, defineProps, watchEffect } from 'vue'
import echartHook from '../../../hooks/echart-hook'
const divRef = ref()

const props = defineProps({
  width: {
    type: String,
    default: '100%'
  },
  height: {
    type: String,
    default: '350px'
  },
  option: {
    type: Object
  }
})

onMounted(() => {
  const { setOption } = echartHook(divRef.value)
  // 指定图表的配置项和数据

  watchEffect(() => {
    setOption(props.option)
  })
})
</script>

<style lang="less" scoped></style>
