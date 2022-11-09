<template>
  <div class="coin">
    <h2>金币记录</h2>
    <div style="padding: 20px 0">
      <el-table :data="coinRecordList" style="width: 100%">
        <el-table-column prop="amount" label="金币变动" width="180" />
        <el-table-column prop="createTime" label="发生时间" width="300" />
        <el-table-column prop="remark" label="金币来源" />
      </el-table>
    </div>
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
  </div>
</template>

<script setup lang="ts">
import useIndexAccountStore from '@/stores/modules/index/account'
import { storeToRefs } from 'pinia'
const indexAccountStore = useIndexAccountStore()
const { coinRecordList, page } = storeToRefs(indexAccountStore)

const currentChangeHandle = (activePage: number) => {
  page.value.currentPage = activePage
  indexAccountStore.getAccountCoinRecordListAction()
}

indexAccountStore.getAccountCoinRecordListAction()
</script>

<style scoped lang="less">
.coin {
  h2 {
    font-size: 20px;
    font-weight: 500;
    margin: 20px 0;
  }
}
</style>
