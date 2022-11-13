<template>
  <div class="submit-record">
    <el-card class="notice" shadow="never">
      <template #header>
        <div class="record-title">
          <span class="title-text">
            <el-icon><DataLine /></el-icon>
            <span>近一周解题记录</span>
          </span>
        </div>
      </template>
    </el-card>
  </div>
</template>

<script setup lang="ts">
import { DataLine } from '@element-plus/icons-vue'
</script>

<style scoped lang="less">
.submit-record {
  margin: 15px 0;
  ::v-deep .el-card__header {
    padding: 10px 20px;
  }
  .record-title {
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
