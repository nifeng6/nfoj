<template>
  <div class="sort">
    <el-menu
      class="el-menu-vertical"
      :default-active="String(currentType)"
      @select="selectHandle"
    >
      <el-menu-item :index="0 + ''">
        <span>全部工具</span>
      </el-menu-item>
      <el-menu-item
        v-for="item in toolTypeList"
        :key="String(item.id)"
        :index="String(item.id)"
      >
        <span>{{ item.name }}</span>
      </el-menu-item>
    </el-menu>
  </div>
</template>

<script setup lang="ts">
import { storeToRefs } from 'pinia'
import useIndexToolStore from '@/stores/modules/index/tools'

const indexToolStore = useIndexToolStore()

const { toolTypeList, currentType } = storeToRefs(indexToolStore)

const selectHandle = (index: any) => {
  currentType.value = index
  indexToolStore.getToolListAction()
}
</script>

<style scoped lang="less">
.sort {
  border-radius: 5px;
  overflow: hidden;

  .el-menu {
    border-right: 0;
  }
}
</style>
