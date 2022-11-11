<template>
  <div class="article">
    <h1 class="title">{{ article.title }}</h1>

    <div class="article-info">
      <span class="article-auth">
        <el-avatar :size="24" :src="article.user?.avatarUrl"></el-avatar>

        <span style="margin-left: 8px">
          <span>{{ article.user?.username }}</span>
        </span>
      </span>

      <span class="create_time">
        <span style="font-weight: 600">时间：</span>
        <span>{{ formatTime(article.createTime, false) }}</span>
      </span>
      <span style="margin-left: 15px">
        <span style="font-weight: 600">浏览：</span>
        <span>{{ article.view }}</span>
      </span>
      <span style="margin-left: 15px">
        <span style="font-weight: 600">分类：</span>
        <span>{{ article.sort?.name }} </span>
      </span>
    </div>

    <div class="article-content" v-html="article.content"></div>
    <TipsCard style="font-size: 13px">
      <span>免责声明</span><br />
      <span
        >本站提供的一切软件、教程和内容信息仅限用于学习和研究目的；不得将上述内容用于商业或者非法用途，否则，一切后果请用户自负。本站信息来自网络收集整理，版权争议与本站无关。您必须在下载后的24个小时之内，从您的电脑或手机中彻底删除上述内容。如果您喜欢该程序和内容，请支持正版，购买注册，得到更好的正版服务。我们非常重视版权问题，如有侵权请邮件与我们联系处理。敬请谅解！</span
      >
    </TipsCard>
  </div>
</template>

<script setup lang="ts">
import useIndexArticleStore from '@/stores/modules/index/article'
import { storeToRefs } from 'pinia'
import { formatTime } from '@/utils/format-time'

const indexArticleStore = useIndexArticleStore()

const { article } = storeToRefs(indexArticleStore)
</script>

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
