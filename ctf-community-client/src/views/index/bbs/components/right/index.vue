<template>
  <div class="right">
    <el-button
      style="height: 44px; width: 100%"
      type="primary"
      @click="publishHandle"
      >发布文章</el-button
    >

    <div class="article-data">
      <el-card style="margin-bottom: 10px">
        <el-row style="font-size: 14px">
          <el-col :span="8" style="text-align: center">
            <div style="margin-bottom: 10px">11</div>
            <div>用户</div>
          </el-col>
          <el-col :span="8" style="text-align: center">
            <div style="margin-bottom: 10px">12</div>
            <div>文章</div>
          </el-col>
          <el-col :span="8" style="text-align: center">
            <div style="margin-bottom: 10px">13</div>
            <div>回复</div>
          </el-col>
        </el-row>
      </el-card>
    </div>

    <Sort></Sort>
  </div>
</template>

<script setup lang="ts">
import Sort from './Sort.vue'
import useCommonAccountStore from '@/stores/modules/common/account'
import { storeToRefs } from 'pinia'
import { ElMessage } from 'element-plus'
import 'element-plus/theme-chalk/el-message.css'

const commonAccountStore = useCommonAccountStore()
const { token, accountDialogVisible } = storeToRefs(commonAccountStore)
const emit = defineEmits(['update:dialogVisible'])
const props = defineProps({
  dialogVisible: {
    type: Boolean,
    default: false
  }
})

const dialogVisible = computed({
  get: () => props.dialogVisible,
  set: (val) => {
    emit('update:dialogVisible', val)
  }
})

const publishHandle = () => {
  if (token.value === '') {
    ElMessage.error('请先登录')
    accountDialogVisible.value = true
    return
  } else {
    dialogVisible.value = true
  }
}
</script>
<style>
.el-message {
  z-index: 3000 !important;
}
</style>
<style lang="less" scoped>
.article-data {
  margin-top: 10px;
}
</style>
