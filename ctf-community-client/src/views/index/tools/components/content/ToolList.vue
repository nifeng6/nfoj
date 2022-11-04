<template>
  <div class="tool-list">
    <el-row :gutter="10">
      <template v-for="item in 10" :key="item">
        <el-col :span="6"> <ToolItem /></el-col>
      </template>
    </el-row>
    <div class="pagination">
      <el-pagination
        background
        layout="prev, pager, next"
        :page-size="pageParam.size"
        :total="pageParam.total"
        :current-page="pageParam.currentPage"
        @current-change="currentChangeHandle"
      ></el-pagination>
    </div>
  </div>
</template>

<script setup lang="ts">
import ToolItem from './ToolItem.vue'
import { ref } from 'vue'

const pageParam = ref({
  currentPage: 1,
  size: 10,
  total: 0
})

const currentChangeHandle = () => {}
</script>

<style scoped lang="less">
.tool-list {
  .pagination {
    display: flex;
    justify-content: right;
    margin-top: 10px;
  }
}
</style>
