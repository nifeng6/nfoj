<template>
  <div class="security">
    <h2>安全设置</h2>
    <div class="reset-passwd reset-item">
      <div>
        <h5>账户密码</h5>
        <p>已设置密码</p>
      </div>
      <el-link
        :underline="false"
        type="primary"
        @click="passDialogVisible = true"
        >修改密码</el-link
      >
    </div>
    <el-divider></el-divider>
    <div class="reset-email reset-item">
      <h5>密保手机</h5>
      <p>***********</p>
    </div>
    <el-divider></el-divider>
    <div class="reset-phone reset-item">
      <h5>密保邮箱</h5>
      <p>*********</p>
    </div>
  </div>
  <PassDialog v-model:dialogVisible="passDialogVisible" />
</template>

<script setup lang="ts">
import PassDialog from './compoenents/PassDialog.vue'
import { ref } from 'vue'

const passDialogVisible = ref(false)
</script>

<style scoped lang="less">
.security {
  h2 {
    font-size: 20px;
    font-weight: 500;
    margin: 20px 0;
  }
  .reset-item {
    padding-right: 20px;
    h5 {
      margin-bottom: 4px;
      color: rgba(0, 0, 0, 0.65);
      font-size: 14px;
      line-height: 22px;
    }
    p {
      color: rgba(0, 0, 0, 0.45);
      font-size: 14px;
      line-height: 22px;
    }
  }
  .reset-passwd {
    display: flex;
    justify-content: space-between;
  }
}
</style>
