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
        v-for="item in ctfTypeList"
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

import { storeToRefs } from 'pinia'
import useIndexCtfStore from '@/stores/modules/index/ctf'

const indexCtfStore = useIndexCtfStore()

const { ctfTypeList, currentType } = storeToRefs(indexCtfStore)

// const currentType = ref(0)

const typeHandle = (active: number) => {
  currentType.value = active
  indexCtfStore.getCtfListAction()
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
