<template>
  <el-card shadow="hover" class="reply-item">
    <div style="float: left; margin-right: 10px">
      <el-avatar
        :size="50"
        src="https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fup.enterdesk.com%2Fedpic_source%2F34%2F93%2Ffe%2F3493fec56c307642522b2bc2fc4461e0.jpg&refer=http%3A%2F%2Fup.enterdesk.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1644938763&t=4a3558526cb7183a0e420ec367b65a72"
      ></el-avatar>
    </div>
    <div>
      <div style="margin-top: 5px">
        <span>{{ replyItem.nickName }}</span>
        <span style="margin-left: 15px; color: #888; font-size: 12px"
          >时间：{{ replyItem.createTime }}</span
        >
      </div>
      <div style="margin-top: 15px; font-size: 14px">
        <p>@{{ replyItem.nickName }}：{{ replyItem.content }}</p>
      </div>
      <div
        style="
          text-align: right;
          color: #777;
          font-size: 12px;
          margin-top: 10px;
        "
      >
        <span style="cursor: pointer">回复</span>
      </div>
    </div>
    <div class="footer">
      <slot name="footer" />
    </div>
  </el-card>
</template>

<script lang="ts" setup>
const replyItem = {
  id: 1,
  nickName: '张三',
  content: '这是一条评论',
  createTime: '2021-10-10 10:10:10',
  replyId: 0
}
</script>

<style scoped lang="less">
.reply-item {
  margin: 10px 0;
  .footer {
    margin-left: 50px;
  }
}
</style>
