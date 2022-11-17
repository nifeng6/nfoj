<template>
  <div class="tools">
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
import useAdminToolsStore from '@/stores/modules/admin/tools'
import EditDialog from './components/EditDialog.vue'
import AddDialog from './components/AddDialog.vue'

const adminToolsStore = useAdminToolsStore()
adminToolsStore.getToolsTypeListAction()
adminToolsStore.getListAction()
</script>

<style scoped lang="less"></style>
