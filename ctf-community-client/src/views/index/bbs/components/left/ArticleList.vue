<template>
  <div class="article-list">
    <template v-for="item in articleList" :key="item.id">
      <ArticleItem :itemData="item" />
    </template>

    <div class="pagination">
      <el-pagination
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
import ArticleItem from './ArticleItem.vue'
import { storeToRefs } from 'pinia'
import useIndexBbsStore from '@/stores/modules/index/bbs'

const indexBbsStore = useIndexBbsStore()
const { articleList, page } = storeToRefs(indexBbsStore)


const currentChangeHandle = (currentPage: number) => {
  indexBbsStore.page.currentPage = currentPage
  indexBbsStore.getArticleListAction()
}

</script>

<style lang="less" scoped></style>
