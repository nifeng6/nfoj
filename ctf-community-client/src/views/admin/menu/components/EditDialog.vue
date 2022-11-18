<template>
  <el-dialog width="30%" v-model="editDialogVisible">
    <template #header>
      <span>更新菜单</span>
    </template>
    <el-form label-width="90px">
      <el-form-item label="上级菜单">
        <el-tree-select
          v-model="formData.parentId"
          :data="formMenuTree"
          check-strictly
          :render-after-expand="false"
          :props="{
            children: 'childMenuList',
            label: 'name',
            value: 'id'
          }"
        />
      </el-form-item>

      <el-form-item label="菜单类型">
        <el-radio-group v-model="formData.menuType">
          <el-radio label="M" size="large">目录</el-radio>
          <el-radio label="C" size="large">菜单</el-radio>
          <el-radio label="B" size="large">按钮</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="ID号">
        <el-input v-model="formData.id" />
      </el-form-item>

      <template v-if="formData.menuType === 'M'">
        <el-form-item label="目录名">
          <el-input v-model="formData.name" />
        </el-form-item>
        <el-form-item label="目录路径">
          <el-input v-model="formData.path" />
        </el-form-item>

        <el-form-item label="图标">
          <el-input v-model="formData.icon" />
        </el-form-item>

        <el-form-item label="状态">
          <el-radio-group v-model="formData.status">
            <el-radio :label="1" size="large">正常</el-radio>
            <el-radio :label="0" size="large">停用</el-radio>
          </el-radio-group>
        </el-form-item>
      </template>

      <template v-else-if="formData.menuType === 'C'">
        <el-form-item label="菜单名">
          <el-input v-model="formData.name" />
        </el-form-item>
        <el-form-item label="菜单路径">
          <el-input v-model="formData.path" />
        </el-form-item>

        <el-form-item label="图标">
          <el-input v-model="formData.icon" />
        </el-form-item>
        <el-form-item label="状态">
          <el-radio-group v-model="formData.status">
            <el-radio :label="1" size="large">正常</el-radio>
            <el-radio :label="0" size="large">停用</el-radio>
          </el-radio-group>
        </el-form-item>
      </template>

      <template v-else-if="formData.menuType === 'B'">
        <el-form-item label="按钮名称">
          <el-input v-model="formData.name" />
        </el-form-item>

        <el-form-item label="权限字符">
          <el-input v-model="formData.permission" />
        </el-form-item>
      </template>
    </el-form>
    <template #footer>
      <el-button @click="editDialogVisible = false">取消</el-button>
      <el-button type="primary" @click="updateClickHandle">确认更新</el-button>
    </template>
  </el-dialog>
</template>

<script setup lang="ts">
import useAdminMenuStore from '@/stores/modules/admin/menu/index'
import { storeToRefs } from 'pinia'
import { ref, computed } from 'vue'

const formData = ref({
  id: 0,
  name: '',
  path: '',
  status: 1,
  icon: '',
  parentId: 0,
  permission: '',
  menuType: 'M'
})

const adminMenuStore = useAdminMenuStore()

const { editDialogVisible, editActiveItem, menuList } =
  storeToRefs(adminMenuStore)

watch(editActiveItem, () => {
  formData.value = { ...editActiveItem.value }
})

const updateClickHandle = () => {
  const data = {
    ...formData.value
  }
  adminMenuStore.updateToolsAction(data)
}

const formMenuTree = computed(() => {
  return [
    {
      id: 0,
      name: '主类目',
      childMenuList: menuList.value
    }
  ]
})
</script>

<style scoped lang="less">
::v-deep .el-form-item {
  align-items: center;
}
</style>
