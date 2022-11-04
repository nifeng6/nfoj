<template>
  <el-menu
    :default-active="$router.currentRoute.value.path"
    class="user_menu"
    router
  >
    <el-menu-item index="/account/base">
      <el-icon><User /></el-icon>
      <span>基本设置</span>
    </el-menu-item>
    <el-menu-item index="/account/security">
      <el-icon><Lock /></el-icon>
      <span>安全设置</span>
    </el-menu-item>
    <el-menu-item index="/account/coin">
      <el-icon><Coin /></el-icon>
      <span>金币记录</span>
    </el-menu-item>
  </el-menu>
</template>

<script setup lang="ts">
import { Lock, User, Coin } from '@element-plus/icons-vue'
</script>

<style scoped lang="less"></style>
