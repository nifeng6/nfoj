<template>
  <ul class="navigator">
    <template v-for="(item, index) in itemData" :key="item">
      <li
        class="nav-item"
        :class="{ active: currentIndex === index }"
        @click="changeIndexHandle(index)"
      >
        {{ item }}
      </li>
    </template>
  </ul>
</template>

<script lang="ts" setup>
import { computed } from 'vue'
const itemData = ['文章', '靶场记录']
const emit = defineEmits(['update:activeIndex'])
const props = defineProps({
  activeIndex: {
    type: Number,
    default: 0
  }
})

const currentIndex = computed({
  get: () => props.activeIndex,
  set: (val) => {
    return emit('update:activeIndex', val)
  }
})

const changeIndexHandle = (index: number) => {
  currentIndex.value = index
}
</script>

<style scoped lang="less">
.navigator {
  height: 60px;
  line-height: 60px;
  display: flex;
  background-color: #fff;
  .nav-item {
    padding: 0 20px;
    cursor: pointer;
    transition: all 0.3s;
    &.active {
      color: #409eff;
      border-bottom: 2px solid #409eff;
    }
    &:hover {
      color: #409eff;
      border-bottom: 2px solid #409eff;
    }
  }
}
</style>
