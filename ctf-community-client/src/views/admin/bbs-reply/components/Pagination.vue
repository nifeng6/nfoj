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
import useAdminBbsReplyStore from '@/stores/modules/admin/bbs-reply/index'
import { storeToRefs } from 'pinia'

const adminBbsReplyStore = useAdminBbsReplyStore()
const { page } = storeToRefs(adminBbsReplyStore)
</script>

<style scoped lang="less"></style>
