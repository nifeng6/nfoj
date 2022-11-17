<template>
  <div class="btn-list">
    <div class="btn-list-left">
      <el-button :icon="Plus" type="primary" plain @click="addClickHandle"
        >新增</el-button
      >
    </div>
    <div class="btn-list-right">
      <el-button :icon="Refresh" circle @click="flushClickHandle"></el-button>
    </div>
  </div>
</template>

<script setup lang="ts">
import { Plus, Refresh } from '@element-plus/icons-vue'
import useAdminMenuStore from '@/stores/modules/admin/menu/index'
import { ElNotification } from 'element-plus'
import { storeToRefs } from 'pinia'

const adminMenuStore = useAdminMenuStore()

const { addDialogVisible } = storeToRefs(adminMenuStore)

const flushClickHandle = () => {
  adminMenuStore.getListAction().then(() => {
    ElNotification.success({
      title: '刷新成功',
      message: '刷新成功'
    })
  })
}

const addClickHandle = () => {
  addDialogVisible.value = true
}
</script>

<style scoped lang="less">
.btn-list {
  display: flex;
  justify-content: space-between;
  align-items: center;
}
</style>
