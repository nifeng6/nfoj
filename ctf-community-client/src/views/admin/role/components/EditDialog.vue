<template>
  <el-dialog width="30%" v-model="editDialogVisible">
    <template #header>
      <span>增加角色</span>
    </template>
    <el-form label-width="80px">
      <el-form-item label="角色名">
        <el-input v-model="formData.name" />
      </el-form-item>
      <el-form-item label="权限字符">
        <el-input v-model="formData.roleKey" />
      </el-form-item>

      <el-form-item label="菜单权限">
        <!-- <el-card> -->
        <el-tree
          ref="treeNodeRef"
          :data="menuList"
          node-key="id"
          :props="{
            children: 'childMenuList',
            label: 'name',
            value: 'id'
          }"
          show-checkbox
        />
        <!-- </el-card> -->
      </el-form-item>
    </el-form>
    <template #footer>
      <el-button @click="editDialogVisible = false">取消</el-button>
      <el-button type="primary" @click="confirmClickHandle">确认更新</el-button>
    </template>
  </el-dialog>
</template>

<script setup lang="ts">
import useAdminRoleStore from '@/stores/modules/admin/role/index'
import { storeToRefs } from 'pinia'
import { ref, watch, computed, nextTick } from 'vue'

const formData = ref({
  name: '',
  roleKey: '',
  adminMenuIdList: []
})

const treeNodeRef = ref()

const adminRoleStore = useAdminRoleStore()

const { editActiveItem, editDialogVisible, menuList } =
  storeToRefs(adminRoleStore)

watch(editActiveItem, () => {
  console.log(editActiveItem.value)
  nextTick(() => {
    treeNodeRef.value!.setCheckedKeys(
      editActiveItem.value.adminMenuIdList,
      false
    )
  })
  formData.value = { ...editActiveItem.value }
})

const confirmClickHandle = () => {
  // const adminMenuIdList = treeNodeRef.value!.getCheckedKeys(false, true)
  const adminMenuIdList = treeNodeRef
    .value!.getCheckedNodes(false, true)
    .map((item: any) => item.id)

  const data = {
    id: editActiveItem.value.id,
    ...formData.value,
    adminMenuIdList
  }
  // console.log(data)
  adminRoleStore.updateToolsAction(data)
}
</script>

<style scoped lang="less">
::v-deep .el-tree {
  border: 1px solid #e5e6e7;
  border-radius: 5px;
  width: 100%;
}
</style>
