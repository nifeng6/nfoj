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
import useAdminLabsStore from '@/stores/modules/admin/labs/index'
import { storeToRefs } from 'pinia'

const adminLabsStore = useAdminLabsStore()
const { page } = storeToRefs(adminLabsStore)
</script>

<style scoped lang="less"></style>
