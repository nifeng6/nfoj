<template>
  <div class="avatar">
    <el-dropdown>
      <span class="el-dropdown-link">
        <el-avatar shape="square" :src="user.avatarUrl" />
        <span class="name">{{ user.username }}</span>
        <el-icon>
          <ArrowDown />
        </el-icon>
      </span>
      <template #dropdown>
        <el-dropdown-menu>
          <el-dropdown-item disabled>{{ user.username }}</el-dropdown-item>
          <el-dropdown-item><a href="/">网站首页</a></el-dropdown-item>
          <el-dropdown-item @click="logout">退出登录</el-dropdown-item>
        </el-dropdown-menu>
      </template>
    </el-dropdown>
  </div>
</template>

<script setup lang="ts">
import { ArrowDown } from '@element-plus/icons-vue'
import useCommonAccountStore from '@/stores/modules/common/account'
import { storeToRefs } from 'pinia'

const commonAccountStore = useCommonAccountStore()

commonAccountStore.getUserInfoAction()

const { user } = storeToRefs(commonAccountStore)

const logout = () => {
  commonAccountStore.userLogoutAction()
}
</script>

<style scoped lang="less">
.avatar {
  height: 100%;
  display: flex;
  align-items: center;
  cursor: pointer;
  img {
    width: 100%;
    height: 100%;
  }
  .el-dropdown-link {
    display: flex;
    align-items: center;
    .name {
      font-weight: 600;
      margin-left: 5px;
      margin-right: 5px;
    }
  }
}
</style>
