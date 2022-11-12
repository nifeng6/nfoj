<template>
  <a target="_blank" :href="`/article/${itemData.id}`" class="article-item">
    <el-card shadow="hover">
      <div class="wrapper">
        <div class="item-left">
          <div style="float: left">
            <el-avatar :size="50" :src="itemData?.user?.avatarUrl"></el-avatar>
          </div>
          <div
            style="
              margin-left: 15px;
              display: inline-block;
              color: #333;
              font-size: 16px;
            "
          >
            <div style="">{{ itemData.title }}</div>
            <span style="font-size: 13px; color: #999">
              <span>{{ itemData.user?.nickName }}</span>
              <span style="margin-left: 15px">
                <span
                  >发布于：{{ timeBeautifulFormat(itemData.createTime) }}</span
                >
              </span>
            </span>
            <div style="margin-top: 3px">
              <el-tag class="ml-2" type="info" size="small"
                ># {{ itemData.typeName }}</el-tag
              >
            </div>
          </div>
        </div>

        <div class="item-right">
          <div
            style="
              display: flex;
              flex-direction: column;
              text-align: center;
              margin-right: 20px;
            "
          >
            <el-icon :size="18" color="#a4a4a4"><ChatLineRound /></el-icon>
            <span style="">{{ itemData.replyCount }}</span>
          </div>

          <div
            style="display: flex; flex-direction: column; align-items: center"
          >
            <el-icon :size="18" color="#a4a4a4"><View /></el-icon>
            <span style="">{{ itemData.view }}</span>
          </div>
        </div>
      </div>
    </el-card>
  </a>
</template>

<script setup lang="ts">
import { ChatLineRound, View } from '@element-plus/icons-vue'
import { timeBeautifulFormat } from '@/utils/format-time'

defineProps({
  itemData: {
    type: Object,
    required: true
  }
})
</script>

<style lang="less" scoped>
.article-item {
  margin: 10px 0;
  display: block;
  .wrapper {
    display: flex;
    justify-content: space-between;

    .item-right {
      display: flex;
      flex-direction: row;
      align-items: center;
      font-size: 13px;
    }
  }
}
</style>
