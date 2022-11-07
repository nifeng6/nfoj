<template>
  <div class="nav">
    <div class="breadcrumb">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item @click="allHandle">全部</el-breadcrumb-item>
        <el-breadcrumb-item v-if="currentType != 0">{{
          articleTypeList.find((item) => item.id === currentType)?.name
        }}</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div class="search">
      <el-input
        placeholder="请输入文章关键词或标签..."
        class="input-with-select"
        v-model="keywords"
      >
        <template #append>
          <el-button color="#1890ff" @click="searchHandle">
            <!-- <el-icon><search /></el-icon> -->
            搜索
          </el-button>
        </template>
      </el-input>
    </div>
  </div>
</template>

<script setup lang="ts">
import useIndexBbsStore from '@/stores/modules/index/bbs'
import { storeToRefs } from 'pinia'

const indexBbsStore = useIndexBbsStore()

const { keywords, currentType, articleTypeList } = storeToRefs(indexBbsStore)

const searchHandle = () => {
  indexBbsStore.getArticleListAction()
}

const allHandle = () => {
  currentType.value = 0
  keywords.value = ''
  indexBbsStore.getArticleListAction()
}
</script>

<style lang="less" scoped>
.nav {
  display: flex;
  justify-content: space-between;
  align-items: center;
  background-color: #fff;
  padding: 6px 15px;
}
</style>
