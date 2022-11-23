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
        <span>{{ article.type?.name }} </span>
      </span>
    </div>

    <div
      ref="contentRef"
      class="article-content"
      v-dompurify-html="article.content"
      v-highlight
    ></div>
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
import { watch, onMounted, nextTick, ref } from 'vue'
import usecommonRootStore from '@/stores/modules/common/root'

const commonRootStore = usecommonRootStore()

const contentRef = ref()

const indexArticleStore = useIndexArticleStore()

const { article } = storeToRefs(indexArticleStore)

watch(
  () => article.value.title,
  (title) => {
    commonRootStore.changeDomTitle(title)
  }
)

watch(article, () => {
  nextTick(() => {
    var e = contentRef.value.querySelectorAll('code')
    console.log(e)

    var e_len = e.length

    for (let i = 0; i < e_len; i++) {
      e[i].innerHTML =
        '<ul><li>' +
        e[i].innerHTML.replace(/\n/g, '\n</li><li>') +
        '\n</li></ul>'
    }
  })
})

onMounted(() => {
  nextTick(() => {
    var e = contentRef.value.querySelectorAll('code')
    console.log(e)

    var e_len = e.length

    for (let i = 0; i < e_len; i++) {
      e[i].innerHTML =
        '<ul><li>' +
        e[i].innerHTML.replace(/\n/g, '\n</li><li>') +
        '\n</li></ul>'
    }
  })
})
</script>

<style>
pre {
  margin: 5px 0;
}

.hljs ul {
  list-style: decimal;

  margin: 0 0 0 40px !important;

  padding: 0;
}

.hljs li {
  list-style: decimal-leading-zero;

  border-left: 1px solid #111 !important;

  padding: 2px 5px !important;

  margin: 0 !important;

  line-height: 14px;

  width: 100%;

  box-sizing: border-box;
}

.hljs li:nth-of-type(even) {
  background-color: rgba(255, 255, 255, 0.015);

  color: inherit;
}
</style>

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
