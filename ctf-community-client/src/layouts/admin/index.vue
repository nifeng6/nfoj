<template>
  <div class="admin">
    <el-container>
      <el-aside width="auto">
        <Menu :isFold="isFold" />
      </el-aside>
      <el-container>
        <el-header>
          <Header />
        </el-header>
        <el-main>
          <router-view v-slot="{ Component }">
            <!-- <transition name="el-fade-in"> -->
              <component :is="Component" />
            <!-- </transition> -->
          </router-view>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script setup lang="ts">
import Menu from './menu/index.vue'
import Header from './header/index.vue'
import useAdminGlobalStore from '@/stores/modules/admin/global/index'
import { storeToRefs } from 'pinia'

const adminGlobalStore = useAdminGlobalStore()

const { isFold } = storeToRefs(adminGlobalStore)
</script>

<style scoped lang="less">
.admin {
  ::v-deep .el-header {
    height: 50px;
    background-color: #f9f9f9;
  }
}
</style>
