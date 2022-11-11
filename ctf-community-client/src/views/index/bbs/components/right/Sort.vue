<template>
  <el-card class="article-sort">
    <template #header> <span class="title">文章分类</span> </template>
    <ul class="sort-list">
      <li class="sort-item" @click="typeClickHandle(0)">
        <span>所有文章</span>
        <el-icon><ArrowRight /></el-icon>
      </li>
      <li
        class="sort-item"
        v-for="item in articleTypeList"
        :key="item.id"
        @click="typeClickHandle(item.id)"
      >
        <span>{{ item.name }}</span>
        <el-icon><ArrowRight /></el-icon>
      </li>
    </ul>
  </el-card>
</template>

<script setup lang="ts">
import useIndexBbsStore from '@/stores/modules/index/bbs'
import { storeToRefs } from 'pinia'
import { ArrowRight } from '@element-plus/icons-vue'

const indexBbsStore = useIndexBbsStore()
const { articleTypeList, currentType } = storeToRefs(indexBbsStore)

const typeClickHandle = (activeType: number) => {
  currentType.value = activeType
  indexBbsStore.getArticleListAction()
  console.log(activeType)
}
</script>

<style lang="less" scoped>
.article-sort {
  ::v-deep .el-card__header,
  ::v-deep .el-card__body {
    padding: 10px 20px;
  }

  .title {
    font-size: 16px;
    font-weight: 600;
  }

  .sort-list {
    .sort-item {
      font-size: 15px;
      padding: 5px;
      display: flex;
      justify-content: space-between;
      color: #34495e;
      cursor: pointer;
      &:hover {
        background-color: #f5f5f5;
        font-weight: 600;
      }
    }
  }
}
</style>
