<template>
  <el-dialog width="30%" v-model="addDialogVisible">
    <template #header>
      <span>增加文章</span>
    </template>
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

const { editForm, addDialogVisible } = storeToRefs(adminBbsReplyStore)
</script>

<style scoped lang="less"></style>
