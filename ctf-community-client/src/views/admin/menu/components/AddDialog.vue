<template>
  <el-dialog width="30%" v-model="addDialogVisible">
    <template #header>
      <span>增加文章</span>
    </template>
    <el-form label-width="80px">
      <el-form-item label="菜单名">
        <el-input v-model="formData.name" />
      </el-form-item>
      <el-form-item label="菜单路径">
        <el-input v-model="formData.path" />
      </el-form-item>

      <el-form-item label="图标">
        <el-input v-model="formData.icon" />
      </el-form-item>

      <el-form-item label="权限字符">
        <el-input v-model="formData.permission" />
      </el-form-item>
    </el-form>
    <template #footer>
      <el-button @click="addDialogVisible = false">取消</el-button>
      <el-button type="primary" @click="confirmClickHandle">确认添加</el-button>
    </template>
  </el-dialog>
</template>

<script setup lang="ts">
import useAdminMenuStore from '@/stores/modules/admin/menu/index'
import { storeToRefs } from 'pinia'
import { ref } from 'vue'

const formData = ref(formSource())

const adminMenuStore = useAdminMenuStore()

const { addDialogVisible } = storeToRefs(adminMenuStore)

const confirmClickHandle = () => {
  const data = {
    ...formData.value
  }
  adminMenuStore.addToolsAction(data)
}

function formSource() {
  return {
    name: '',
    path: '',
    status: 0,
    icon: '',
    parentId: 0,
    permission: ''
  }
}
</script>

<style scoped lang="less"></style>
