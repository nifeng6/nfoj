<template>
  <div class="reply-edit">
    <WangEditor
      :toolbarKeys="toolbarKeys"
      v-model:valueHtml="valueHtml"
      placeholder="请输入评论内容..."
      height="150px"
    ></WangEditor>

    <div class="submit">
      <el-button size="large" type="primary" @click="submitReplyHandle"
        >提交评论</el-button
      >
    </div>
  </div>
</template>

<script setup lang="ts">
import { ref } from 'vue'
import useIndexArticleStore from '@/stores/modules/index/article/index'
import { useRoute } from 'vue-router'
const indexArticleStore = useIndexArticleStore()
const route = useRoute()
const toolbarKeys = ['emotion', 'insertImage', 'redo', 'undo']

const valueHtml = ref('')
console.log(route.params.article_id)
const submitReplyHandle = () => {
  const data = {
    articleId: Number.parseInt(route.params.article_id.toString()),
    content: valueHtml.value,
    type: 1
  }
  indexArticleStore.addArticleReplyAction(data)
}
</script>

<style scoped lang="less">
.reply-edit {
  .submit {
    text-align: right;
    margin: 10px 0;
  }
}
</style>
