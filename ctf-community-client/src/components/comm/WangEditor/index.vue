<template>
  <div class="editor">
    <Toolbar
      style="border-bottom: 1px solid #ccc"
      :editor="editorRef"
      :defaultConfig="toolbarConfig"
    />
    <Editor
      :style="{ height }"
      v-model="valueHtml"
      :defaultConfig="editorConfig"
      @onCreated="handleCreated"
    />
  </div>
</template>

<script setup lang="ts">
import '@wangeditor/editor/dist/css/style.css' // 引入 css
import {
  onBeforeUnmount,
  shallowRef,
  computed,
  defineProps,
  defineEmits
} from 'vue'
import { Editor, Toolbar } from '@wangeditor/editor-for-vue'
import type { IToolbarConfig } from '@wangeditor/editor'

const props = defineProps({
  valueHtml: {
    type: String,
    default: '<p>hello</p>'
  },
  toolbarKeys: {
    type: Array<any>,
    default: () => []
  },
  placeholder: {
    type: String,
    default: '请输入内容...'
  },
  width: {
    type: String,
    default: '100%'
  },
  height: {
    type: String,
    default: '300px'
  }
})

const emit = defineEmits(['update:valueHtml'])

// 编辑器实例，必须用 shallowRef
const editorRef = shallowRef()

// 内容 HTML
const valueHtml = computed({
  get: () => props.valueHtml,
  set: (val) => {
    emit('update:valueHtml', val)
  }
})

const toolbarConfig: Partial<IToolbarConfig> = {
  toolbarKeys: props.toolbarKeys
}
const editorConfig = { placeholder: props.placeholder }

// 组件销毁时，也及时销毁编辑器
onBeforeUnmount(() => {
  const editor = editorRef.value
  if (editor == null) return
  editor.destroy()
})

const handleCreated = (editor: any) => {
  editorRef.value = editor // 记录 editor 实例，重要！
}
</script>

<style scoped lang="less">
.editor {
  border: 1px solid #ccc;
  width: 100%;
}
</style>
