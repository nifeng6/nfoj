<template>
  <el-dialog width="30%" v-model="editDialogVisible">
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
      <el-button @click="editDialogVisible = false">取消</el-button>
      <el-button type="primary" @click="updateClickHandle">确认更新</el-button>
    </template>
  </el-dialog>
</template>

<script setup lang="ts">
import useAdminMenuStore from '@/stores/modules/admin/menu/index'
import { storeToRefs } from 'pinia'
import { ref } from 'vue'

const formData = ref({
  name: '',
  path: '',
  status: 0,
  icon: '',
  parentId: 0,
  permission: ''
})

const adminMenuStore = useAdminMenuStore()

const { editDialogVisible, editActiveItem } = storeToRefs(adminMenuStore)

watch(editActiveItem, () => {
  formData.value = {
    ...editActiveItem.value
  }
})

const updateClickHandle = () => {
  const data = {
    id: editActiveItem.value.id,
    ...formData.value
  }
  adminMenuStore.updateToolsAction(data)
}
</script>

<style scoped lang="less"></style>
