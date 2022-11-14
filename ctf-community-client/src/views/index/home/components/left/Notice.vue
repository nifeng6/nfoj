<template>
  <div class="notice">
    <el-card class="notice" shadow="never">
      <template #header>
        <div class="notice-title">
          <span class="title-text">
            <el-icon>
              <Monitor />
            </el-icon>
            <span>{{ cardTitle }}</span>
          </span>
          <el-button type="primary" @click="flushHandle">{{
            cardType === 'list' ? '刷新' : '返回'
          }}</el-button>
        </div>
      </template>
      <div class="notice-content">
        <template
          v-if="cardType === 'list'"
          v-for="item in noticeList"
          :key="item.id"
        >
          <TipsCard style="margin-bottom: 10px">
            <div class="notice-item">
              <div class="notice-item-title" @click="itemClickHandle(item)">
                {{ item.title }}
              </div>
              <div class="notice-item-info">
                <span>{{ formatTime(item.createTime, false) }}</span>

                <span>{{ item.user?.nickName }}</span>
              </div>
            </div>
          </TipsCard>
        </template>
        <template v-else>
          <div v-html="currentNotice?.content"></div>
        </template>
      </div>
    </el-card>
  </div>
</template>

<script setup lang="ts">
import { Monitor } from '@element-plus/icons-vue'
import useIndexHomeStore from '@/stores/modules/index/home'
import { storeToRefs } from 'pinia'
import TipsCard from '@/components/comm/TipsCard/index.vue'
import { ref } from 'vue'
import type { INoticeData } from '@/types/index/home/index'
import { formatTime } from '@/utils/format-time'

const cardTitle = ref('公告')
const cardType = ref('list')
const currentNotice = ref<INoticeData | null>(null)
const indexHomeStore = useIndexHomeStore()

const { noticeList } = storeToRefs(indexHomeStore)

const itemClickHandle = (item: INoticeData) => {
  currentNotice.value = item
  cardTitle.value = item.title
  cardType.value = 'detail'
}

const flushHandle = () => {
  if (cardType.value === 'list') {
    indexHomeStore.getNoticeListAction()
  } else {
    cardTitle.value = '公告'
    cardType.value = 'list'
  }
}
</script>

<style scoped lang="less">
.notice {
  margin: 15px 0;
  ::v-deep .el-card__header {
    padding: 10px 20px;
  }
  .notice-title {
    display: flex;
    align-items: center;
    justify-content: space-between;
    color: #409eff;
    font-family: Raleway;
    .title-text {
      display: flex;
      align-items: center;
      span {
        margin-left: 5px;
      }
    }
  }

  .notice-content {
    text-align: center;

    .notice-item-title {
      font-size: 16px;
      font-style: oblique;
      margin-bottom: 10px;
      cursor: pointer;
      &:hover {
        color: #409eff;
      }
    }
    .notice-item-info {
      font-size: 14px;
      span {
        margin-right: 10px;
      }
    }
  }
}
</style>
