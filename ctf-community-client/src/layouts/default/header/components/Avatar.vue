<template>
  <div class="avatar">
    <el-dropdown @command="commandHandle">
      <span style="height: 65px; line-height: 65px">
        <el-avatar
          :size="28"
          src="http://localhost:8080/img/home.4b578452.jpg"
          style="font-size: 10px; vertical-align: middle"
        >
        </el-avatar>

        <span style="margin-left: 13px; font-size: 15px">倪风</span>
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

<script setup lang="ts">
const commandHandle = (key: String) => {
  switch (key) {
    case 'qiandao':
      console.log('签到')
      break
    case 'user':
      console.log('个人中心')
      break
    case 'account':
      console.log('账户设置')
      break
    case 'logout':
      console.log('退出')
      break
  }
}
</script>

<style scoped lang="less">
.avatar {
  cursor: pointer;
  height: 100%;
  padding: 0 10px;
  &:hover {
    background-color: #f0f2f5;
  }
}
</style>
