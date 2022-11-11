<template>
  <div class="hot-tag">
    <el-card style="margin-left: 15px">
      <template #header>
        <span> 热门标签 </span>
      </template>
      <el-tag
        class="tag-item"
        :type="tag_type[Math.ceil(Math.random() * 10)]"
        
        effect="dark"
        v-for="item in ctfTagList"
        :key="item.id"
        >{{ item.name }}</el-tag
      >

      <!-- <el-button class="s-tag-c" @click="randomSelect"> 随机来一题 </el-button> -->
    </el-card>
  </div>
</template>

<script lang="ts" setup>

import { storeToRefs } from 'pinia'
import useIndexCtfStore from '@/stores/modules/index/ctf'

const indexCtfStore = useIndexCtfStore()

const { ctfTagList } = storeToRefs(indexCtfStore)

const tag_type = [
  '',
  '',
  'success',
  'info',
  'danger',
  'warning',
  'success',
  'info',
  'danger',
  'warning',
  ''
]
</script>

<style scoped lang="less">
.hot-tag {
  .tag-item {
    margin: 5px;
  }
}
</style>
