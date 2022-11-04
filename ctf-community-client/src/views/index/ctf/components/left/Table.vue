<template>
  <div class="table">
    <el-table ref="slectLabRef" stripe style="width: 100%">
      <el-table-column prop="id" label="ID" />
      <el-table-column prop="title" label="题目" />
      <el-table-column prop="needCoin" label="需要金币" />
      <el-table-column prop="userCount" label="参与人数" />
      <el-table-column label="通过率">
        <template #default="scope">
          <el-progress
            :text-inside="true"
            :stroke-width="24"
            :percentage="scope.row.successCount * 100"
            :status="
              scope.row.successCount * 100 > 80
                ? 'success'
                : scope.row.successCount * 100 > 50
                ? ''
                : scope.row.successCount * 100 > 75
                ? 'exception'
                : scope.row.successCount * 100 > 25
                ? 'warning'
                : 'danger'
            "
          />
        </template>
      </el-table-column>
    </el-table>
    <div class="pagination">
      <el-pagination
        background
        layout="prev, pager, next"
        :page-size="pageParam.size"
        :total="pageParam.total"
        :current-page="pageParam.currentPage"
        @current-change="currentChangeHandle"
      ></el-pagination>
    </div>
  </div>
</template>

<script setup lang="ts">
import { ref } from 'vue'

const pageParam = ref({
  currentPage: 1,
  size: 10,
  total: 0
})

const currentChangeHandle = () => {}
</script>

<style scoped lang="less">
.table {
  .pagination {
    display: flex;
    justify-content: right;
    margin-top: 10px;
  }
}
</style>
