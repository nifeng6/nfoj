<template>
  <el-dialog width="30%" v-model="addDialogVisible">
    <template #header>
      <span>增加文章</span>
    </template>
    <el-form label-width="80px">
      <el-form-item label="工具名">
        <el-input v-model="formData.title" />
      </el-form-item>
      <el-form-item label="工具介绍">
        <el-input v-model="formData.intro" />
      </el-form-item>

      <el-form-item label="网站地址">
        <el-input v-model="formData.website" />
      </el-form-item>
      <el-form-item label="下载地址">
        <el-input v-model="formData.download" />
      </el-form-item>
      <el-form-item label="logo地址">
        <el-input v-model="formData.avatarUrl" />
      </el-form-item>

      <el-form-item label="网站类型">
        <el-select v-model="formData.typeId" placeholder="请选择工具分类">
          <el-option
            v-for="item in toolsTypeList"
            :key="item.id"
            :label="item.name"
            :value="item.id"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="标签">
        <el-select
          v-model="formData.tags"
          multiple
          filterable
          allow-create
          default-first-option
          :reserve-keyword="false"
          placeholder="请输入并选择标签"
        >
        </el-select>
      </el-form-item>
    </el-form>
    <template #footer>
      <el-button @click="addDialogVisible = false">取消</el-button>
      <el-button type="primary" @click="confirmClickHandle">确认添加</el-button>
    </template>
  </el-dialog>
</template>

<script setup lang="ts">
import useAdminToolsStore from '@/stores/modules/admin/tools/index'
import { storeToRefs } from 'pinia'
import { ref } from 'vue'

const formData = ref(formSource())

const adminToolsStore = useAdminToolsStore()

const { editForm, addDialogVisible, toolsTypeList } =
  storeToRefs(adminToolsStore)

const confirmClickHandle = () => {
  const data = {
    ...formData.value,
    tags: formData.value.tags.join(',')
  }
  console.log(data)
  adminToolsStore.addToolsAction(data)
}

function formSource() {
  return {
    title: '',
    intro: '',
    tags: [],
    website: '',
    download: '',
    avatarUrl: '',
    typeId: 1
  }
}
</script>

<style scoped lang="less"></style>
