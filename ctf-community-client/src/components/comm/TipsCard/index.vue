<template>
  <div class="tips-card">
    <slot></slot>
  </div>
</template>

<script setup lang="ts"></script>

<style scoped lang="less">
.tips-card {
  background-color: rgb(248, 248, 250);
  padding: 10px 20px;
  border-left: 5px solid rgb(0, 123, 245);
}
</style>
