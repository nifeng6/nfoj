<template>
  <div class="article-list">
    <template v-if="articleList.length !== 0">
      <template v-for="item in articleList" :key="item.id">
        <ArticleCard
          style="cursor: pointer; margin: 10px 0"
          @click="urlHandle(item.id)"
        >
          <template #leftTop>
            <div class="top">{{ item.title }}</div>
          </template>
          <template #leftBottom>
            <div class="bottom">
              <span>创建时间:{{ item.createTime }}</span>
              <span></span>
            </div>
          </template>
          <template #rightBottom>
            <div class="bottom">分类：{{ item.sort.name }}</div>
          </template>
        </ArticleCard>
      </template>
    </template>
    <template v-else>
      <el-empty description="当前用户还未发表过文章~" />
    </template>
  </div>
</template>

<script setup lang="ts">
import ArticleCard from '@/components/index/ArticleCard/index.vue'
import useIndexUserStore from '@/stores/modules/index/user'
import { storeToRefs } from 'pinia'
const indexUserStore = useIndexUserStore()

const { articleList } = storeToRefs(indexUserStore)

const urlHandle = (id: number) => {
  window.open(`/article/${id}`)
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
