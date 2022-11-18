<template>
  <div class="scroll-view">
    <el-carousel height="240px" :interval="5000" arrow="always">
      <el-carousel-item v-for="item in scrollList" :key="item">
        <div class="img-item">
          <img :src="item.image" :alt="item.title" />
        </div>
      </el-carousel-item>
    </el-carousel>
  </div>
</template>

<script setup lang="ts">
import scsrollImg from '@/assets/image/scroll1.png'
const scrollList = [
  {
    title: '50+靶场环境免费体验',
    image: scsrollImg
  }
]
</script>

<style scoped lang="less">
.scroll-view {
  border-radius: 5px;
  overflow: hidden;
  .img-item {
    display: flex;
    justify-content: center;
    height: 100%;
    img {
      height: 100%;
    }
  }
}
</style>
