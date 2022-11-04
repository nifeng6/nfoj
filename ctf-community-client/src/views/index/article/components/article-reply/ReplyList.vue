<template>
  <div class="reply-list">
    <ReplyItem></ReplyItem>
    <ReplyItem>
      <template #footer>
        <ReplyItem></ReplyItem>
      </template>
    </ReplyItem>
  </div>
</template>

<script setup lang="ts">
import ReplyItem from './ReplyItem.vue'
</script>

<style scoped lang="less"></style>
