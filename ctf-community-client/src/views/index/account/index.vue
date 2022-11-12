<template>
  <div class="account">
    <el-row :gutter="20">
      <el-col :span="4">
        <Menu></Menu>
      </el-col>
      <el-col :span="20">
        <router-view></router-view>
      </el-col>
    </el-row>
  </div>
</template>

<script setup lang="ts">
import Menu from './components/menu/index.vue'
import usecommonRootStore from '@/stores/modules/common/root'

const commonRootStore = usecommonRootStore()
commonRootStore.changeDomTitle()
</script>

<style lang="less" scoped>
.account {
  max-width: 1250px;
  margin: 20px auto;
  background-color: #fff;
  padding: 20px 0;
  ::v-deep .user_menu {
    min-height: 550px;
  }
}
</style>
