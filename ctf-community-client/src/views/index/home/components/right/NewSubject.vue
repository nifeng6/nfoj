<template>
  <div class="new-subject">
    <el-card class="notice" shadow="never">
      <template #header>
        <div class="subject-title">
          <span class="title-text">
            <el-icon><CollectionTag /></el-icon>
            <span>最新题目</span>
          </span>
        </div>
      </template>
    </el-card>
  </div>
</template>

<script setup lang="ts">
import { CollectionTag } from '@element-plus/icons-vue'
</script>

<style scoped lang="less">
.new-subject {
//   margin-bottom: 15px;
  ::v-deep .el-card__header {
    padding: 10px 20px;
  }
  .subject-title {
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
