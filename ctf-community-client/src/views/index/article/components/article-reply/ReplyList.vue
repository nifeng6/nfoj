<template>
  <div class="reply-list" v-if="replyList.length != 0">
    <template v-for="item in replyList">
      <ReplyItem type="father" :itemData="item" @replyBtnClick="replyBtnClick">
        <template #footer type="child" v-show="item.replyList.length !== 0">
          <template v-for="subitem in item.replyList">
            <ReplyItem
              type="child"
              :itemData="subitem"
              @replyBtnClick="replyBtnClick"
            ></ReplyItem>
          </template>
        </template>
      </ReplyItem>
    </template>
    <div class="pagination">
      <el-pagination
        background
        layout="prev, pager, next"
        :page-size="replyPage.pageSize"
        :total="replyPage.total"
        :current-page="replyPage.currentPage"
        @current-change="currentChangeHandle"
      ></el-pagination>
    </div>
  </div>
  <div v-else style="text-align: center; color: #666; font-size: 13px">
    <span>此条文章还没有评论</span>
  </div>
  <ReplyDialog v-model:dialogVisible="dialogVisible" :replyData="replyData" />
</template>

<script setup lang="ts">
import ReplyItem from './ReplyItem.vue'
import useIndexArticleStore from '@/stores/modules/index/article/index'
import { storeToRefs } from 'pinia'
import { useRoute } from 'vue-router'
import { ref, reactive } from 'vue'
import ReplyDialog from './ReplyDialog.vue'

const dialogVisible = ref(false)
const replyData = reactive({
  replyId: 0,
  replyUserId: 0,
  replyFatherId: 0,
  type: 'father'
})
const indexArticleStore = useIndexArticleStore()

const route = useRoute()
const { replyList, replyPage } = storeToRefs(indexArticleStore)

const currentChangeHandle = (activePage: number) => {
  replyPage.value.currentPage = activePage
  indexArticleStore.getArticleReplyListAction(
    Number.parseInt(route.params.article_id.toString())
  )
}
// 接收子组件传递的参数与点击，用于用户评论
const replyBtnClick = (data: any) => {
  replyData.replyId = data.replyId
  replyData.replyFatherId = data.replyFatherId
  replyData.replyUserId = data.replyUserId
  replyData.type = data.type
  console.log(replyData)
  dialogVisible.value = true
}
</script>

<style scoped lang="less"></style>
