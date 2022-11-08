<template>
  <el-card>
    <div class="user-record">
      <div class="user-record-item">
        <p>{{ record.articleCount }}</p>
        <span>文章数</span>
      </div>
      <div class="user-record-item">
        <p>{{ record.safeRecordCount }}</p>
        <span>解题数</span>
      </div>
      <div class="user-record-item">
        <p>{{ record.coinCount }}</p>
        <span>金币数</span>
      </div>
    </div>
  </el-card>
</template>

<script setup lang="ts">
import useIndexUserStore from '@/stores/modules/index/user'
import { storeToRefs } from 'pinia'
const indexUserStore = useIndexUserStore()

const { record } = storeToRefs(indexUserStore)
</script>

<style scoped lang="less">
.user-record {
  display: flex;
  justify-content: space-between;
  .user-record-item {
    display: flex;
    flex-direction: column;
    align-items: center;
    p {
      font-size: 20px;
      color: #333;
      margin-bottom: 10px;
    }
    span {
      font-size: 12px;
    }
  }
}
</style>
