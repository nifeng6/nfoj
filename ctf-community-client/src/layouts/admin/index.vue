<template>
  <div class="admin">
    <el-container>
      <el-aside width="200px">
        <Menu />
      </el-aside>
      <el-container>
        <el-header>
          <Header />
        </el-header>
        <el-main>
          <RouterView />
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script setup lang="ts">
import Menu from './menu/index.vue'
import Header from './header/index.vue'
</script>

<style scoped lang="less">
.admin {
  ::v-deep .el-header {
    height: 50px;
    background-color: #f9f9f9;
  }
}
</style>
