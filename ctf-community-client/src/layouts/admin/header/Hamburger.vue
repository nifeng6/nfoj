<template>
  <div class="hamburger">
    <el-icon @click="HamburgerHandle">
      <component :is="isFold ? Expand : Fold" />
    </el-icon>
  </div>
</template>

<script setup lang="ts">
import { Fold, Expand } from '@element-plus/icons-vue'
import useAdminGlobalStore from '@/stores/modules/admin/global/index'
import { storeToRefs } from 'pinia'

const adminGlobalStore = useAdminGlobalStore()

const { isFold } = storeToRefs(adminGlobalStore)

const HamburgerHandle = () => {
  isFold.value = !isFold.value
}
</script>

<style scoped lang="less">
.hamburger {
  display: flex;
  align-items: center;
  margin-right: 5px;
  font-size: 20px;
  cursor: pointer;
}
</style>
