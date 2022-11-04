<template>
  <div class="sort">
    <el-menu class="el-menu-vertical">
      <el-menu-item
        v-for="item in typeList"
        :key="String(item.id)"
        :index="String(item.id)"
      >
        <span>{{ item.name }}</span>
      </el-menu-item>
    </el-menu>
  </div>
</template>

<script setup lang="ts">
const typeList = [
  {
    id: 1,
    name: '安全工具'
  },
  {
    id: 2,
    name: 'JAVA工具'
  },
  {
    id: 3,
    name: 'Python工具'
  },
  {
    id: 4,
    name: 'C++工具'
  },
  {
    id: 5,
    name: 'C#工具'
  },
  {
    id: 6,
    name: 'PHP工具'
  },
  {
    id: 7,
    name: 'Go工具'
  },
  {
    id: 8,
    name: '其他工具'
  }
]
</script>

<style scoped lang="less">
.sort {
  border-radius: 5px;
  overflow: hidden;

  .el-menu {
    border-right: 0;
  }
}
</style>
