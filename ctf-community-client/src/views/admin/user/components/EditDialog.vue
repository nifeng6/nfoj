<template>
  <el-dialog v-model="editDialogVisible">
    <el-form>

    </el-form>
  </el-dialog>
</template>

<script setup lang="ts">
import useAdminUserStore from '@/stores/modules/admin/user/index'
import { storeToRefs } from 'pinia'

const adminUserStore = useAdminUserStore()

const { editForm, editDialogVisible } = storeToRefs(adminUserStore)
</script>

<style scoped lang="less"></style>
