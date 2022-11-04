<template>
  <div class="article">
    <ArticleDetail></ArticleDetail>
    <ArticleReply></ArticleReply>
  </div>
</template>

<script setup lang="ts">
import ArticleDetail from './components/article-detail/index.vue'
import ArticleReply from './components/article-reply/index.vue'
</script>

<style scoped lang="less">
.article {
  max-width: 1250px;
  margin: 20px auto;
}
</style>
