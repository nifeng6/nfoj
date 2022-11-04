<template>
  <el-card class="article-sort">
    <template #header> <span class="title">文章分类</span> </template>
    <ul class="sort-list">
      <li class="sort-item" v-for="item in articleSort" :key="item.id">
        {{ item.name }}
      </li>
    </ul>
  </el-card>
</template>

<script setup lang="ts">
const articleSort = [
  {
    id: 1,
    name: '问答讨论'
  },
  {
    id: 2,
    name: '文章分享'
  },
  {
    id: 3,
    name: '踩坑记录'
  },
  {
    id: 4,
    name: '站内公告'
  }
]
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
