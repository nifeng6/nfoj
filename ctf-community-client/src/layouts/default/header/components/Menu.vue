<template>
  <div class="menu">
    <el-menu
      :default-active="$router.currentRoute.value.path"
      router
      mode="horizontal"
      style="height: 100%"
    >
      <el-menu-item index="/home">
        <i class="iconfont icon-shouye iconnav"></i> 首页
      </el-menu-item>
      <el-menu-item index="/ctf">
        <i class="iconfont icon-flag iconnav"></i>安全靶场
      </el-menu-item>
      <el-menu-item index="/tools">
        <i class="iconfont icon-Tool iconnav"></i>工具下载
      </el-menu-item>
      <el-menu-item index="/coder">
        <i class="iconfont icon-codelibrary iconnav"></i>在线编程
      </el-menu-item>
      <el-menu-item index="/bbs">
        <i class="iconfont icon-community iconnav"></i>社区
      </el-menu-item>
    </el-menu>
  </div>
</template>

<script setup lang="ts"></script>

<style scoped lang="less">
.menu {
  flex: 1;

  .iconnav{
    margin-right: 5px;
  }
  .el-menu--horizontal{
    border-bottom: 0;
  }
}
</style>
