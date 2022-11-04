<template>
  <div class="tool-item">
    <el-card class="box-card" shadow="hover">
      <h4 class="title">工具名称</h4>
      <div class="des">
        <span
          >打包、压缩壳侦测工具，可以支持Symbian/Android/Linux/macOS/Windows等系统的可执行文件</span
        >
      </div>
      <div class="tag">
        <template v-for="(item, index) in tag_list" :key="item">
          <el-tag :type="tags_type[index % 5]" class="tag-item">{{
            item
          }}</el-tag>
        </template>
      </div>

      <div class="tex">
        <el-button type="primary">官方地址</el-button>
        <el-button type="primary">下载地址</el-button>
      </div>
    </el-card>
  </div>
</template>

<script setup lang="ts">
const tags_type = ['success', 'info', 'warning', 'danger', '']

const tag_list = ['Symbian', 'Android', 'Linux', 'macOS', 'Windows']
</script>

<style scoped lang="less">
.tool-item {
  margin-bottom: 10px;
  text-align: center;
  &:hover {
    cursor: pointer;
  }
  .des {
    color: rgba(0, 0, 0, 0.45);
    font-size: 13px;
    margin: 20px 0 10px 0;
    span {
      overflow: hidden;
      text-overflow: ellipsis;
      display: -webkit-box;
      -webkit-line-clamp: 3;
      -webkit-box-orient: vertical;
    }
  }
  .tag {
    overflow: hidden;
    text-overflow: ellipsis;
    display: -webkit-box;
    -webkit-line-clamp: 2;
    -webkit-box-orient: vertical;
    .tag-item {
      margin: 0px 5px 5px 0px;
    }
  }
  .tex {
    display: flex;
    justify-content: space-between;
    margin-top: 5px;
  }
}
</style>
