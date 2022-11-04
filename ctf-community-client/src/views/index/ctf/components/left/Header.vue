<template>
  <div class="header">
    <h3 class="title">靶场挑战</h3>
    <el-input class="h-search">
      <template #append>
        <el-button>搜索</el-button>
      </template>
    </el-input>
    <el-button round type="primary"> 随机选一题 </el-button>
  </div>
</template>

<script setup lang="ts"></script>

<style scoped lang="less">
.header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 20px;
  .h-search {
    width: 35%;
  }
  .title {
    font-size: 20px;
    font-weight: 500;
  }
}
</style>
