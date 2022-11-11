<template>
  <div class="header">
    <div class="wrapper">
      <Logo></Logo>
      <Menu></Menu>
      <Avatar></Avatar>
    </div>
  </div>
</template>

<script setup lang="ts">
import Avatar from './components/Avatar.vue'
import Logo from './components/Logo.vue'
import Menu from './components/Menu.vue'
</script>

<style scoped lang="less">
.header {
  background-color: #fff;
  height: 55px;
  box-shadow: 0 1px 4px rgb(0 21 41 / 8%);
  border-bottom: 1px solid rgb(0 21 41 / 8%);
  .wrapper {
    max-width: 1250px;
    height: 100%;
    margin: 0 auto;
    display: flex;
    justify-content: space-between;
  }
}
</style>
