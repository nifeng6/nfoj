<template>
  <div class="menu">
    <el-menu :default-active="$route.path" class="el-menu-vertical-demo" router>
      <h1>NFOJ</h1>
      <el-menu-item index="/admin/dashboard">
        <el-icon><Histogram /></el-icon>
        <span>仪表盘</span>
      </el-menu-item>

      <el-sub-menu>
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

      <el-menu-item index="/admin/labs">
        <el-icon><Flag /></el-icon>
        <span>靶场管理</span>
      </el-menu-item>
      <el-menu-item index="/admin/tools">
        <el-icon><Tools /></el-icon>
        <span>工具管理</span>
      </el-menu-item>
      <el-menu-item index="/admin/user">
        <el-icon><UserFilled /></el-icon>
        <span>用户管理</span>
      </el-menu-item>
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
  ChatLineRound
} from '@element-plus/icons-vue'
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
  }
}
</style>
