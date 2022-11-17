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
import useAdminRoleStore from '@/stores/modules/admin/role/index'
import { storeToRefs } from 'pinia'

const adminRoleStore = useAdminRoleStore()
const { page } = storeToRefs(adminRoleStore)
</script>

<style scoped lang="less"></style>
