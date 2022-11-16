<template>
  <el-dialog width="30%" v-model="addDialogVisible">
    <template #header>
      <span>增加用户</span>
    </template>
    <el-form label-width="80px">
      <el-form-item label="用户名">
        <el-input
          v-model="formData.username"
          placeholder="请输入用户名"
        ></el-input>
      </el-form-item>
      <el-form-item label="昵称">
        <el-input
          v-model="formData.nickName"
          placeholder="请输入用户昵称"
        ></el-input>
      </el-form-item>

      <el-form-item label="简介">
        <el-input
          v-model="formData.description"
          placeholder="请输入用户简介"
        ></el-input>
      </el-form-item>

      <el-form-item label="邮箱">
        <el-input
          v-model="formData.email"
          placeholder="请输入用户邮箱"
        ></el-input>
      </el-form-item>

      <el-form-item label="手机号">
        <el-input
          v-model="formData.phone"
          placeholder="请输入用户手机号"
        ></el-input>
      </el-form-item>

      <el-form-item label="金币数">
        <el-input
          v-model="formData.coin"
          placeholder="请输入初始化金币数"
        ></el-input>
      </el-form-item>

      <el-form-item label="状态">
        <el-radio-group v-model="formData.status">
          <el-radio :label="1" size="large">正常</el-radio>
          <el-radio :label="0" size="large">停用</el-radio>
        </el-radio-group>
      </el-form-item>
    </el-form>
    <template #footer>
      <el-button @click="addDialogVisible = false">取消</el-button>
      <el-button @click="confirmClickHandle">确认增加</el-button>
    </template>
  </el-dialog>
</template>

<script setup lang="ts">
import useAdminUserStore from '@/stores/modules/admin/user/index'
import { storeToRefs } from 'pinia'
import { ref } from 'vue'

const formData = ref(formSource())

const adminUserStore = useAdminUserStore()

const { addDialogVisible } = storeToRefs(adminUserStore)

function formSource() {
  return {
    username: '',
    nickName: '',
    coin: 0,
    email: '',
    phone: '',
    description: '',
    avatarUrl: '',
    status: 1
  }
}

const confirmClickHandle = () => {
  const data = {
    ...formData.value
  }
  adminUserStore.addUserAction(data)
}
</script>

<style scoped lang="less"></style>
