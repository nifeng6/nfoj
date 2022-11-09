<template>
  <div class="ctf-list">
    <template v-for="item in ctfList" :key="item.id">
      <ArticleCard style="cursor: pointer; margin: 10px 0">
        <template #other>
          <div
            class="finishedmark"
            :style="{
              background:
                item.isSuccess == 1
                  ? 'rgba(9, 134, 49, 0.67)'
                  : 'rgba(255, 0, 0, 0.67)'
            }"
          >
            {{ item.isSuccess == 1 ? '已完成' : '未完成' }}
          </div>
        </template>
        <template #leftTop>
          <div class="top">{{ item.lab.title }}</div>
        </template>
        <template #leftBottom>
          <div class="bottom">
            <span>创建时间:{{ item.createTime }}</span>
            <span></span>
          </div>
        </template>
        <template #rightBottom>
          <div class="bottom">分类：{{ item.lab.type.name }}</div>
        </template>
      </ArticleCard>
    </template>
  </div>
</template>

<script setup lang="ts">
import ArticleCard from '@/components/index/ArticleCard/index.vue'
import useIndexUserStore from '@/stores/modules/index/user'
import { storeToRefs } from 'pinia'

const { ctfList } = storeToRefs(useIndexUserStore())
</script>

<style scoped lang="less">
.ctf-list {
  .finishedmark {
    position: absolute;
    color: #fff;
    text-decoration: none;
    font-family: arial, sans-serif;
    text-align: center;
    font-weight: 700;
    padding: 0 20px;
    transition: 0.5s;
    top: 12px;
    left: -19px;
    font-size: 13px;
    transform: rotate(-45deg);
    -ms-transform: rotate(-45deg);
    -moz-transform: rotate(-45deg);
    -webkit-transform: rotate(-45deg);
    -o-transform: rotate(-45deg);
  }
  .top {
    margin-bottom: 10px;
  }

  .bottom {
    color: rgb(162, 162, 162);
    font-size: 13px;
  }
}
</style>
