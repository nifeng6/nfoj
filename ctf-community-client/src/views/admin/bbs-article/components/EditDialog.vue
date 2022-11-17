<template>
  <el-dialog width="50%" v-model="editDialogVisible">
    <template #header>
      <span>更新文章</span>
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
      <el-button size="large" @click="editDialogVisible = false"
        >取消</el-button
      >
      <el-button size="large" type="primary" @click="updateClickHandle"
        >确认更新</el-button
      >
    </template>
  </el-dialog>
</template>

<script setup lang="ts">
import useAdminBbsArticleStore from '@/stores/modules/admin/bbs-article/index'
import { storeToRefs } from 'pinia'
import WangEditor from '@/components/comm/WangEditor/index.vue'
import { ref, watchEffect } from 'vue'

const toolbarKeys = ['emotion', 'insertImage', 'redo', 'undo']

const formData = ref({
  title: '',
  typeId: 0,
  content: '',
  tags: [] as any
})

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
const { editDialogVisible, articleTypeList, editActiveItem } =
  storeToRefs(adminBbsArticleStore)

watchEffect(() => {
  formData.value.title = editActiveItem.value.title
  formData.value.content = editActiveItem.value.content
  formData.value.tags =
    editActiveItem.value.tags &&
    (editActiveItem.value.tags.split(',') as string[])
  formData.value.typeId = editActiveItem.value.typeId
})

const updateClickHandle = () => {
  const data = {
    id: editActiveItem.value.id,
    title: formData.value.title,
    typeId: formData.value.typeId,
    content: formData.value.content,
    tags: formData.value.tags.join('')
  }
  adminBbsArticleStore.updateArticleAction(data)
}
</script>

<style scoped lang="less">
::v-deep .el-form-item:last-child {
  margin-bottom: 0;
}
</style>
