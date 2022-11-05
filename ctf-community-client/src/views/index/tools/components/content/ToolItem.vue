<template>
  <div class="tool-item">
    <el-card class="box-card" shadow="hover" style="min-height: 230px">
      <h4 class="title">{{ itemData.title }}</h4>
      <div class="des">
        <span>{{ itemData.intro }}</span>
      </div>
      <div class="tag">
        <template v-for="(item, index) in itemData.tags.split(',')" :key="item">
          <el-tag :type="tags_type[index % 5]" class="tag-item">{{
            item
          }}</el-tag>
        </template>
      </div>

      <div class="tex">
        <el-button type="primary" @click="goSite(itemData.website)"
          >官方地址</el-button
        >
        <el-button type="primary" @click="goSite(itemData.download)"
          >下载地址</el-button
        >
      </div>
    </el-card>
  </div>
</template>

<script setup lang="ts">
import type { ITool } from './types'
defineProps<{
  itemData: ITool
}>()

const tags_type = ['success', 'info', 'warning', 'danger', '']

const goSite = (url: string) => {
  window.open(url)
}
</script>

<style scoped lang="less">
.tool-item {
  margin-bottom: 10px;
  text-align: center;
  &:hover {
    cursor: pointer;
  }
  ::v-deep .el-card__body {
    height: 100%;
    min-height: 200px;
    display: flex;
    flex-direction: column;
    height: 100%;
    justify-content: space-between;
  }
  .des {
    color: rgba(0, 0, 0, 0.45);
    font-size: 13px;
    margin: 20px 0 10px 0;
    span {
      overflow: hidden;
      text-overflow: ellipsis;
      display: -webkit-box;
      -webkit-line-clamp: 3;
      -webkit-box-orient: vertical;
    }
  }
  .tag {
    overflow: hidden;
    text-overflow: ellipsis;
    display: -webkit-box;
    -webkit-line-clamp: 2;
    -webkit-box-orient: vertical;
    .tag-item {
      margin: 0px 5px 5px 0px;
    }
  }
  .tex {
    display: flex;
    justify-content: space-between;
    margin-top: 5px;
  }
}
</style>
