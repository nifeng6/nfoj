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
import useAdminLabsDockerStore from '@/stores/modules/admin/labs-docker'
import EditDialog from './components/EditDialog.vue'
import AddDialog from './components/AddDialog.vue'

const adminLabsDockerStore = useAdminLabsDockerStore()

adminLabsDockerStore.getListAction()
</script>

<style scoped lang="less"></style>
