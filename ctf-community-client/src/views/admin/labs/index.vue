<template>
  <div class="labs">
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
import useAdminLabsStore from '@/stores/modules/admin/labs'
import EditDialog from './components/EditDialog.vue'
import AddDialog from './components/AddDialog.vue'

const adminLabsStore = useAdminLabsStore()

adminLabsStore.getLabsDockerListAction()
adminLabsStore.getLabsTypeListAction()
adminLabsStore.getListAction()
</script>

<style scoped lang="less"></style>
