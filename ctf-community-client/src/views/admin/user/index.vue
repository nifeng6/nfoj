<template>
  <div class="Toolss">
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
import useAdminUserStore from '@/stores/modules/admin/user'
import EditDialog from './components/EditDialog.vue'
import AddDialog from './components/AddDialog.vue'

const adminUserStore = useAdminUserStore()

adminUserStore.getListAction()
</script>

<style scoped lang="less"></style>
