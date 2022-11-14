<template>
  <el-breadcrumb separator="/">
    <el-breadcrumb-item :to="{ path: '/admin' }">主页</el-breadcrumb-item>
    <el-breadcrumb-item>{{ $route.meta.title }}</el-breadcrumb-item>
  </el-breadcrumb>
</template>

<script setup lang="ts"></script>

<style scoped lang="less">
.el-breadcrumb {
  display: flex;
  height: 100%;
}
</style>
