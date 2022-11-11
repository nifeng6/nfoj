<template>
  <div class="tool-list">
    <el-row :gutter="10">
      <template
        v-for="item in toolList"
        :key="item"
        v-if="toolList.length !== 0"
      >
        <el-col :span="6"> <ToolItem :itemData="item" /></el-col>
      </template>
      <template v-else>
        <el-empty class="empty" description="暂无数据" />
      </template>
    </el-row>
    <div class="pagination">
      <el-pagination
        v-if="toolList.length !== 0"
        background
        layout="prev, pager, next"
        :page-size="page.pageSize"
        :total="page.total"
        :current-page="page.currentPage"
        @current-change="currentChangeHandle"
      ></el-pagination>
    </div>
  </div>
</template>

<script setup lang="ts">
import ToolItem from './ToolItem.vue'
import { storeToRefs } from 'pinia'
import useIndexToolStore from '@/stores/modules/index/tools'

const indexToolStore = useIndexToolStore()

const { page, toolList } = storeToRefs(indexToolStore)

const currentChangeHandle = (activePage: number) => {
  page.value.currentPage = activePage
  indexToolStore.getToolListAction()
}
</script>

<style scoped lang="less">
.tool-list {
  .pagination {
    display: flex;
    justify-content: right;
    margin-top: 10px;
  }
  .empty{
    text-align: center;
    width: 100%;
  }
}
</style>
