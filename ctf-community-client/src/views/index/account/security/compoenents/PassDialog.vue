<template>
  <div class="pass-dialog">
    <el-dialog ref="formRef" v-model="passDialogVisible" width="25%">
      <template #header>
        <h3>修改密码</h3>
      </template>
      <el-form :model="formData" ref="passFormRef" :rules="rules">
        <el-form-item prop="oldPass">
          <el-input v-model="formData.oldPass" placeholder="请输入原密码">
            <template #prefix>
              <el-icon><Lock /></el-icon>
            </template>
          </el-input>
        </el-form-item>
        <el-form-item prop="newPass">
          <el-input v-model="formData.newPass" placeholder="请输入新密码">
            <template #prefix>
              <el-icon><Lock /></el-icon> </template
          ></el-input>
        </el-form-item>
        <el-form-item prop="confirmNewPass">
          <el-input
            v-model="formData.confirmNewPass"
            placeholder="请输入新密码"
          >
            <template #prefix>
              <el-icon><Lock /></el-icon> </template
          ></el-input>
        </el-form-item>
      </el-form>
      <div class="dialog-footer">
        <el-button type="primary" @click="submitForm">确定</el-button>
        <el-button @click="passDialogVisible = false">取消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script setup lang="ts">
import { ref, reactive, computed } from 'vue'
import { Lock } from '@element-plus/icons-vue'
import type { FormInstance } from 'element-plus'
import useIndexAccountStore from '@/stores/modules/index/account'

const indexAccountStore = useIndexAccountStore()
const emit = defineEmits(['update:dialogVisible'])
const props = defineProps<{
  dialogVisible: boolean
}>()

const passFormRef = ref<FormInstance>()

const passDialogVisible = computed({
  get: () => props.dialogVisible,
  set: (val) => {
    emit('update:dialogVisible', val)
  }
})

const formData = reactive({
  oldPass: '',
  newPass: '',
  confirmNewPass: ''
})

const submitForm = () => {
  passFormRef.value?.validate((valid) => {
    if (valid) {
      const data = {
        oldPass: formData.oldPass,
        newPass: formData.newPass
      }
      indexAccountStore.updatePasswordAction(data).then((res) => {
        if (res) {
          passDialogVisible.value = false
        }
      })
    }
  })
}

const rules = reactive({
  oldPass: [{ required: true, message: '请输入旧密码' }],
  newPass: [{ required: true, message: '请输入新密码' }],
  confirmNewPass: [{ required: true, message: '请确认新密码' }]
})
</script>

<style scoped lang="less">
.pass-dialog {
  .dialog-footer {
    text-align: right;
  }
}
</style>
