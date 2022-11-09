<template>
  <div class="article-edit">
    <el-dialog
      v-model="dialogVisible"
      width="100%"
      style="margin: 0; height: 100%; overflow: auto"
    >
      <template #header>
        <h3>添加文章</h3>
      </template>
      <el-form
        :model="articleForm"
        :rules="articleFormRules"
        ref="articleFormRef"
        label-width="auto"
      >
        <el-form-item label="文章标题" prop="title">
          <el-input v-model="articleForm.title" placeholder="请输入文章标题" />
        </el-form-item>
        <el-form-item label="文章分类" prop="typeName">
          <el-select
            v-model="articleForm.typeId"
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
            v-model="articleForm.tags"
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
        <el-form-item label="文章内容" prop="content">
          <WangEditor
            :toolbarKeys="toolbarKeys"
            v-model:valueHtml="articleForm.content"
            placeholder="请输入评论内容..."
          />
        </el-form-item>
        <el-form-item>
          <div class="btn">
            <el-button @click="dialogVisible = false">取消发布</el-button>
            <el-button type="primary" @click="articleSubmitHandle"
              >点击发布</el-button
            >
          </div>
        </el-form-item>
      </el-form>
    </el-dialog>
  </div>
</template>

<script setup lang="ts">
import { ref, computed } from 'vue'
import WangEditor from '@/components/comm/WangEditor/index.vue'
import useIndexBbsStore from '@/stores/modules/index/bbs'
import { storeToRefs } from 'pinia'

const indexBbsStore = useIndexBbsStore()

const { articleTypeList } = storeToRefs(indexBbsStore)

const emit = defineEmits(['update:dialogVisible'])
const props = defineProps({
  dialogVisible: {
    type: Boolean,
    default: false
  }
})

const dialogVisible = computed({
  get: () => props.dialogVisible,
  set: (val) => {
    emit('update:dialogVisible', val)
  }
})

// const dialogVisible = ref(true)
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
const toolbarKeys = ['bold', 'fontSize', 'italic', 'underline']

const articleForm = ref({
  title: '',
  typeId: '',
  content: '',
  tags: []
})

const articleFormRules = ref({
  title: [
    {
      required: true,
      message: '请输入文章标题',
      trigger: 'blur'
    }
  ],
  typeId: [
    {
      required: true,
      message: '请选择文章分类',
      trigger: 'change'
    }
  ],
  content: [
    {
      required: true,
      message: '请输入文章内容',
      trigger: 'blur'
    }
  ]
})

const articleSubmitHandle = () => {
  const data = {
    title: articleForm.value.title,
    sortId: Number.parseInt(articleForm.value.typeId),
    content: articleForm.value.content,
    tags: articleForm.value.tags.join('')
  }

  indexBbsStore.addArticleAction(data).then((res) => {
    if (res) {
      dialogVisible.value = false
    }
  })
}
</script>

<style scoped lang="less">
.article-edit {
  ::v-deep .el-form-item {
    display: flex;
    flex-direction: column;
  }
}
</style>
