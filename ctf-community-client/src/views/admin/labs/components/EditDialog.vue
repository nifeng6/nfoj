<template>
  <el-dialog v-model="editDialogVisible">
    <el-form>
      <el-form-item label="内容">
        <el-input v-model="editForm.content" />
      </el-form-item>
    </el-form>
  </el-dialog>
</template>

<script setup lang="ts">
import useAdminLabsStore from '@/stores/modules/admin/labs/index'
import { storeToRefs } from 'pinia'

const adminLabsStore = useAdminLabsStore()

const { editForm, editDialogVisible } = storeToRefs(adminLabsStore)
</script>

<style scoped lang="less"></style>
