<template>
  <div class="article-reply">
    <ReplyEdit></ReplyEdit>
    <ReplyList></ReplyList>
  </div>
</template>

<script setup lang="ts">
import ReplyEdit from './ReplyEdit.vue'
import ReplyList from './ReplyList.vue'
</script>

<style scoped lang="less">
.article-reply {
  background-color: #fff;
  padding: 40px;
}
</style>
