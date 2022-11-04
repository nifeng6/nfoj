<template>
  <div class="ctf-list">
    <ArticleCard style="cursor: pointer">
      <template #other>
        <div class="finishedmark" style="background: rgba(9, 134, 49, 0.67)">
          已拿下
        </div>
      </template>
      <template #leftTop>
        <div class="top">sqli-libs</div>
      </template>
      <template #leftBottom>
        <div class="bottom">
          <span>创建时间:8个月前</span>
          <span></span>
        </div>
      </template>
      <template #rightBottom>
        <div class="bottom">分类：基础技能</div>
      </template>
    </ArticleCard>
  </div>
</template>

<script setup lang="ts">
import ArticleCard from '@/components/index/ArticleCard/index.vue'
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
