<template>
  <el-pagination
    style="display: flex; justify-content: right"
    background
    layout="prev, pager, next"
    :total="page.total"
    v-model:currentPage="page.currentPage"
    v-model:page-size="page.pageSize"
  />
</template>

<script setup lang="ts">
import useAdminBbsArticleStore from '@/stores/modules/admin/bbs-article/index'
import { storeToRefs } from 'pinia'

const adminBbsArticleStore = useAdminBbsArticleStore()
const { page } = storeToRefs(adminBbsArticleStore)
</script>

<style scoped lang="less"></style>
