<template>
  <div class="menu">
    <el-menu
      :default-active="$route.path"
      class="el-menu-vertical-demo"
      router
      :collapse="isFold"
    >
      <h1>NFOJ</h1>
      <template v-for="item in menuList" :key="item.id">
        <template v-if="item.menuType === 'C'">
          <el-menu-item :index="item.path">
            <i :class="`iconfont ${item.icon}`"></i>
            <span>{{ item.name }}</span>
          </el-menu-item>
        </template>

        <template v-else-if="item.menuType === 'M'">
          <el-sub-menu :index="item.path">
            <template #title>
              <i :class="`iconfont ${item.icon}`"></i>
              <span>{{ item.name }}</span>
            </template>

            <template v-for="subitem in item.childMenuList" :key="subitem.id">
              <el-menu-item :index="subitem.path">
                <i :class="`iconfont ${subitem.icon}`"></i>
                <span>{{ subitem.name }}</span>
              </el-menu-item>
            </template>
          </el-sub-menu>
        </template>
      </template>

      <div style="width: 200px"></div>
    </el-menu>
  </div>
</template>

<script setup lang="ts">
import useAdminGlobalStore from '@/stores/modules/admin/global/index'
import { storeToRefs } from 'pinia'

const adminGlobalStore = useAdminGlobalStore()

const { menuList } = storeToRefs(adminGlobalStore)
defineProps({
  isFold: {
    type: Boolean,
    default: false
  }
})
</script>

<style scoped lang="less">
.menu {
  background-color: #fff;
  .el-menu {
    border-right: none;
    height: 100vh;
    h1 {
      text-align: center;
      font-size: 20px;
      font-weight: 600;
      margin: 40px 0;
      display: inline-block;
      width: 100%;
    }
    .iconfont {
      margin-right: 10px;
    }
  }
}
</style>
