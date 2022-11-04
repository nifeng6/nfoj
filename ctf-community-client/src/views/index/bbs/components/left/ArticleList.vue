<template>
  <div class="article-list">
    <template v-for="item in list" :key="item.id">
      <ArticleItem :itemData="item"></ArticleItem
    ></template>

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
import ArticleItem from './ArticleItem.vue'
import { ref } from 'vue'

const pageParam = ref({
  currentPage: 1,
  size: 10,
  total: 0
})

const list = [
  {
    id: 1,
    title: '标题1',
    content: '内容1',
    createTime: '8个月前',
    sortName: '问答回复',
    nickName: '倪风',
    replyCount: 10,
    views: 100
  },
  {
    id: 2,
    title: '标题1',
    content: '内容1',
    createTime: '8个月前',
    sortName: '问答回复',
    nickName: '倪风',
    replyCount: 10,
    views: 100
  },
  {
    id: 3,
    title: '标题1',
    content: '内容1',
    createTime: '8个月前',
    sortName: '问答回复',
    nickName: '倪风',
    replyCount: 10,
    views: 100
  }
]

const currentChangeHandle = () => {
  console.log(11)
}
</script>

<style lang="less" scoped></style>
