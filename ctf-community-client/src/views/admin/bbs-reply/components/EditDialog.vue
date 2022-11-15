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
import useAdminBbsReplyStore from '@/stores/modules/admin/bbs-reply/index'
import { storeToRefs } from 'pinia'

const adminBbsReplyStore = useAdminBbsReplyStore()

const { editForm, editDialogVisible } = storeToRefs(adminBbsReplyStore)
</script>

<style scoped lang="less"></style>
