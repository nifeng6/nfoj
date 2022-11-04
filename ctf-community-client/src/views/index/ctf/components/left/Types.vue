<template>
  <div class="type">
    <span>类型：</span>
    <div class="btn-list">
      <el-button
        class="btn"
        :type="currentType == 0 ? 'primary' : ''"
        @click="typeHandle(0)"
        >全部</el-button
      >
      <el-button
        v-for="item in typeList"
        class="btn"
        :key="item.id"
        :type="currentType == item.id ? 'primary' : ''"
        @click="typeHandle(item.id)"
        >{{ item.name }}</el-button
      >
    </div>
  </div>
</template>

<script setup lang="ts">
import { ref } from 'vue'

const typeList = ref([
  { id: 1, name: 'web' },
  { id: 2, name: 'pwn' },
  { id: 3, name: 're' },
  { id: 4, name: 'misc' },
  { id: 5, name: 'crypto' },
  { id: 6, name: 'forensics' },
  { id: 7, name: 'reverse' },
  { id: 8, name: 'stego' },
  { id: 9, name: 'mobile' },
  { id: 10, name: 'network' },
  { id: 11, name: 'other' }
])
const currentType = ref(0)

const typeHandle = (active: number) => {
  currentType.value = active
}
</script>

<style scoped lang="less">
.type {
  margin: 10px 0;
  span {
    margin: 10px 0;
    font-size: 16px;
    position: relative;
    top: -3px;
  }
  .btn-list {
    display: inline;
    .btn {
      margin-right: 10px;
      margin-bottom: 10px;
    }
  }
}
</style>
