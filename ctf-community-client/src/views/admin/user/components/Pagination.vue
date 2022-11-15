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
import useAdminUserStore from '@/stores/modules/admin/user/index'
import { storeToRefs } from 'pinia'

const adminUserStore = useAdminUserStore()
const { page } = storeToRefs(adminUserStore)
</script>

<style scoped lang="less"></style>
