<template>
  <div class="reply-edit">
    <WangEditor
      :toolbarKeys="toolbarKeys"
      v-model:valueHtml="valueHtml"
      placeholder="请输入评论内容..."
    ></WangEditor>

    <div class="submit">
      <el-button size="large" type="primary">提交评论</el-button>
    </div>
  </div>
</template>

<script setup lang="ts">
import { ref } from 'vue'
const toolbarKeys = ['emotion', 'insertImage', 'redo', 'undo']

const valueHtml = ref('test')
</script>

<style scoped lang="less">
.reply-edit {
  .submit {
    text-align: right;
    margin: 10px 0;
  }
}
</style>
