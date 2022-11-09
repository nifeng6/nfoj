<template>
  <div class="avatar">
    <!-- 已登录 -->
    <template v-if="!!token">
      <div class="logon">
        <el-dropdown @command="commandHandle">
          <span style="height: 65px; line-height: 65px">
            <el-avatar
              :size="28"
              :src="user.avatarUrl"
              style="font-size: 10px; vertical-align: middle"
            >
            </el-avatar>

            <span style="margin-left: 13px; font-size: 15px">{{
              user.nickName
            }}</span>
          </span>
          <template #dropdown>
            <el-dropdown-menu>
              <el-dropdown-item command="qiandao">
                <i class="iconfont icon-Sign iconnav"></i>
                签到
              </el-dropdown-item>
              <el-dropdown-item command="user">
                <i class="iconfont icon-person iconnav"></i>
                个人中心
              </el-dropdown-item>
              <el-dropdown-item command="account">
                <i class="iconfont icon-setting iconnav"></i>
                账户设置
              </el-dropdown-item>
              <el-dropdown-item command="logout">
                <i class="iconfont icon-logout iconnav"></i>
                退出
              </el-dropdown-item>
            </el-dropdown-menu>
          </template>
        </el-dropdown>
      </div>
    </template>
    <!-- 未登录 -->
    <template v-else>
      <div class="unlogin">
        <el-button type="primary" @click="unloginHandle('login')">
          登录
        </el-button>
        <el-button @click="unloginHandle('register')"> 注册 </el-button>
      </div>
    </template>
  </div>
  <AccountDialog />
</template>

<script setup lang="ts">
import { ref } from 'vue'
import AccountDialog from '@/components/index/AccountDialog/index.vue'
import useCommonAccountStore from '@/stores/modules/common/account'
import useIndexAccountStore from '@/stores/modules/index/account'
import { storeToRefs } from 'pinia'
const commonAccountStore = useCommonAccountStore()
const indexAccountStore = useIndexAccountStore()
const { token, user, accountDialogVisible, accountDialogType } =
  storeToRefs(commonAccountStore)

const unloginHandle = (type: string) => {
  accountDialogType.value = type
  accountDialogVisible.value = true
}

const commandHandle = (key: String) => {
  switch (key) {
    case 'qiandao':
      indexAccountStore.getAccountQiandaoAction()
      break
    case 'user':
      window.location.href = '/user/' + user.value.id
      break
    case 'account':
      window.location.href = '/account'
      break
    case 'logout':
      logoutHandle()
      break
  }
}

// 退出登录
const logoutHandle = () => {
  commonAccountStore.userLogoutAction()
}
</script>

<style scoped lang="less">
.avatar {
  .logon {
    cursor: pointer;
    height: 100%;
    padding: 0 10px;
    &:hover {
      background-color: #f0f2f5;
    }
  }
  .unlogin {
    height: 100%;
    display: flex;
    align-items: center;
  }
}
</style>
