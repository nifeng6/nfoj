<template>
  <div class="table-list">
    <el-table
      style="width: 100%"
      :data="roleList"
      @selection-change="selectChangeClickHandle"
    >
      <el-table-column type="selection" width="55" />
      <el-table-column show-overflow-tooltip prop="id" label="ID" width="80" />
      <el-table-column
        show-overflow-tooltip
        prop="name"
        label="角色名"
        width="180"
      />

      <el-table-column
        show-overflow-tooltip
        prop="roleKey"
        label="Key"
        width="80"
      />

      <el-table-column show-overflow-tooltip label="创建时间">
        <template #default="scope">
          {{ formatTime(scope.row.createTime, false) }}
        </template>
      </el-table-column>

      <el-table-column show-overflow-tooltip label="更新时间">
        <template #default="scope">
          {{ formatTime(scope.row.updateTime, false) }}
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
import useAdminRoleStore from '@/stores/modules/admin/role/index'
import type { IRoleData } from '@/types/admin/role'

const adminRoleStore = useAdminRoleStore()

const { roleList, editActiveItem, editDialogVisible, selectList } =
  storeToRefs(adminRoleStore)

const handleDelete = (id: number) => {
  adminRoleStore.deleteAction(id)
}

const editClickHandle = (item: IRoleData) => {
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
