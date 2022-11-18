<template>
  <div class="role">
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
import useAdminRoleStore from '@/stores/modules/admin/role'
import EditDialog from './components/EditDialog.vue'
import AddDialog from './components/AddDialog.vue'

const adminRoleStore = useAdminRoleStore()
adminRoleStore.getMenuListAction()
adminRoleStore.getListAction()
</script>

<style scoped lang="less"></style>
