<template>
  <div class="base">
    <h2>基本设置</h2>

    <div>
      <el-row>
        <el-col :span="16">
          <div style="margin-bottom: 20px">
            <div style="margin-bottom: 10px">昵称</div>
            <el-input style="width: 85%" v-model="userInfo.nickName"></el-input>
          </div>
          <div style="margin-bottom: 30px">
            <div style="margin-bottom: 10px">个性签名</div>
            <el-input
              type="textarea"
              style="width: 85%"
              :rows="5"
              v-model="userInfo.description"
            ></el-input>
          </div>
          <div>
            <el-button
              type="primary"
              style="padding: 10px"
              @click="updateHandle"
            >
              提交更新
            </el-button>
          </div>
        </el-col>
        <el-col :span="8">
          <div style="text-align: center">
            <el-avatar :src="userInfo.avatarUrl" :size="200"></el-avatar>
          </div>
          <div style="text-align: center; margin-top: 20px">
            <el-upload>
              <el-button style="padding: 10px" type="primary"
                >更新头像</el-button
              >
            </el-upload>
          </div>
        </el-col>
      </el-row>
    </div>
  </div>
</template>

<script setup lang="ts">
import useCommonAccountStore from '@/stores/modules/common/account'
import { storeToRefs } from 'pinia'
import { ref } from 'vue'
const commonAccountStore = useCommonAccountStore()

const { user } = storeToRefs(commonAccountStore)

const userInfo = ref({ ...user.value })

const updateHandle = () => {
  commonAccountStore.updateUserAction(userInfo.value)
}
</script>

<style scoped lang="less">
.base {
  h2 {
    font-size: 20px;
    font-weight: 500;
    margin: 20px 0;
  }
}
</style>
