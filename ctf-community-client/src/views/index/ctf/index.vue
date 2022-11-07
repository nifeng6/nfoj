<template>
  <div class="ctf">
    <el-row :gutter="20">
      <el-col :xs="24" :sm="24" :md="18" :lg="18" :xl="18">
        <Left />
      </el-col>
      <el-col :xs="6" :sm="6" :md="6" :lg="6" :xl="6">
        <Right />
      </el-col>
    </el-row>
  </div>
</template>

<script setup lang="ts">
import Left from './components/left/index.vue'
import Right from './components/right/index.vue'
import useIndexCtfStore from '@/stores/modules/index/ctf'
import { onMounted } from 'vue'

onMounted(() => {
  const indexCtfStore = useIndexCtfStore()

  // 获取靶场类型
  indexCtfStore.getCtfTypeListAction()
  // 获取热门标签
  indexCtfStore.getCtfTagListAction()
  // 获取表格列表
  indexCtfStore.getCtfListAction()
})
</script>

<style scoped lang="less">
.ctf {
  max-width: 1250px;
  margin: 20px auto;
}
</style>
