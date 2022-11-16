<template>
  <el-dialog width="30%" v-model="editDialogVisible">
    <template #header>
      <span>更新规则</span>
    </template>
    <el-form label-width="80px">
      <el-form-item label="规则名称">
        <el-input v-model="formData.name" />
      </el-form-item>
      <el-form-item label="创建规则">
        <el-input v-model="formData.createShell" />
      </el-form-item>
      <el-form-item label="FLAG地址">
        <el-input v-model="formData.flagAddr" />
      </el-form-item>
      <el-form-item label="简介规则">
        <el-input v-model="formData.intro" />
      </el-form-item>
      <el-form-item label="Nginx规则">
        <el-input v-model="formData.nginxShell" />
      </el-form-item>
    </el-form>

    <template #footer>
      <el-button @click="editDialogVisible = false">取消</el-button>
      <el-button type="primary" @click="confirmClickHandle">确认添加</el-button>
    </template>
  </el-dialog>
</template>

<script setup lang="ts">
import useAdminLabsDockerStore from '@/stores/modules/admin/labs-docker/index'
import { storeToRefs } from 'pinia'
import { ref, watch } from 'vue'

const formData = ref({
  name: '',
  createShell: '',
  flagAddr: '',
  intro: '',
  nginxShell: ''
})

const adminLabsDockerStore = useAdminLabsDockerStore()

const { editDialogVisible, editActiveItem } = storeToRefs(adminLabsDockerStore)

watch(
  editActiveItem,
  () => {
    formData.value = { ...editActiveItem.value }
  },
  {
    deep: true
  }
)

const confirmClickHandle = () => {
  const data = {
    id: editActiveItem.value.id,
    ...formData.value
  }
  adminLabsDockerStore.updateLabsDockerAction(data)
}
</script>

<style scoped lang="less"></style>
