<template>
  <div class="tools">
    <h2 class="title">工具下载</h2>
    <Search></Search>
    <Content></Content>
  </div>
</template>

<script setup lang="ts">
import Search from './components/search/index.vue'
import Content from './components/content/index.vue'
</script>

<style scoped lang="less">
.tools {
  max-width: 1250px;
  margin: 20px auto;
  .title {
    font-size: 1.3rem;
    font-weight: 500;
    margin-bottom: 20px;
  }
}
</style>
