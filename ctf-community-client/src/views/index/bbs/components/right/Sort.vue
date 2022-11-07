<template>
  <el-card class="article-sort">
    <template #header> <span class="title">文章分类</span> </template>
    <ul class="sort-list">
      <li class="sort-item" @click="typeClickHandle(0)">所有文章</li>
      <li
        class="sort-item"
        v-for="item in articleTypeList"
        :key="item.id"
        @click="typeClickHandle(item.id)"
      >
        {{ item.name }}
      </li>
    </ul>
  </el-card>
</template>

<script setup lang="ts">
import useIndexBbsStore from '@/stores/modules/index/bbs'
import { storeToRefs } from 'pinia'

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
      padding: 5px;
      cursor: pointer;
      &:hover {
        background-color: #f5f5f5;
      }
    }
  }
}
</style>
