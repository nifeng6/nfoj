<template>
  <el-dialog width="30%" v-model="addDialogVisible">
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
      <el-button @click="addDialogVisible = false">取消</el-button>
      <el-button type="primary" @click="confirmClickHandle">确认添加</el-button>
    </template>
  </el-dialog>
</template>

<script setup lang="ts">
import useAdminRoleStore from '@/stores/modules/admin/role/index'
import { storeToRefs } from 'pinia'
import { ref } from 'vue'

const formData = ref(formSource())

const adminRoleStore = useAdminRoleStore()

const { addDialogVisible } = storeToRefs(adminRoleStore)

const confirmClickHandle = () => {
  const data = {
    ...formData.value
  }
  adminRoleStore.addToolsAction(data)
}

function formSource() {
  return {
    name: '',
    roleKey: ''
  }
}
</script>

<style scoped lang="less"></style>
