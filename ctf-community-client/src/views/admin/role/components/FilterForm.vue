<template>
  <div class="filter-form">
    <el-form>
      <el-row :gutter="15">
        <el-col :span="6">
          <el-form-item label="文章标题">
            <el-input
              placeholder="请输入文章标题"
              v-model="searchForm.keywords"
            />
          </el-form-item>
        </el-col>
        <el-col :span="6">
          <el-form-item>
            <el-button :icon="Search" type="primary" @click="searchClickHandle"
              >搜索</el-button
            >
            <el-button :icon="Refresh" @click="resetClickHandle"
              >重置</el-button
            >
          </el-form-item>
        </el-col>
      </el-row>
    </el-form>
  </div>
</template>

<script setup lang="ts">
import { Search, Refresh } from '@element-plus/icons-vue'
import useAdminRoleStore from '@/stores/modules/admin/role/index'
import { storeToRefs } from 'pinia'

const adminRoleStore = useAdminRoleStore()

const { searchForm, page } = storeToRefs(adminRoleStore)

const searchClickHandle = () => {
  adminRoleStore.getListAction()
}

const resetClickHandle = () => {
  searchForm.value.keywords = undefined
  page.value.currentPage = 1
  adminRoleStore.getListAction()
}
</script>

<style scoped lang="less">
.filter-form {
  ::v-deep .el-form-item__label {
    font-weight: 600;
    font-size: 14px;
    color: #606266;
  }
}
</style>
