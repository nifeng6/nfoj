<template>
  <div class="tools">
    <div class="header-wrapper">
      <div class="wrapper">
        <h2 class="title">工具下载</h2>
        <Search></Search>
      </div>
    </div>
    <Content></Content>
  </div>
</template>

<script setup lang="ts">
import Search from './components/search/index.vue'
import Content from './components/content/index.vue'
import { onMounted } from 'vue'
import useIndexToolStore from '@/stores/modules/index/tools'

onMounted(() => {
  const indexToolStore = useIndexToolStore()

  indexToolStore.getToolTagListAction()
  indexToolStore.getToolTypeListAction()
  indexToolStore.getToolListAction()
})
</script>

<style scoped lang="less">
.tools {
  .header-wrapper {
    background-color: #fff;
    .wrapper {
      max-width: 1250px;
      margin: 0 auto;
      padding: 20px 0;
      .title {
        font-size: 1.3rem;
        font-weight: 500;
        margin-bottom: 20px;
      }
    }
  }
}
</style>
