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
      <div class="subject-content">
        <el-timeline>
          <el-timeline-item v-for="item in newLabList" :key="item.id">
            <div class="subject-item">
              <span>
                <span>上线了</span>
                <span>{{ item.title }}</span>
                <span>题目</span>
              </span>
              <span class="subject-item-time"
                >{{ timeBeautifulFormat(item.createTime) }}
              </span>
            </div>
          </el-timeline-item>
        </el-timeline>
      </div>
    </el-card>
  </div>
</template>

<script setup lang="ts">
import { CollectionTag } from '@element-plus/icons-vue'
import useIndexHomeStore from '@/stores/modules/index/home'
import { storeToRefs } from 'pinia'
import { timeBeautifulFormat } from '@/utils/format-time'

const indexHomeStore = useIndexHomeStore()

const { newLabList } = storeToRefs(indexHomeStore)
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

  .subject-item {
    display: flex;
    justify-content: space-between;
    margin-bottom: 10px;
    font-size: 14px;

    .subject-item-time {
      font-size: 13px;
      color: #909399;
    }
  }
}
</style>
