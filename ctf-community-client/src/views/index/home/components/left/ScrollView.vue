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
const scrollList = [
  {
    title: '50+靶场环境免费体验',
    image:
      'https://ctf.bugku.com/upload/20220308/db7880680360abe5469dbedb1d545f8e.png'
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
