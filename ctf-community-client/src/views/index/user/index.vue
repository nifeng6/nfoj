<template>
  <div class="user">
    <Header />
    <Navigator v-model:activeIndex="activeIndex" />
    <div class="content">
      <el-row :gutter="10">
        <el-col :span="18">
          <Left :activeIndex="activeIndex" />
        </el-col>
        <el-col :span="6">
          <Right />
        </el-col>
      </el-row>
    </div>
  </div>
</template>

<script setup lang="ts">
import Header from './components/top/index.vue'
import Navigator from './components/navigator/index.vue'
import Left from './components/left/index.vue'
import Right from './components/right/index.vue'
import { ref } from 'vue'
import useIndexUserStore from '@/stores/modules/index/user'
import useCommonRootStore from '@/stores/modules/common/root'
// 导入路由获取参数
import { useRoute } from 'vue-router'

const route = useRoute()

const userId = route.params.user_id

const indexUserStore = useIndexUserStore()
const commonRootStore = useCommonRootStore()

indexUserStore.getUserInfoAction(Number.parseInt(userId as string))
indexUserStore.getUserRecordAction(Number.parseInt(userId as string))
indexUserStore.getUserArticleListAction(Number.parseInt(userId as string))
indexUserStore.getUserCtfListAction(Number.parseInt(userId as string))
commonRootStore.changeDomTitle()
const activeIndex = ref(0)
</script>

<style scoped lang="less">
.user {
  max-width: 1250px;
  margin: 0 auto;
}

.content {
  margin: 10px 0;
}
</style>
