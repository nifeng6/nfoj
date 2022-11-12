<template>
  <div class="header">
    <img
      src="https://uploadfile.bizhizu.cn/up/a6/5e/9e/a65e9e22a62c05817e259e6655127c42.jpg"
      alt=""
    />
    <div class="user-info">
      <el-avatar
        :size="70"
        style="border: 2px solid #fff"
        :src="user.avatarUrl"
      />
      <div class="info-text">
        <span class="nickname">{{ user.nickName }}</span>
        <span class="des">{{ user.description }}</span>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import useIndexUserStore from '@/stores/modules/index/user'
import { storeToRefs } from 'pinia'

const indexUserStore = useIndexUserStore()

const { user } = storeToRefs(indexUserStore)
</script>

<style scoped lang="less">
.header {
  height: 200px;
  overflow: hidden;
  position: relative;
  img {
    // height: 100%;
    width: 100%;
  }
  .user-info {
    position: absolute;
    left: 20px;
    bottom: 20px;
    display: flex;
    align-items: center;
    color: #fff;

    .info-text {
      display: flex;
      flex-direction: column;
      margin-left: 15px;
      span {
        margin: 8px 0;
      }
      .des {
        font-size: 13px;
      }
      .nickname {
        font-size: 18px;
        font-weight: bold;
      }
    }
  }
}
</style>
