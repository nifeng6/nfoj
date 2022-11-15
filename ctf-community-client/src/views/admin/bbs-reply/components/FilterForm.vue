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
import useAdminBbsReplyStore from '@/stores/modules/admin/bbs-reply/index'
import { storeToRefs } from 'pinia'

const adminBbsReplyStore = useAdminBbsReplyStore()

const { searchForm, page } = storeToRefs(adminBbsReplyStore)

const searchClickHandle = () => {
  adminBbsReplyStore.getListAction()
}

const resetClickHandle = () => {
  searchForm.value.keywords = undefined
  searchForm.value.type = undefined
  searchForm.value.createTime = undefined
  page.value.currentPage = 1
  adminBbsReplyStore.getListAction()
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
