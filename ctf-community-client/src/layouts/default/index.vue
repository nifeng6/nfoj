<template>
  <div class="index">
    <Header />
    <router-view></router-view>
    <Footer />
  </div>
</template>

<script setup lang="ts">
import Header from './header/index.vue'
import Footer from './footer/index.vue'
</script>

<style scoped lang="less">
@import 'https://at.alicdn.com/t/font_3205350_f2ywh1x8td.css';

</style>
