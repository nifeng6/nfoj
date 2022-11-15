<template>
  <div class="table">
    <el-table
      :data="ctfList"
      ref="slectLabRef"
      stripe
      style="width: 100%"
      @row-click="rowClickHandle"
    >
      <el-table-column prop="id" label="ID" />
      <el-table-column prop="title" label="题目" />
      <el-table-column prop="needCoin" label="需要金币" />
      <el-table-column prop="count" label="参与人数" />
      <el-table-column label="通过率">
        <template #default="scope">
          <el-progress
            :text-inside="true"
            :stroke-width="24"
            :percentage="(scope.row.successCount / scope.row.count || 0) * 100"
            :status="
              (scope.row.successCount / scope.row.count || 0) * 100 > 80
                ? 'success'
                : (scope.row.successCount / scope.row.count || 0) * 100 > 50
                ? ''
                : (scope.row.successCount / scope.row.count || 0) * 100 > 75
                ? 'exception'
                : (scope.row.successCount / scope.row.count || 0) * 100 > 25
                ? 'warning'
                : 'exception'
            "
          />
        </template>
      </el-table-column>
    </el-table>
    <div class="pagination">
      <el-pagination
        background
        layout="prev, pager, next"
        :page-size="page.pageSize"
        :total="page.total"
        :current-page="page.currentPage"
        @current-change="currentChangeHandle"
      ></el-pagination>
    </div>
    <TableDialog
      v-model:dialogVisible="dialogVisible"
      :activeItem="activeItem"
    />
  </div>
</template>

<script setup lang="ts">
import { storeToRefs } from 'pinia'
import useIndexCtfStore from '@/stores/modules/index/ctf'
import TableDialog from './TableDialog.vue'
import { ref } from 'vue'
import useCommonAccountStore from '@/stores/modules/common/account'
import { ElMessage } from 'element-plus'

const commonAccountStore = useCommonAccountStore()
const { token, accountDialogVisible } = storeToRefs(commonAccountStore)
const indexCtfStore = useIndexCtfStore()
const dialogVisible = ref(false)
const activeItem = ref()
const { ctfList, page } = storeToRefs(indexCtfStore)

const currentChangeHandle = (clickPage: any) => {
  page.value.currentPage = clickPage
  indexCtfStore.getCtfListAction()
}

const rowClickHandle = (item: any) => {
  // 判断用户是否登录
  if (!token.value) {
    accountDialogVisible.value = true
    ElMessage.error('请先登录后再进行操作')
    return
  }

  activeItem.value = item
  dialogVisible.value = true
}
</script>
<style scoped lang="less">
.table {
  .pagination {
    display: flex;
    justify-content: right;
    margin-top: 10px;
  }

  ::v-deep .el-table__row {
    cursor: pointer;
  }
}
</style>
