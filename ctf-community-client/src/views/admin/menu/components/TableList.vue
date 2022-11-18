<template>
  <div class="table-list">
    <el-table
      style="width: 100%"
      :data="menuList"
      row-key="id"
      :tree-props="{ hasChildren: 'hasChildren', children: 'childMenuList' }"
    >
      <el-table-column show-overflow-tooltip prop="id" label="ID" width="150" />
      <el-table-column show-overflow-tooltip prop="name" label="菜单名" />

      <el-table-column
        show-overflow-tooltip
        prop="path"
        label="跳转地址"
        width="80"
      />

      <el-table-column prop="icon" label="图标">
        <template #default="scope">
          <i :class="`iconfont ${scope.row.icon}`"></i>
        </template>
      </el-table-column>

      <el-table-column show-overflow-tooltip prop="status" label="状态">
        <template #default="scope">
          <el-tag v-if="scope.row.status === 1">
            <span>正常</span>
          </el-tag>
          <el-tag v-else type="danger">
            <span>停用</span>
          </el-tag>
        </template>
      </el-table-column>

      <!-- <el-table-column show-overflow-tooltip prop="menuType" label="类型" /> -->

      <!-- <el-table-column show-overflow-tooltip prop="parentId" label="父级ID" /> -->

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
import useAdminMenuStore from '@/stores/modules/admin/menu/index'
import type { IMenuData } from '@/types/admin/menu'

const adminMenuStore = useAdminMenuStore()

const { menuList, editActiveItem, editDialogVisible } =
  storeToRefs(adminMenuStore)

const handleDelete = (id: number) => {
  adminMenuStore.deleteAction(id)
}

const editClickHandle = (item: IMenuData) => {
  editActiveItem.value = item
  editDialogVisible.value = true
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
