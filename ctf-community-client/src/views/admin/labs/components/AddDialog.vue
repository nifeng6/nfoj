<template>
  <el-dialog width="30%" v-model="addDialogVisible">
    <template #header>
      <span>增加靶场</span>
    </template>
    <el-form label-width="80px">
      <el-form-item label="靶场标题">
        <el-input v-model="formData.title" />
      </el-form-item>

      <el-form-item label="简介">
        <el-input v-model="formData.intro" />
      </el-form-item>

      <el-form-item label="难度">
        <el-input v-model="formData.level" />
      </el-form-item>

      <el-form-item label="标签">
        <el-select
          v-model="formData.label"
          multiple
          filterable
          allow-create
          default-first-option
          :reserve-keyword="false"
          placeholder="请输入并选择标签"
          size="large"
        >
        </el-select>
      </el-form-item>

      <el-form-item label="flag">
        <el-input v-model="formData.flag" />
      </el-form-item>

      <el-form-item label="所需金币">
        <el-input v-model="formData.needCoin" />
      </el-form-item>

      <el-form-item label="奖励金币">
        <el-input v-model="formData.goldCoin" />
      </el-form-item>

      <el-form-item label="靶机分类">
        <el-select v-model="formData.typeId" placeholder="请选择靶机分类">
          <el-option
            v-for="item in labsTypeList"
            :key="item.id"
            :label="item.name"
            :value="item.id"
          />
        </el-select>
      </el-form-item>

      <el-form-item label="所属容器">
        <el-select v-model="formData.dockerId" placeholder="请选择所属容器">
          <el-option
            v-for="item in labsDockerList"
            :key="item.id"
            :label="item.name"
            :value="item.id"
          />
        </el-select>
      </el-form-item>
    </el-form>

    <template #footer>
      <el-button @click="addDialogVisible = false">取消</el-button>
      <el-button type="primary" @click="confirmClickHandle">确认添加</el-button>
    </template>
  </el-dialog>
</template>

<script setup lang="ts">
import useAdminLabsStore from '@/stores/modules/admin/labs/index'
import { storeToRefs } from 'pinia'
import { ref } from 'vue'

const formData = ref(formSource())

const adminLabsStore = useAdminLabsStore()

const { addDialogVisible, labsDockerList, labsTypeList } =
  storeToRefs(adminLabsStore)

function formSource() {
  return {
    title: '',
    intro: '',
    level: 0,
    label: [],
    dockerId: 1,
    typeId: 1,
    flag: '',
    needCoin: 0,
    goldCoin: 0
  }
}

const confirmClickHandle = () => {
  const data = {
    ...formData.value,
    label: formData.value.label.join(',')
  }
  adminLabsStore.addLabsAction(data)
}
</script>

<style scoped lang="less"></style>
