<template>
  <el-dialog v-model="editDialogVisible">
    <el-form>
      <el-form-item label="标题">
        <el-input v-model="editForm.title" />
      </el-form-item>
      <el-form-item label="内容">
        <el-input v-model="editForm.content" />
      </el-form-item>
    </el-form>
  </el-dialog>
</template>

<script setup lang="ts">
import useAdminBbsArticleStore from '@/stores/modules/admin/bbs-article/index'
import { storeToRefs } from 'pinia'

const adminBbsArticleStore = useAdminBbsArticleStore()

const { editForm, editDialogVisible } = storeToRefs(adminBbsArticleStore)
</script>

<style scoped lang="less"></style>
