<template>
  <div class="search">
    <el-input
      placeholder="搜索工具..."
      v-model="keywords"
      class="select-tools"
      size="large"
    >
      <template #append>
        <el-button color="#1890ff" @click="searchHandle">
          <el-icon>
            <Search />
          </el-icon>
        </el-button>
      </template>
    </el-input>
    <div class="hot-tags" style="margin-top: 12px; text-align: center">
      <span style="font-weight: bolder"> 热门标签： </span>

      <span
        v-for="item in toolTagList"
        :key="item.name"
        :index="item.name"
        class="tag-item"
        @click="tagClickHandle(item.name)"
      >
        <el-tag type="info"
          ><span>{{ item.name }}</span></el-tag
        >
      </span>
    </div>
  </div>
</template>

<script setup lang="ts">
import { storeToRefs } from 'pinia'
import useIndexToolStore from '@/stores/modules/index/tools'
import { Search } from '@element-plus/icons-vue'

const indexToolStore = useIndexToolStore()

const { toolTagList, keywords } = storeToRefs(indexToolStore)

const searchHandle = () => {
  indexToolStore.getToolListAction()
}

const tagClickHandle = (key: string) => {
  keywords.value = key
  indexToolStore.getToolListAction()
}
</script>

<style scoped lang="less">
.search {
  margin: 0 auto;
  width: 45%;

  .tag-item {
    margin-right: 8px;
    margin-bottom: 8px;
    padding: 0 7px;
    font-size: 12px;
    display: inline-block;
    cursor: pointer;
  }
}
</style>
