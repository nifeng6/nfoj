<template>
  <div class="article">
    <ArticleDetail></ArticleDetail>
    <ArticleReply></ArticleReply>
  </div>
</template>

<script setup lang="ts">
import ArticleDetail from './components/article-detail/index.vue'
import ArticleReply from './components/article-reply/index.vue'
import useIndexArticleStore from '@/stores/modules/index/article'
import { useRoute } from 'vue-router'

const route = useRoute()
const indexArticleStore = useIndexArticleStore()

const articleId = route.params.article_id

indexArticleStore.getArticleDetailAction(Number.parseInt(articleId as string))
indexArticleStore.getArticleReplyListAction(Number.parseInt(articleId as string))
</script>

<style scoped lang="less">
.article {
  max-width: 1250px;
  margin: 20px auto;
}
</style>
