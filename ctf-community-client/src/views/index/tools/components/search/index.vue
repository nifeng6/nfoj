<template>
  <div class="search">
    <el-input
      placeholder="搜索工具..."
      v-model="searchContent"
      class="select-tools"
      size="large"
    >
      <template #append>
        <el-button color="#1890ff"> 搜索 </el-button>
      </template>
    </el-input>
    <div class="hot_tags" style="margin-top: 12px; text-align: center">
      <span style="font-weight: bolder"> 热门标签： </span>

      <span
        v-for="item in toolTagList"
        :key="item.name"
        :index="item.name"
        class="tag-item"
      >
        <el-tag type="info"
          ><el-link :underline="false">{{ item.name }}</el-link></el-tag
        >
      </span>
    </div>
  </div>
</template>

<script setup lang="ts">
import { ref } from 'vue'
import { storeToRefs } from 'pinia'
import useIndexToolStore from '@/stores/modules/index/tools'

const indexToolStore = useIndexToolStore()

const { toolTagList } = storeToRefs(indexToolStore)
const searchContent = ref('')
</script>

<style scoped lang="less">
.search {
  margin: 0 auto;
  width: 45%;

  .tag-item {
    margin-right: 8px;
    margin-bottom: 5px;
    padding: 0 7px;
    font-size: 12px;
    display: inline-block;
  }
}
</style>
