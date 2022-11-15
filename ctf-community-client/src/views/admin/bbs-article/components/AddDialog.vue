<template>
  <el-dialog width="30%" v-model="addDialogVisible">
    <template #header>
      <span>增加文章</span>
    </template>
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

const { editForm, addDialogVisible } = storeToRefs(adminBbsArticleStore)
</script>

<style scoped lang="less"></style>
