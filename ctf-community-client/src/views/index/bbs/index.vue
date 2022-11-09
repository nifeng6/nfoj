<template>
  <div class="bbs">
    <el-row :gutter="20">
      <el-col :span="18"><Left></Left></el-col>
      <el-col :span="6"
        ><Right v-model:dialogVisible="dialogVisible"></Right
      ></el-col>
    </el-row>
    <editArticleDialog v-model:dialogVisible="dialogVisible" />
  </div>
</template>

<script setup lang="ts">
import Left from './components/left/index.vue'
import Right from './components/right/index.vue'
import useIndexBbsStore from '@/stores/modules/index/bbs'
import editArticleDialog from './components/article-edit/index.vue'
import { onMounted, ref } from 'vue'

const dialogVisible = ref(false)

onMounted(() => {
  const indexBbsStore = useIndexBbsStore()

  indexBbsStore.getArticleTypeListAction()
  indexBbsStore.getArticleListAction()
})
</script>

<style scoped lang="less">
.bbs {
  max-width: 1250px;
  margin: 20px auto;
}
</style>
