<template>
  <div class="dynamic">
    <el-card class="notice" shadow="never">
      <template #header>
        <div class="dynamic-title">
          <span class="title-text">
            <el-icon><ChatLineSquare /></el-icon>
            <span>动态</span>
          </span>
        </div>
      </template>
    </el-card>
  </div>
</template>

<script setup lang="ts">
import { ChatLineSquare } from '@element-plus/icons-vue'
</script>

<style scoped lang="less">
.dynamic {
  margin: 15px 0;
  ::v-deep .el-card__header {
    padding: 10px 20px;
  }
  .dynamic-title {
    display: flex;
    justify-content: space-between;
    align-items: center;
    color: #409eff;
    font-family: Raleway;
    .title-text {
      display: flex;
      align-items: center;
      span {
        margin-left: 5px;
      }
    }
  }
}
</style>
