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
        v-for="item in hotTags"
        :key="item.name"
        :index="item.name"
        style="margin-right: 8px; padding: 0 7px; font-size: 12px"
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
const searchContent = ref('')

const hotTags = [
  {
    id: 1,
    name: 'sql注入'
  },
  {
    id: 2,
    name: 'xss'
  },
  {
    id: 3,
    name: 'csrf'
  },
  {
    id: 4,
    name: 'ssrf'
  },
  {
    id: 5,
    name: 'xxe'
  }
]
</script>

<style scoped lang="less">
.search {
  margin: 0 auto;
  width: 45%;
}
</style>
