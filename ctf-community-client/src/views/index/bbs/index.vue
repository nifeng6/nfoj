<template>
  <div class="bbs">
    <el-row :gutter="20">
      <el-col :span="18"><Left></Left></el-col>
      <el-col :span="6"><Right></Right></el-col>
    </el-row>
  </div>
</template>

<script setup lang="ts">
import Left from './components/left/index.vue'
import Right from './components/right/index.vue'
</script>

<style scoped lang="less">
.bbs {
  max-width: 1250px;
  margin: 20px auto;
}
</style>
