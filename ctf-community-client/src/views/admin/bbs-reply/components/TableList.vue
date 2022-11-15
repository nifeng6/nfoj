<template>
  <div class="table-list">
    <el-table
      style="width: 100%"
      :data="replyList"
      @selection-change="selectChangeClickHandle"
    >
      <el-table-column type="selection" width="55" />
      <el-table-column show-overflow-tooltip prop="id" label="ID" width="80" />
      <el-table-column
        show-overflow-tooltip
        prop="title"
        label="文章标题"
        width="180"
      >
        <template #default="scope">
          {{ scope.row.article.title }}
        </template>
      </el-table-column>

      <el-table-column
        show-overflow-tooltip
        prop="content"
        label="回复内容"
        width="500"
      />

      <el-table-column show-overflow-tooltip label="创建时间">
        <template #default="scope">
          {{ formatTime(scope.row.createTime, false) }}
        </template>
      </el-table-column>

      <el-table-column label="操作" width="200">
        <template #default="scope">
          <div class="handle-list">
            <el-link
              :icon="Edit"
              type="primary"
              @click="editClickHandle(scope.row)"
              >编辑</el-link
            >
            <el-popconfirm
              title="确认删除此条文章?"
              confirm-button-text="确认"
              cancel-button-text="取消"
              @confirm="handleDelete(scope.row.id)"
            >
              <template #reference>
                <el-link :icon="Delete" type="primary">删除</el-link>
              </template>
            </el-popconfirm>
          </div>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script setup lang="ts">
import { Delete, Edit } from '@element-plus/icons-vue'
import { formatTime } from '@/utils/format-time'
import { storeToRefs } from 'pinia'
import useAdminBbsReplyStore from '@/stores/modules/admin/bbs-reply/index'
import type { IReplyData } from '@/types/admin/bbs-reply'

const adminBbsReplyStore = useAdminBbsReplyStore()

const { replyList, selectList, editDialogVisible, editActiveItem } =
  storeToRefs(adminBbsReplyStore)

const handleDelete = (id: number) => {
  adminBbsReplyStore.deleteAction(id)
}

const editClickHandle = (item: IReplyData) => {
  editActiveItem.value = item
  editDialogVisible.value = true
}

// 多选按钮被点击
const selectChangeClickHandle = (val: any) => {
  const currentActive = [] as number[]
  val.map((item: any) => {
    currentActive.push(item.id)
  })
  selectList.value = currentActive
}
</script>

<style scoped lang="less">
.table-list {
  margin: 15px 0;

  .handle-list {
    ::v-deep .el-link {
      margin-right: 10px;
    }
  }
}
</style>
