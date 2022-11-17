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
import useAdminMenuStore from '@/stores/modules/admin/menu/index'
import { storeToRefs } from 'pinia'

const adminMenuStore = useAdminMenuStore()
const { page } = storeToRefs(adminMenuStore)
</script>

<style scoped lang="less"></style>
