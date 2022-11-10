<template>
  <el-dialog v-model="dialogVisible">
    <template #header>
      <h3>回复评论</h3>
    </template>

    <WangEditor
      :toolbarKeys="toolbarKeys"
      v-model:valueHtml="valueHtml"
      placeholder="请输入评论内容..."
      height="200px"
    />
    <div class="dialog-footer">
      <el-button size="large" @click="dialogVisible = false">取 消</el-button>
      <el-button size="large" type="primary" @click="submitReplyHandle"
        >点 击 回 复</el-button
      >
    </div>
  </el-dialog>
</template>

<script setup lang="ts">
import { computed, ref } from 'vue'
import WangEditor from '@/components/comm/WangEditor/index.vue'
import useIndexArticleStore from '@/stores/modules/index/article'
import { useRoute } from 'vue-router'

const route = useRoute()
const indexArticleStore = useIndexArticleStore()
const toolbarKeys = ['emotion', 'insertImage', 'redo', 'undo']

const valueHtml = ref('')
const emit = defineEmits(['update:dialogVisible'])
const props = defineProps({
  dialogVisible: {
    type: Boolean
  },
  replyData: {
    type: Object
  }
})

const dialogVisible = computed({
  get() {
    return props.dialogVisible
  },
  set(val) {
    emit('update:dialogVisible', val)
  }
})

const submitReplyHandle = () => {
  const data = {
    articleId: Number.parseInt(route.params.article_id.toString()),
    replyId: props.replyData?.replyId,
    replyUserId: props.replyData?.replyUserId,
    replyFatherId:
      props.replyData?.type === 'father'
        ? props.replyData?.replyId
        : props.replyData?.replyFatherId,
    content: valueHtml.value,
    type: 2
  }
  indexArticleStore.addArticleReplyAction(data).then((res) => {
    if (res) {
      dialogVisible.value = false
      valueHtml.value = ''
    }
  })
}
</script>

<style scoped lang="less">
.dialog-footer {
  margin-top: 20px;
  text-align: right;
}
</style>
