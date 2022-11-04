<template>
  <div class="hot-tag">
    <el-card style="margin-left: 15px">
      <template #header>
        <span> 热门标签 </span>
      </template>
      <el-tag
        class="tag-item"
        :type="tag_type[Math.ceil(Math.random() * 10)]"
        effect="dark"
        v-for="item in hotTagList"
        :key="item.id"
        >{{ item.name }}</el-tag
      >

      <!-- <el-button class="s-tag-c" @click="randomSelect"> 随机来一题 </el-button> -->
    </el-card>
  </div>
</template>

<script lang="ts" setup>
import { ref } from 'vue'

const hotTagList = ref([
  {
    id: 1,
    name: 'sql注入'
  },
  {
    id: 2,
    name: 'xss'
  },
  {
    id: 3,
    name: 'csrf'
  },
  {
    id: 4,
    name: 'ssrf'
  },
  {
    id: 5,
    name: 'xxe'
  },
  {
    id: 6,
    name: '文件上传'
  },
  {
    id: 7,
    name: '文件包含'
  },
  {
    id: 8,
    name: '命令执行'
  },
  {
    id: 9,
    name: '逻辑漏洞'
  },
  {
    id: 10,
    name: '绕过'
  },
  {
    id: 11,
    name: '绕过'
  },
  {
    id: 12,
    name: '绕过'
  },
  {
    id: 13,
    name: '绕过'
  },
  {
    id: 14,
    name: '绕过'
  },
  {
    id: 15,
    name: '绕过'
  },
  {
    id: 16,
    name: '绕过'
  },
  {
    id: 17,
    name: '绕过'
  },
  {
    id: 18,
    name: '绕过'
  },
  {
    id: 19,
    name: '绕过'
  },
  {
    id: 20,
    name: '绕过'
  },
  {
    id: 21,
    name: '绕过'
  },
  {
    id: 22,
    name: '绕过'
  },
  {
    id: 23,
    name: '绕过'
  },
  {
    id: 24,
    name: '绕过'
  },
  {
    id: 25,
    name: '绕过'
  },
  {
    id: 26,
    name: '绕过'
  },
  {
    id: 27,
    name: '绕过'
  },
  {
    id: 28,
    name: '绕过'
  },
  {
    id: 29,
    name: '绕过'
  },
  {
    id: 30,
    name: '绕过'
  }
])

const tag_type = [
  '',
  '',
  'success',
  'info',
  'danger',
  'warning',
  'success',
  'info',
  'danger',
  'warning',
  ''
]
</script>

<style scoped lang="less">
.hot-tag {
  .tag-item {
    margin: 5px;
  }
}
</style>
