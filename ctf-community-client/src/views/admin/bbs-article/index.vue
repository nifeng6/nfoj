<template>
  <div class="bbs-article">
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
import useAdminBbsArticleStore from '@/stores/modules/admin/bbs-article/index'
import EditDialog from './components/EditDialog.vue'
import AddDialog from './components/AddDialog.vue'

const adminBbsArticleStore = useAdminBbsArticleStore()

adminBbsArticleStore.getArticleListAction()
adminBbsArticleStore.getArticleTypeListAction()
</script>

<style scoped lang="less"></style>
