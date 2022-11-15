<template>
  <div class="table-list">
    <el-table
      style="width: 100%"
      :data="replyList"
      @selection-change="selectChangeClickHandle"
    >
      <el-table-column type="selection" width="55" />
      <el-table-column show-overflow-tooltip prop="id" label="ID" width="80" />
      <el-table-column show-overflow-tooltip prop="username" label="用户名" />

      <el-table-column show-overflow-tooltip prop="nickeName" label="昵称" />

      <el-table-column
        show-overflow-tooltip
        prop="description"
        label="简介"
        width="300"
      />

      <el-table-column show-overflow-tooltip prop="email" label="邮箱" />

      <el-table-column show-overflow-tooltip prop="phone" label="手机号" />
      <el-table-column show-overflow-tooltip prop="coin" label="金币数" />

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
import useAdminUserStore from '@/stores/modules/admin/user/index'
import type { IUserData } from '@/types/admin/user'

const adminUserStore = useAdminUserStore()

const { replyList, selectList, editDialogVisible, editActiveItem } =
  storeToRefs(adminUserStore)

const handleDelete = (id: number) => {
  adminUserStore.deleteAction(id)
}

const editClickHandle = (item: IUserData) => {
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
