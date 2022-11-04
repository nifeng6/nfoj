<template>
  <div class="user">
    <Header />
    <Navigator v-model:activeIndex="activeIndex" />
    <div class="content">
      <el-row :gutter="10">
        <el-col :span="18">
          <Left :activeIndex="activeIndex" />
        </el-col>
        <el-col :span="6">
          <Right />
        </el-col>
      </el-row>
    </div>
  </div>
</template>

<script setup lang="ts">
import Header from './components/top/index.vue'
import Navigator from './components/navigator/index.vue'
import Left from './components/left/index.vue'
import Right from './components/right/index.vue'
import { ref } from 'vue'

const activeIndex = ref(0)
</script>

<style scoped lang="less">
.user {
  max-width: 1250px;
  margin: 0 auto;
}

.content {
  margin: 10px 0;
}
</style>
