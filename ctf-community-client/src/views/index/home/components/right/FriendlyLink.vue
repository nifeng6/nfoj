<template>
  <div class="friendly-link">
    <el-card class="notice" shadow="never">
      <template #header>
        <div class="friendly-title">
          <span class="title-text">
            <el-icon><Link /></el-icon>
            <span>友情链接</span>
          </span>
        </div>
      </template>
    </el-card>
  </div>
</template>

<script setup lang="ts">
import { Link } from '@element-plus/icons-vue'
</script>

<style scoped lang="less">
.friendly-link {
    margin: 15px 0;
  ::v-deep .el-card__header {
    padding: 10px 20px;
  }
  .friendly-title {
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
