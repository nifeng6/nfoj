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
        src="https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fup.enterdesk.com%2Fedpic_source%2F34%2F93%2Ffe%2F3493fec56c307642522b2bc2fc4461e0.jpg&refer=http%3A%2F%2Fup.enterdesk.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1644938763&t=4a3558526cb7183a0e420ec367b65a72"
      />
      <div class="info-text">
        <span class="nickname">用户名</span>
        <span class="des">个性签名...</span>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts"></script>

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
