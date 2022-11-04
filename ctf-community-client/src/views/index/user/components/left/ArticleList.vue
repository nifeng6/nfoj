<template>
  <div class="article-list">
    <ArticleCard style="cursor: pointer">
      <template #leftTop>
        <div class="top">sqli-libs</div>
      </template>
      <template #leftBottom>
        <div class="bottom">
          <span>创建时间:8个月前</span>
          <span></span>
        </div>
      </template>
      <template #rightBottom>
        <div class="bottom">分类：基础技能</div>
      </template>
    </ArticleCard>
  </div>
</template>

<script setup lang="ts">
import ArticleCard from '@/components/index/ArticleCard/index.vue'

const itemData = {
  title: 'sqli-libs'
}
</script>

<style scoped lang="less">
.article-list {
  .top {
    margin-bottom: 10px;
  }

  .bottom {
    color: rgb(162, 162, 162);
    font-size: 13px;
  }
}
</style>
