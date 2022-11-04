<template>
  <el-card>
    <div class="user-record">
      <div class="user-record-item">
        <p>2</p>
        <span>文章数</span>
      </div>
      <div class="user-record-item">
        <p>2</p>
        <span>解题数</span>
      </div>
      <div class="user-record-item">
        <p>3</p>
        <span>金币数</span>
      </div>
    </div>
  </el-card>
</template>

<script setup lang="ts"></script>

<style scoped lang="less">
.user-record {
  display: flex;
  justify-content: space-between;
  .user-record-item {
    display: flex;
    flex-direction: column;
    align-items: center;
    p {
      font-size: 20px;
      color: #333;
      margin-bottom: 10px;
    }
    span {
      font-size: 12px;
    }
  }
}
</style>
