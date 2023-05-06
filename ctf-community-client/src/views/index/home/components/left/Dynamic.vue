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
      <div class="dynamic-content">
        <el-timeline>
          <el-timeline-item
            color="#409eff"
            size="large"
            v-for="(item, index) in dynamicList"
            :key="index"
          >
            <div class="timeline-item">
              <span>用户开启了 {{ item.safeLabs.title }} 靶场</span>
              <span class="item-time">
                {{ timeBeautifulFormat(item.createTime) }}
              </span>
            </div>
          </el-timeline-item>
        </el-timeline>
      </div>
    </el-card>
  </div>
</template>

<script setup lang="ts">
import { ChatLineSquare } from '@element-plus/icons-vue'
import useIndexHomeStore from '@/stores/modules/index/home'
import { storeToRefs } from 'pinia'
import { timeBeautifulFormat } from '@/utils/format-time'
import { Flag } from '@element-plus/icons-vue'

const indexHomeStore = useIndexHomeStore()
const { dynamicList } = storeToRefs(indexHomeStore)
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
  .dynamic-content {
    ::v-deep .el-timeline-item__node--large {
      // padding: 10px;
    }
  }
  .timeline-item {
    display: flex;
    justify-content: space-between;
    .item-time {
      color: #a7abc3;
      font-size: 13px;
    }
  }
}
</style>
