<template>
  <div class="article-card">
    <el-card shadow="hover">
      <div class="wrapper">
        <div class="left">
          <div class="left-top">
            <slot name="leftTop"></slot>
          </div>
          <div class="left-bottom">
            <slot name="leftBottom"></slot>
          </div>
        </div>
        <div class="right">
          <div class="right-top">
            <slot name="rightTop"></slot>
          </div>
          <div class="right-bottom">
            <slot name="rightBottom"></slot>
          </div>
        </div>
      </div>
    </el-card>
    <slot name="other"></slot>
  </div>
</template>

<script setup lang="ts"></script>

<style scoped lang="less">
.article-card {
  position: relative;
  overflow: hidden;
  .wrapper {
    display: flex;
    justify-content: space-between;
    .left {
      display: flex;
      flex-direction: column;
      justify-content: space-between;
    }
    .right {
      display: flex;
      flex-direction: column;
      justify-content: space-between;
    }
  }
}
</style>
