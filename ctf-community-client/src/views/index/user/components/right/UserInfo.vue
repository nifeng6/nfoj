<template>
  <div class="user-info">
    <el-card style="margin-top: 10px">
      <h5 style="font-size: 18px; margin-bottom: 15px">账户信息</h5>
      <div style="font-size: 14px">
        <div class="user-info-item">
          <span>用户ID：</span>
          <span>{{ user.id }}</span>
        </div>
        <div class="user-info-item">
          <span>用户昵称：</span>
          <span>{{ user.username }}</span>
        </div>
        <div class="user-info-item">
          <span>注册时间：</span>
          <span>{{ user.createTime }}</span>
        </div>
      </div>
    </el-card>
  </div>
</template>

<script setup lang="ts">
import useIndexUserStore from '@/stores/modules/index/user'
import { storeToRefs } from 'pinia'
const indexUserStore = useIndexUserStore()

const { user } = storeToRefs(indexUserStore)
</script>

<style scoped lang="less">
.user-info {
  .user-info-item {
    margin: 15px 0;
  }
}
</style>
