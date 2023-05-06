<template>
  <div class="dashboard">
    <el-row :gutter="15">
      <el-col :span="8">
        <el-card>
          <template #header>
            <div class="user-header">
              <img :src="user.avatarUrl" :alt="user?.nickName" />
              <div>
                <h3>{{ user?.nickName }}</h3>
                <span>{{ user.role.name }}</span>
              </div>
            </div>
          </template>
          <div class="user-container">
            <div class="user-container-item">
              <b>Register:</b>
              <span>{{ formatTime(user.createTime, false) }}</span>
            </div>

            <div class="user-container-item">
              <b>OS:</b>
              <span>{{ ua.os }}</span>
            </div>
            <div class="user-container-item">
              <b>Broswer:</b>
              <span>{{ ua.broswer }}</span>
            </div>
          </div>
        </el-card>
        <el-card style="margin-top: 15px">
          <template #header>
            <h3>联系方式</h3>
          </template>
          <div style="line-height: 30px">
            <p>
              <b>QQ：</b>
              <span>194908655</span>
            </p>
            <p>
              <b>微信：</b>
              <span>z194908655</span>
            </p>
          </div>
        </el-card>
      </el-col>
      <el-col :span="16">
        <el-row :gutter="15">
          <el-col :span="8">
            <div class="info-item">
              <el-card>
                <div class="logo-item" style="background-color: #585858">
                  <el-icon><Document /></el-icon>
                </div>
                <div class="info-item-des">
                  <h3>{{ countList.articleCount }}</h3>
                  <span>文章</span>
                </div>
              </el-card>
            </div>
          </el-col>
          <el-col :span="8">
            <div class="info-item">
              <el-card>
                <div class="logo-item" style="background-color: #409eff">
                  <el-icon><UserFilled /></el-icon>
                </div>
                <div class="info-item-des">
                  <h3>{{ countList.userCount }}</h3>
                  <span>用户</span>
                </div>
              </el-card>
            </div>
          </el-col>
          <el-col :span="8">
            <div class="info-item">
              <el-card>
                <div class="logo-item" style="background-color: #67c23a">
                  <el-icon><Flag /></el-icon>
                </div>
                <div class="info-item-des">
                  <h3>{{ countList.todayRecordCount }}</h3>
                  <span>今日打靶数</span>
                </div>
              </el-card>
            </div>
          </el-col>
        </el-row>
        <el-card style="margin-top: 15px">
          <template #header>
            <h3>简介介绍</h3>
          </template>
          <div style="line-height: 30px">
            <p>
              这是一个网络安全在线靶场社区，一个毕业设计项目，包含功能大致如：在线开启靶场打靶、社区交互、在线编程、工具下载、后台对前台数据增删改查、完善的权限系统等
            </p>
            <p>
              <b>当前版本：</b>
              <span>v1.0.0</span>
            </p>
            <p>
              <b>项目地址：</b>
              <a href="https://gitee.com/nifeng6/nfoj" target="_blank"
                >https://gitee.com/nifeng6/nfoj</a
              >
            </p>
            <p>
              <b>前端选型：</b>
              <span
                >Vue3 + TypeScript + Vite3 + Less + ElementPlus + Pinia + Axios
                + Echart + Wangeditor + Codemirror ...
              </span>
            </p>
            <p>
              <b>后端选型：</b>
              <span
                >Springboot + Spring Security + Jwt + MybatisPlus + Mysql +
                Redis + Docker + Nginx + NodeJs + FastJSON ...</span
              >
            </p>
          </div>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script setup lang="ts">
import useAdminGlobalStore from '@/stores/modules/admin/global'
import useCommonAccountStore from '@/stores/modules/common/account'
import useAdminDashboardStore from '@/stores/modules/admin/dashboard'
import { formatTime } from '@/utils/format-time'
import { storeToRefs } from 'pinia'
import { computed } from 'vue'
import { Document, UserFilled, Flag } from '@element-plus/icons-vue'

const ua = computed(() => {
  return {
    broswer: (navigator! as any).userAgentData.brands[1].brand +
      '' +
      (navigator! as any).userAgentData.brands[1].version,
    os: (navigator! as any).userAgentData.platform
  }
})

const adminDashboardStore = useAdminDashboardStore()
const adminGlobalStore = useAdminGlobalStore()
const commonAccountStore = useCommonAccountStore()

adminDashboardStore.getCountList()

const { countList } = storeToRefs(adminDashboardStore)
const { user } = storeToRefs(commonAccountStore)
</script>

<style scoped lang="less">
.dashboard {
  .user-header {
    display: flex;
    align-items: center;
    img {
      width: 80px;
      height: 80px;
      border-radius: 5px;
      margin-right: 10px;
    }
    div {
      flex: 1;
      text-align: center;
      h3 {
        color: #409eff;
        font-size: 20px;
        font-weight: 500;
        margin: 5px 0;
        margin-bottom: 15px;
      }
      span {
        color: #585858;
        font-size: 14px;
      }
    }
  }
  .user-container {
    .user-container-item {
      line-height: 30px;
      b:first-child {
        margin-right: 5px;
        width: 80px;
        text-align: right;
        display: inline-block;
      }
      span:last-child {
        margin-left: 10px;
      }
    }
  }
  .info-item {
    ::v-deep .el-card {
      border: none;
    }
    ::v-deep .el-card__body {
      padding: 0;
      height: 100px;
      display: flex;
      .logo-item {
        color: #fff;
        height: 100%;
        display: flex;
        align-items: center;
        justify-content: center;
        font-size: 30px;
        width: 60%;
      }
      .info-item-des {
        width: 100%;
        display: flex;
        justify-content: center;
        align-items: center;
        flex-direction: column;
        h3 {
          font-weight: 800;
          font-size: 25px;
          margin-bottom: 15px;
        }
        span {
          font-size: 13px;
        }
      }
    }
  }

  p {
  }
  b {
    color: #676a6c;
    font-size: 15px;
  }
  span {
    font-size: 14px;
    color: #676a6c;
  }
}
</style>
