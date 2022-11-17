<template>
  <el-dialog width="30%" v-model="editDialogVisible">
    <template #header>
      <span>增加文章</span>
    </template>
    <el-form label-width="80px">
      <el-form-item label="角色名">
        <el-input v-model="formData.name" />
      </el-form-item>
      <el-form-item label="权限字符">
        <el-input v-model="formData.roleKey" />
      </el-form-item>
    </el-form>
    <template #footer>
      <el-button @click="editDialogVisible = false">取消</el-button>
      <el-button type="primary" @click="updateClickHandle">确认更新</el-button>
    </template>
  </el-dialog>
</template>

<script setup lang="ts">
import useAdminRoleStore from '@/stores/modules/admin/role/index'
import { storeToRefs } from 'pinia'
import { ref } from 'vue'

const formData = ref({
  name: '',
  roleKey: ''
})

const adminRoleStore = useAdminRoleStore()

const { editDialogVisible, editActiveItem } = storeToRefs(adminRoleStore)

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
  adminRoleStore.updateToolsAction(data)
}
</script>

<style scoped lang="less"></style>
