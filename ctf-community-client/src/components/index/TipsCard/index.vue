<template>
  <div class="tips-card">
    <slot></slot>
  </div>
</template>

<script lang="ts" setup></script>

<style scoped lang="less">
.tips-card {
  padding: 8px 16px;
  background-color: var(--el-color-primary-light-9);
  border-radius: 4px;
  border-left: 5px solid var(--el-color-primary);
  margin-top: 20px;
  font-size: 12px;
  color: #303133;
}
</style>
