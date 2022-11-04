<template>
  <div class="article">
    <h1 class="title">这是文章标题</h1>

    <div class="article-info">
      <span class="article-auth">
        <el-avatar
          :size="24"
          src="https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fup.enterdesk.com%2Fedpic_source%2F34%2F93%2Ffe%2F3493fec56c307642522b2bc2fc4461e0.jpg&refer=http%3A%2F%2Fup.enterdesk.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1644938763&t=4a3558526cb7183a0e420ec367b65a72"
        ></el-avatar>
        <span style="margin-left: 8px">
          <span>倪风</span>
        </span>
      </span>

      <span class="create_time">
        <span style="font-weight: 600">时间：</span>
        <span>1小时前</span>
      </span>
      <span style="margin-left: 15px">
        <span style="font-weight: 600">浏览：</span>
        <span>100</span>
      </span>
      <span style="margin-left: 15px">
        <span style="font-weight: 600">分类：</span>
        <span>ceshi </span>
      </span>
      <span style="margin-left: 15px">
        <span style="font-weight: 600">评论：</span>
        <span>1111</span>
      </span>
    </div>

    <div class="article_content">测试数据</div>
    <TipsCard style="font-size: 13px">
      <span>免责声明</span><br />
      <span
        >本站提供的一切软件、教程和内容信息仅限用于学习和研究目的；不得将上述内容用于商业或者非法用途，否则，一切后果请用户自负。本站信息来自网络收集整理，版权争议与本站无关。您必须在下载后的24个小时之内，从您的电脑或手机中彻底删除上述内容。如果您喜欢该程序和内容，请支持正版，购买注册，得到更好的正版服务。我们非常重视版权问题，如有侵权请邮件与我们联系处理。敬请谅解！</span
      >
    </TipsCard>
  </div>
</template>

<script setup lang="ts"></script>

<style scoped lang="less">
.article {
  background-color: #fff;
  padding: 50px 40px;

  .title {
    font-size: 28px;
    font-weight: 600;
    color: #34495e;
    padding: 0 0 10px;
    width: 82%;
    line-height: 32px;
    word-break: break-all;
  }
  .article-info {
    display: flex;
    align-items: center;
    margin-bottom: 20px;
    font-size: 13px;
    color: #999;
    .create_time {
      margin-left: 15px;
    }
    .article-auth {
      display: flex;
      align-items: center;
    }
  }
}
</style>
