<template>
  <div class="home">
    <el-row :gutter="20">
      <el-col :xs="24" :sm="24" :md="16" :lg="16" :xl="16">
        <Left />
      </el-col>
      <el-col :xs="24" :sm="24" :md="8" :lg="8" :xl="8">
        <Right />
      </el-col>
    </el-row>
  </div>
</template>

<script setup lang="ts">
import usecommonRootStore from '@/stores/modules/common/root'
import Right from './components/right/index.vue'
import Left from './components/left/index.vue'
import useIndexHomeStore from '@/stores/modules/index/home'

const indexHomeStore = useIndexHomeStore()
const commonRootStore = usecommonRootStore()
indexHomeStore.getNoticeListAction()
indexHomeStore.getNoticePageAction()
indexHomeStore.getNewLabListAction()
indexHomeStore.getWeekRecordAction()
commonRootStore.changeDomTitle()
</script>

<style scoped lang="less">
.home {
  max-width: 1250px;
  margin: 20px auto;
}
</style>
