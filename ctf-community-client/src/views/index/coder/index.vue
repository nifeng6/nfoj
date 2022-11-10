<template>
  <div class="coder">
    <div class="container">
      <el-row>
        <el-col :xs="24" :sm="14" :md="14" :lg="14" :xl="14">
          <el-card>
            <div class="run-btn">
              <div class="run-btn-left">
                <el-button
                  type="primary"
                  :loading="loading"
                  @click="runCodeHandle"
                  >执行代码</el-button
                >
              </div>
              <div class="run-btn-right">
                <el-select
                  v-model="runTypeValue"
                  placeholder="JAVA"
                  style="margin-right: 6px"
                  @change="run_type_change"
                >
                  <el-option
                    v-for="item in runTypeList"
                    :key="item"
                    :value="item"
                  ></el-option>
                </el-select>
                <el-button @click="shareCodeHandler">分享代码</el-button>
              </div>
            </div>
            <div class="run-edit">
              <CodeMirror
                v-model="editValue"
                :default-value="editValue"
                :read-only="false"
              />
            </div>
          </el-card>
        </el-col>

        <el-col :xs="24" :sm="10" :md="10" :lg="10" :xl="10">
          <div class="run-console">
            <div class="run-header">
              <span class="status-text"
                >输出：
                <span
                  v-if="runResult.code === 1"
                  style="background: rgb(92, 184, 92)"
                  v-show="runResult.content !== ''"
                >
                  完成
                </span>
                <span
                  v-else
                  style="background: red"
                  v-show="runResult.content !== ''"
                >
                  失败
                </span>
              </span>
              <el-button @click="clearHandle">清除终端</el-button>
            </div>
            <div class="run-result" v-show="runResult.content !== ''">
              <div
                :style="{
                  color: runResult.code === 0 ? 'red' : 'rgb(92, 184, 92)'
                }"
              >
                执行耗时：{{ runResult.runTime }}ms
              </div>
              <div>{{ runResult.content }}</div>
            </div>
          </div>
        </el-col>
      </el-row>
    </div>

    <el-dialog title="二维码分享" width="25%" v-model="qrcodeDialogVisible">
      <div style="display: flex; justify-content: center">
        <img alt="代码分享二维码" :src="shareResult.qrcode" />
      </div>
    </el-dialog>
  </div>
</template>

<script setup lang="ts">
import { ref } from 'vue'
import CodeMirror from '@/components/comm/CodeMirror/index.vue'
import useIndexCoderStore from '@/stores/modules/index/coder'
import useCommonAccountStore from '@/stores/modules/common/account'
import { storeToRefs } from 'pinia'
import { useRoute } from 'vue-router'
import { ElMessage } from 'element-plus'

const commonAccountStore = useCommonAccountStore()
const route = useRoute()
const key = route.query.key

const indexCoderStore = useIndexCoderStore()
const { loading, runResult, shareResult, shareCode } =
  storeToRefs(indexCoderStore)
const { token, accountDialogVisible } = storeToRefs(commonAccountStore)

const qrcodeDialogVisible = ref(false)

type IRunType = 'JAVA' | 'Python' | 'Python3'

const runTypeList = ['JAVA', 'Python', 'Python3']
const runTypeValue = ref<IRunType>('JAVA')

const runCodeList = {
  JAVA: `// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}`,
  Python: `# -*- coding: utf-8 -*-

print "Hello World!"`,
  Python3: 'print("Hello World!")'
}

const editValue = ref(runCodeList[runTypeValue.value])

if (key !== undefined) {
  indexCoderStore.getShareCodeAction(key as string).then((res) => {
    if (res) {
      editValue.value = shareCode.value.content
      runTypeValue.value = shareCode.value.type as IRunType
    }
  })
}

const runCodeHandle = () => {
  const data = {
    code: editValue.value,
    type: runTypeValue.value
  }

  indexCoderStore.codeRunAction(data)
}

const clearHandle = () => {
  runResult.value.content = ''
  runResult.value.code = 0
  runResult.value.runTime = 0
}

// 分享代码
const shareCodeHandler = () => {
  if (!token.value) {
    accountDialogVisible.value = true
    ElMessage.error('请先登录')
    return
  }

  const data = {
    content: editValue.value,
    type: runTypeValue.value
  }
  indexCoderStore.codeShareAction(data).then((res) => {
    if (res) {
      qrcodeDialogVisible.value = true
    }
  })
}

// 切换代码类型
const run_type_change = (key: IRunType) => {
  runTypeValue.value = key
  editValue.value = runCodeList[key]
}
</script>

<style>
.el-message {
  z-index: 3000 !important;
}
</style>
<style scoped lang="less">
.coder {
  .container {
  }

  .run-btn {
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 10px 0;
    border-bottom: 1px solid #ebeef5;
  }

  .run-btn-left {
    display: flex;
    align-items: center;
  }

  .run-console {
    padding: 10px;
    .run-header {
      display: flex;
      justify-content: space-between;
      align-items: center;
      .status-text {
        span {
          padding: 5px 10px;
          font-size: 13px;
          border-radius: 20px;
          color: #fff;
        }
      }
    }
  }
  .run-result {
    margin-top: 10px;
    font-size: 15px;
    line-height: 25px;
    color: #333;
  }
}
</style>
