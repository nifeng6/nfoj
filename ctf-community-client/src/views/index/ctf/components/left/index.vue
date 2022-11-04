<template>
  <div class="left">
    <Header></Header>
    <Types></Types>
    <Table></Table>
  </div>
</template>

<script setup lang="ts">
import Header from './Header.vue'
import Types from './Types.vue'
import Table from './Table.vue'
</script>

<style scoped lang="less">
.left {
  background-color: #fff;
  padding: 20px;
}
</style>
