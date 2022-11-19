<template>
  <router-view />
</template>

<script setup lang="ts">
import { nextTick } from 'vue'
import useI18n from '@/hooks/i18n-hook'

onMounted(() => {
  nextTick(() => {
    try {
      document.body.removeChild(document.querySelector('#app-loader')!)
    } catch (e) {}
  })
})

const {
  i18n: { t },
  currentLocale,
  changeLocale
} = useI18n()
</script>

<style scoped lang="less"></style>
