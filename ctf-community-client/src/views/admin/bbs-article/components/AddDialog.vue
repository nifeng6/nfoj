<template>
  <el-dialog width="50%" v-model="addDialogVisible">
    <template #header>
      <span>增加文章</span>
    </template>
    <el-form label-width="80px">
      <el-form-item label="标题">
        <el-input placeholder="请输入文章标题" v-model="formData.title" />
      </el-form-item>

      <el-form-item label="文章分类" prop="typeName">
        <el-select
          v-model="formData.typeId"
          placeholder="请选择文章分类"
          size="large"
        >
          <el-option
            v-for="item in articleTypeList"
            :key="item.id"
            :label="item.name"
            :value="item.id"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="文章标签" prop="tags">
        <el-select
          v-model="formData.tags"
          :options="tagOptions"
          multiple
          filterable
          allow-create
          default-first-option
          :reserve-keyword="false"
          placeholder="请输入并选择标签"
          size="large"
        >
          <el-option
            v-for="item in tagOptions"
            :key="item.value"
            :label="item.label"
            :value="item.value"
          />
        </el-select>
      </el-form-item>

      <el-form-item label="内容">
        <WangEditor
          :toolbarKeys="toolbarKeys"
          v-model:valueHtml="formData.content"
          placeholder="请输入评论内容..."
          height="200px"
        />
      </el-form-item>
    </el-form>

    <template #footer>
      <el-button size="large" @click="addDialogVisible = false">取消</el-button>
      <el-button size="large" type="primary" @click="confirmClickHandle"
        >确认发布</el-button
      >
    </template>
  </el-dialog>
</template>

<script setup lang="ts">
import useAdminBbsArticleStore from '@/stores/modules/admin/bbs-article/index'
import { storeToRefs } from 'pinia'
import WangEditor from '@/components/comm/WangEditor/index.vue'
import { ref } from 'vue'

const toolbarKeys = ['emotion', 'insertImage', 'redo', 'undo']

const formData = ref(formSource())

const adminBbsArticleStore = useAdminBbsArticleStore()
const tagOptions = [
  {
    value: 'vue3',
    label: 'vue3'
  },
  {
    value: 'vue2',
    label: 'vue2'
  },
  {
    value: 'vue',
    label: 'vue'
  },
  {
    value: 'react',
    label: 'react'
  },
  {
    value: 'angular',
    label: 'angular'
  },
  {
    value: 'node',
    label: 'node'
  },
  {
    value: 'webpack',
    label: 'webpack'
  },
  {
    value: 'rollup',
    label: 'rollup'
  },
  {
    value: 'vite',
    label: 'vite'
  },
  {
    value: 'typescript',
    label: 'typescript'
  },
  {
    value: 'javascript',
    label: 'javascript'
  },
  {
    value: 'css',
    label: 'css'
  },
  {
    value: 'html',
    label: 'html'
  },
  {
    value: 'less',
    label: 'less'
  },
  {
    value: 'sass',
    label: 'sass'
  }
]
const { addDialogVisible, articleTypeList } = storeToRefs(adminBbsArticleStore)

function formSource() {
  return {
    title: '',
    typeId: '',
    content: '',
    tags: []
  }
}

const confirmClickHandle = () => {
  const data = {
    title: formData.value.title,
    sortId: Number.parseInt(formData.value.typeId),
    content: formData.value.content,
    tags: formData.value.tags.join('')
  }
  adminBbsArticleStore.addArticleAction(data)
}
</script>

<style scoped lang="less">
::v-deep .el-form-item:last-child {
  margin-bottom: 0;
}
</style>
