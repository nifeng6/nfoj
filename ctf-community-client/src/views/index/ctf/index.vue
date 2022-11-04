<template>
  <div class="ctf">
    <el-row :gutter="20">
      <el-col :xs="24" :sm="24" :md="18" :lg="18" :xl="18">
        <Left />
      </el-col>
      <el-col :xs="6" :sm="6" :md="6" :lg="6" :xl="6">
        <Right />
      </el-col>
    </el-row>
  </div>
</template>

<script setup lang="ts">
import Left from './components/left/index.vue'
import Right from './components/right/index.vue'
</script>

<style scoped lang="less">
.ctf {
  max-width: 1250px;
  margin: 20px auto;
}
</style>
