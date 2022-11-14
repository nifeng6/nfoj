<template>
  <div class="header">
    <div class="header-left">
      <Hamburger />
      <Breadcrumb />
    </div>
    <div class="header-right">
      <Avatar />
    </div>
  </div>
</template>

<script setup lang="ts">
import Breadcrumb from './Breadcrumb.vue'
import Hamburger from './Hamburger.vue'
import Avatar from './Avatar.vue'
</script>

<style scoped lang="less">
.header {
  height: 100%;
  display: flex;
  justify-content: space-between;
  align-items: center;
  .header-left {
    height: 100%;
    display: flex;
  }
  .header-right {
    height: 100%;
  }
}
</style>
