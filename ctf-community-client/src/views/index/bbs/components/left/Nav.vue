<template>
  <div class="nav">
    <div class="breadcrumb">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
        <el-breadcrumb-item>promotion detail</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div class="search">
      <el-input
        placeholder="请输入文章关键词或标签..."
        class="input-with-select"
      >
        <template #append>
          <el-button color="#1890ff">
            <!-- <el-icon><search /></el-icon> -->
            搜索
          </el-button>
        </template>
      </el-input>
    </div>
  </div>
</template>

<script setup lang="ts"></script>

<style lang="less" scoped>
.nav {
  display: flex;
  justify-content: space-between;
  align-items: center;
  background-color: #fff;
  padding: 6px 15px;
}
</style>
