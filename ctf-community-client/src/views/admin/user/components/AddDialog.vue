<template>
  <el-dialog width="30%" v-model="addDialogVisible">
    <template #header>
      <span>增加文章</span>
    </template>
    <el-form> </el-form>
  </el-dialog>
</template>

<script setup lang="ts">
import useAdminUserStore from '@/stores/modules/admin/user/index'
import { storeToRefs } from 'pinia'

const adminUserStore = useAdminUserStore()

const {addDialogVisible } = storeToRefs(adminUserStore)
</script>

<style scoped lang="less"></style>
