<template>
  <div class="left">
    <template v-if="activeIndex === 0">
      <ArticleList />
    </template>
    <template v-else>
      <CtfRecordList />
    </template>
  </div>
</template>

<script lang="ts" setup>
import ArticleList from './ArticleList.vue'
import CtfRecordList from './CtfRecordList.vue'
const props = defineProps({
  activeIndex: {
    type: Number,
    default: 0
  }
})
</script>

<style scoped lang="less">
.left {
  background-color: #fff;
  padding: 20px;
}
</style>
