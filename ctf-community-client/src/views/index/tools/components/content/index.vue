<template>
  <div class="content">
    <el-row :gutter="20">
      <el-col :xs="24" :sm="5" :md="5" :lg="5" :xl="5">
        <el-affix :offset="10">
          <Sort></Sort>
        </el-affix>
      </el-col>
      <el-col :xs="24" :sm="19" :md="19" :lg="19" :xl="19">
        <ToolList></ToolList>
      </el-col>
    </el-row>
  </div>
</template>

<script setup lang="ts">
import Sort from './Sort.vue'
import ToolList from './ToolList.vue'
</script>

<style scoped lang="less">
.content {
  max-width: 1250px;
  margin: 20px auto;
  margin-top: 30px;
}
</style>
