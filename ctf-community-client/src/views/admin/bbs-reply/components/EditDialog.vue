<template>
  <el-dialog v-model="editDialogVisible">
    <template #header>
      <span>{{ editActiveItem.article.title }}</span>
    </template>
    <el-form>
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
      <el-button @click="editDialogVisible = false">取消</el-button>
      <el-button type="primary" @click="updateClickHandle">确认更新</el-button>
    </template>
  </el-dialog>
</template>

<script setup lang="ts">
import useAdminBbsReplyStore from '@/stores/modules/admin/bbs-reply/index'
import WangEditor from '@/components/comm/WangEditor/index.vue'
import { storeToRefs } from 'pinia'
import { ref } from 'vue'

const formData = ref({
  content: ''
})

const toolbarKeys = ['emotion', 'insertImage', 'redo', 'undo']

const adminBbsReplyStore = useAdminBbsReplyStore()

const { editDialogVisible, editActiveItem } = storeToRefs(adminBbsReplyStore)

const updateClickHandle = () => {
  const data = {
    id: editActiveItem.value.id,
    content: formData.value.content
  }
  adminBbsReplyStore.updateByIdAction(data)
}

watch(
  editActiveItem,
  (newVal) => {
    formData.value.content = editActiveItem.value.content
  },
  {
    deep: true
  }
)
</script>

<style scoped lang="less"></style>
