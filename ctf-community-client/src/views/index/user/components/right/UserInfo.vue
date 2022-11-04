<template>
  <div class="user-info">
    <el-card style="margin-top: 10px">
      <h5 style="font-size: 18px; margin-bottom: 15px">账户信息</h5>
      <div style="font-size: 14px">
        <div class="user-info-item">
          <span>用户ID：</span>
          <span>1512</span>
        </div>
        <div class="user-info-item">
          <span>用户昵称：</span>
          <span>倪风</span>
        </div>
        <div class="user-info-item">
          <span>注册时间：</span>
          <span>2021-10-10</span>
        </div>
      </div>
    </el-card>
  </div>
</template>

<script setup lang="ts"></script>

<style scoped lang="less">
.user-info {
  .user-info-item {
    margin: 15px 0;
  }
}
</style>
