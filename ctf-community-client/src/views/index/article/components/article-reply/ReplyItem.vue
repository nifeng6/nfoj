<template>
  <el-card shadow="hover" class="reply-item">
    <div style="float: left; margin-right: 10px">
      <el-avatar :size="50" :src="itemData?.user.avatarUrl"></el-avatar>
    </div>
    <div>
      <div style="margin-top: 5px">
        <span>{{ itemData?.user.nickName }}</span>
        <span style="margin-left: 15px; color: #888; font-size: 12px"
          >{{ timeBeautifulFormat(itemData?.createTime) }}</span
        >
      </div>
      <div style="margin-top: 15px; font-size: 14px">
        <span v-if="type === 'child'"
          >@{{ itemData?.replyUser.nickName }}：</span
        >
        <span v-dompurify-html="itemData?.content" class="reply-content"></span>
      </div>
      <div
        style="
          text-align: right;
          color: #777;
          font-size: 12px;
          margin-top: 10px;
        "
      >
        <span style="cursor: pointer" @click="replyHandle">回复</span>
      </div>
    </div>
    <div class="footer">
      <slot name="footer" />
    </div>
  </el-card>
</template>

<script lang="ts" setup>
import { withDefaults } from 'vue'
import { timeBeautifulFormat } from '@/utils/format-time'
const emit = defineEmits(['replyBtnClick'])

// 设置props默认值
const props = withDefaults(
  defineProps<{
    itemData: any
    type: string
  }>(),
  {
    type: 'father'
  }
)

const replyHandle = () => {
  const date = {
    replyId: props.itemData.id,
    replyFatherId: props.itemData.replyFatherId,
    replyUserId: props.itemData.user.id,
    type: props.type
  }
  console.log(props.itemData)
  emit('replyBtnClick', date)
}
</script>

<style scoped lang="less">
.reply-item {
  margin: 10px 0;
  .footer {
    margin-left: 50px;
  }
  .reply-content{
    display: inline-block;
  }
}
</style>
