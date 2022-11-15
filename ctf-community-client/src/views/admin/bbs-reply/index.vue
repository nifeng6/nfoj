<template>
  <div class="bbs">
    <FilterForm />
    <BtnList />
    <TableList />
    <Pagination />
    <EditDialog />
    <AddDialog />
  </div>
</template>

<script setup lang="ts">
import FilterForm from './components/FilterForm.vue'
import TableList from './components/TableList.vue'
import BtnList from './components/BtnList.vue'
import Pagination from './components/Pagination.vue'
import useAdminBbsReplyStore from '@/stores/modules/admin/bbs-reply/index'
import EditDialog from './components/EditDialog.vue'
import AddDialog from './components/AddDialog.vue'

const adminBbsReplyStore = useAdminBbsReplyStore()

adminBbsReplyStore.getListAction()
</script>

<style scoped lang="less"></style>
