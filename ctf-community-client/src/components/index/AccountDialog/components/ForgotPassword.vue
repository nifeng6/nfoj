<template>
  <div class="forgot-password">
    <el-form ref="ruleFormRef" :model="ruleForm" status-icon :rules="rules">
      <el-form-item prop="username">
        <el-input
          size="large"
          v-model="ruleForm.email"
          placeholder="请输入邮箱号"
        >
          <template #prefix>
            <el-icon class="el-input__icon"><Message /></el-icon>
          </template>
        </el-input>
      </el-form-item>

      <el-form-item>
        <el-button
          style="width: 100%"
          type="primary"
          size="large"
          @click="resetHandle"
          >点击发送重置密码邮件</el-button
        >
      </el-form-item>
    </el-form>
  </div>
</template>

<script setup lang="ts">
import { ref, computed } from 'vue'
import { Message } from '@element-plus/icons-vue'
import type { FormInstance } from 'element-plus'
import useCommonAccountStore from '@/stores/modules/common/account'

const commonAccountStore = useCommonAccountStore()
const ruleForm = reactive({
  email: ''
})

const emit = defineEmits(['update:dialogVisible'])
const props = defineProps<{
  dialogVisible: boolean
}>()

const dialogVisible = computed({
  get() {
    return props.dialogVisible
  },
  set(val) {
    emit('update:dialogVisible', val)
  }
})

const resetHandle = () => {
  const data = {
    email: ruleForm.email
  }
  commonAccountStore.resetPasswordEmailSendAction(data).then((status) => {
    if (status) {
      // dialogVisible.value = false
    }
  })
}

const rules = reactive({
  email: [{ required: true, message: '请输入邮箱号', trigger: 'blur' }]
})

const ruleFormRef = ref<FormInstance>()
</script>

<style scoped lang="less">
.forgot-password {
}
</style>
