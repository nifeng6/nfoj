<template>
  <div class="index">
    <Header />
    <router-view v-slot="{ Component }">
      <transition name="el-fade-in-linear">
        <component :is="Component" />
      </transition>
    </router-view>
    <Footer />
  </div>
</template>

<script setup lang="ts">
import Header from './header/index.vue'
import Footer from './footer/index.vue'
import useCommonAccountStore from '@/stores/modules/common/account'
import { storeToRefs } from 'pinia'
const commonAccountStore = useCommonAccountStore()

const { token } = storeToRefs(commonAccountStore)
// token 存在的时候，获取用户信息
if (!!token.value) {
  commonAccountStore.getUserInfoAction()
}
</script>

<style scoped lang="less">
@import 'https://at.alicdn.com/t/font_3205350_f2ywh1x8td.css';
</style>
