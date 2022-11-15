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
import useAdminLabsDockerStore from '@/stores/modules/admin/labs-docker/index'
import { storeToRefs } from 'pinia'

const adminLabsDockerStore = useAdminLabsDockerStore()
const { page } = storeToRefs(adminLabsDockerStore)
</script>

<style scoped lang="less"></style>
