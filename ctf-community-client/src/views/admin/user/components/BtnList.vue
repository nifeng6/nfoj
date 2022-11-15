<template>
  <div class="btn-list">
    <div class="btn-list-left">
      <el-button :icon="Plus" type="primary" plain @click="addClickHandle"
        >新增</el-button
      >
      <el-popconfirm
        :title="`确认删除 ${selectList} 文章?`"
        confirm-button-text="确认"
        cancel-button-text="取消"
        @confirm="deleteListClickHandle"
      >
        <template #reference>
          <el-button
            :disabled="selectList.length === 0"
            :icon="Delete"
            type="danger"
            plain
            >删除</el-button
          >
        </template>
      </el-popconfirm>
    </div>
    <div class="btn-list-right">
      <el-button :icon="Refresh" circle @click="flushClickHandle"></el-button>
    </div>
  </div>
</template>

<script setup lang="ts">
import { Plus, Delete, Refresh } from '@element-plus/icons-vue'
import useAdminUserStore from '@/stores/modules/admin/user/index'
import { ElNotification } from 'element-plus'
import { storeToRefs } from 'pinia'

const adminUserStore = useAdminUserStore()

const { selectList, addDialogVisible } = storeToRefs(adminUserStore)

const flushClickHandle = () => {
  adminUserStore.getListAction().then(() => {
    ElNotification.success({
      title: '刷新成功',
      message: '刷新成功'
    })
  })
}

const addClickHandle = () => {
  addDialogVisible.value = true
}

const deleteListClickHandle = () => {
  adminUserStore.deleteListAction()
}
</script>

<style scoped lang="less">
.btn-list {
  display: flex;
  justify-content: space-between;
  align-items: center;
}
</style>
