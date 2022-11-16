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
        <template v-if="item.childMenuList.length === 0">
          <el-menu-item :index="item.path">
            <i :class="`iconfont ${item.icon}`"></i>
            <span>{{ item.name }}</span>
          </el-menu-item>
        </template>

        <template v-else>
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

      <!-- <el-menu-item index="/admin/dashboard">
        <el-icon><Histogram /></el-icon>
        <span>仪表盘</span>
      </el-menu-item>

      <el-sub-menu class="bbs">
        <template #title>
          <el-icon><Comment /></el-icon>
          <span>社区管理</span>
        </template>
        <el-menu-item index="/admin/bbs-article">
          <el-icon><Document /></el-icon>
          <span>文章管理</span>
        </el-menu-item>
        <el-menu-item index="/admin/bbs-reply">
          <el-icon><ChatLineRound /></el-icon>
          <span>评论管理</span>
        </el-menu-item>
      </el-sub-menu>

      <el-sub-menu index="labs">
        <template #title>
          <el-icon><Flag /></el-icon>
          <span>靶场管理</span>
        </template>
        <el-menu-item index="/admin/labs">
          <el-icon><Orange /></el-icon>
          <span>靶场配置</span>
        </el-menu-item>

        <el-menu-item index="/admin/labs-docker">
          <el-icon><Guide /></el-icon>
          <span>容器规则</span>
        </el-menu-item>
      </el-sub-menu> -->

      <div style="width: 200px"></div>
    </el-menu>
  </div>
</template>

<script setup lang="ts">
import {
  Histogram,
  UserFilled,
  Tools,
  Flag,
  Comment,
  Document,
  ChatLineRound,
  Orange,
  Guide,
  TakeawayBox
} from '@element-plus/icons-vue'
import useAdminMenuStore from '@/stores/modules/admin/menu/index'
import { storeToRefs } from 'pinia'

const adminMenuStore = useAdminMenuStore()

const { menuList } = storeToRefs(adminMenuStore)
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
