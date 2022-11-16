<template>
  <el-dialog width="30%" v-model="addDialogVisible">
    <template #header>
      <span>增加规则</span>
    </template>
    <el-form>
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
      <el-button @click="addDialogVisible = false">取消</el-button>
      <el-button type="primary" @click="confirmClickHandle">确认添加</el-button>
    </template>
  </el-dialog>
</template>

<script setup lang="ts">
import useAdminLabsDockerStore from '@/stores/modules/admin/labs-docker/index'
import { storeToRefs } from 'pinia'
import { ref } from 'vue'

const formData = ref(formSource())

const adminLabsDockerStore = useAdminLabsDockerStore()

const { addDialogVisible } = storeToRefs(adminLabsDockerStore)

function formSource() {
  return {
    name: '',
    createShell: '',
    flagAddr: '',
    intro: '',
    nginxShell: ''
  }
}

const confirmClickHandle = () => {
  adminLabsDockerStore.addLabsDockerAction({ ...formData.value })
}
</script>

<style scoped lang="less"></style>
