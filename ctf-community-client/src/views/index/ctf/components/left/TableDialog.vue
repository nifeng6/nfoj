<template>
  <el-dialog v-model="dialogVisible" width="40%">
    <template #header>
      <span>{{ activeItem.title }}</span>
    </template>
    <div class="lab-content">
      <el-skeleton :loading="labDetailLoading" animated>
        <template #template>
          <div class="lab-status">
            <div class="lab-status-item">
              <el-skeleton-item variant="text" style="width: 100px" />
            </div>
            <div class="lab-status-item">
              <el-skeleton-item variant="text" style="width: 100px" />
            </div>
            <div class="lab-status-item">
              <el-skeleton-item variant="text" style="width: 100px" />
            </div>
          </div>
          <div class="lab-intro">
            <el-skeleton-item variant="text" style="width: 50%" />
          </div>

          <div class="lab-start" v-if="labInfo.isExist === 1">
            <div>
              <el-skeleton-item variant="text" style="width: 50%" />
            </div>
          </div>

          <div class="lab-btn">
            <el-skeleton-item variant="button" style="width: 120px" />
          </div>
        </template>
        <template #default>
          <div class="lab-status">
            <div class="lab-status-item">
              <span>所需金币：</span>
              <span>{{ activeItem.needCoin }}</span>
            </div>
            <div class="lab-status-item">
              <span>题目状态：</span>
              <span v-if="labInfo.isSuccess === 1" style="color: #67c23a"
                >已解出</span
              >
              <span v-else style="color: #f56c6c">未解出</span>
            </div>
            <div class="lab-status-item">
              <span>解题奖励：</span>
              <span>{{ activeItem.goldCoin }}</span>
            </div>
          </div>
          <div class="lab-intro">
            {{ activeItem.intro }}
          </div>

          <div class="lab-start" v-if="labInfo.isExist === 1">
            <div>
              <!-- <el-progress :percentage="60" /> -->
              <div class="exp-time">
                {{ formatSeconds(labInfo.expTime) }}
              </div>
              <div class="lab-start-intro" v-html="labInfo.intro"></div>
            </div>
          </div>

          <div class="lab-btn">
            <el-button
              type="primary"
              @click="startLabHandle"
              v-if="labInfo.isExist === 0"
              :loading="startLabLoading"
            >
              <span v-if="!startLabLoading">
                开启靶场 <el-icon style="margin: 0 5px"><Coin /> </el-icon
                >{{ activeItem.goldCoin }}
              </span>
              <span v-else>靶场开启中...</span>
            </el-button>
            <el-button
              v-else
              type="danger"
              :loading="closeLabLoading"
              @click="closeLabHandle"
            >
              停止并摧毁靶场
            </el-button>
          </div>
        </template>
      </el-skeleton>
      <div class="lab-flag">
        <el-input v-model="flagValue" placeholder="nfoj{...}">
          <template #append>
            <el-button @click="submitFlagHandle">提交FLAG</el-button>
          </template>
        </el-input>
      </div>
    </div>
    <template #footer>
      <div class="dialog-footer">
        <span>你有更好的题目，分享下，大家共同进步？</span>
        <el-link type="primary">点击提交</el-link>
      </div>
    </template>
  </el-dialog>
</template>

<script setup lang="ts">
import { computed, watchEffect, ref } from 'vue'
import type { ICtf } from '@/types/index/ctf/index'
import { Coin } from '@element-plus/icons-vue'
import useIndexCtfStore from '@/stores/modules/index/ctf'
import { storeToRefs } from 'pinia'
import { formatSeconds } from '@/utils/format-time'

const indexCtfStore = useIndexCtfStore()
const { labInfo, startLabLoading, closeLabLoading, labDetailLoading } =
  storeToRefs(indexCtfStore)
// 用于关闭倒计时
let expTimekey: number
const emit = defineEmits(['update:dialogVisible'])
const props = defineProps<{
  dialogVisible: boolean
  activeItem: ICtf
}>()
const flagValue = ref('')
const expTimeCountDown = () => {
  expTimekey = setInterval(() => {
    if (labInfo.value.expTime > 0) {
      labInfo.value.expTime = labInfo.value.expTime - 1
    }
  }, 1000)
}

const dialogVisible = computed({
  get: () => props.dialogVisible,
  set: (val) => {
    emit('update:dialogVisible', val)
  }
})
// 不管有没有开启倒计时都关闭一下
watchEffect(() => {
  if (dialogVisible.value === true) {
    indexCtfStore.getCtfLabDetailAction(props.activeItem.id).then((res) => {
      if (res) {
        expTimeCountDown()
      }
    })
  } else {
    clearInterval(expTimekey)
  }
})

// 开启靶场
const startLabHandle = () => {
  indexCtfStore.startCtfLabAction(props.activeItem.id).then((res) => {
    if (res) {
      expTimeCountDown()
    }
  })
}
// 关闭靶场
const closeLabHandle = () => {
  indexCtfStore.closeCtfLabAction(props.activeItem.id).then((res) => {
    if (res) {
      clearInterval(expTimekey)
    }
  })
}
// 提交flag
const submitFlagHandle = () => {
  indexCtfStore.submitFlagAction(flagValue.value)
}
</script>

<style scoped lang="less">
.lab-content {
  .lab-status {
    display: flex;
    justify-content: space-between;
  }
  .lab-intro {
    margin: 15px 0;
    text-align: center;
  }
  .lab-btn {
    text-align: center;
  }
  .lab-flag {
    display: flex;
    margin-top: 15px;
  }
  .lab-start {
    margin-bottom: 15px;
    .exp-time {
      text-align: center;
      margin-bottom: 15px;
    }
  }
}
.dialog-footer {
  font-size: 14px;
  color: #606266;
}
</style>

<style>
.el-dialog__body {
  border-top: 1px solid #eee;
  border-bottom: 1px solid #eee;
  /* padding-bottom: 5px; */
}
</style>
