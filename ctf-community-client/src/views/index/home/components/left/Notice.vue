<template>
  <div class="notice">
    <el-card class="notice" shadow="never">
      <template #header>
        <div class="notice-title">
          <span class="title-text">
            <el-icon>
              <Monitor />
            </el-icon>
            <span>公告</span>
          </span>
          <el-button size="mini" type="primary">刷新</el-button>
        </div>
      </template>
    </el-card>
  </div>
</template>

<script setup lang="ts">
import { Monitor } from '@element-plus/icons-vue'
</script>

<style scoped lang="less">
.notice {
  margin: 15px 0;
  ::v-deep .el-card__header {
    padding: 10px 20px;
  }
  .notice-title {
    display: flex;
    align-items: center;
    justify-content: space-between;
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
