<template>
  <div class="coder">
    <div class="container">
      <el-row>
        <el-col :xs="24" :sm="14" :md="14" :lg="14" :xl="14">
          <el-card>
            <div class="run-btn">
              <div class="run-btn-left">
                <el-button type="primary" :loading="runLoading"
                  >执行代码</el-button
                >
              </div>
              <div class="run-btn-right">
                <el-select
                  v-model="runTypeValue"
                  placeholder="JAVA"
                  style="margin-right: 6px"
                >
                  <el-option
                    v-for="item in runTypeList"
                    :key="item"
                    :value="item"
                  ></el-option>
                </el-select>
                <el-button>分享代码</el-button>
              </div>
            </div>
            <div class="run-edit">
              <CodeMirror
                v-model="editValue"
                :default-value="editDefaultValue"
                :read-only="false"
              />
            </div>
          </el-card>
        </el-col>

        <el-col :xs="24" :sm="10" :md="10" :lg="10" :xl="10">
          <div class="run-console">
            <div class="run-header">
              <span>输出：</span>
              <el-button>清除终端</el-button>
            </div>
            <div class="run-result">test</div>
          </div>
        </el-col>
      </el-row>
    </div>

    <el-dialog title="二维码分享" width="25%">
      <div style="display: flex; justify-content: center">
        <img alt="" />
      </div>
    </el-dialog>
  </div>
</template>

<script setup lang="ts">
import { ref } from 'vue'
import CodeMirror from '@/components/comm/CodeMirror/index.vue'

const runLoading = ref(false)

const runTypeList = ['JAVA', 'Python2', 'Python3']
const runTypeValue = ref('JAVA')

const editValue = ref('')
const editDefaultValue = ref('test')
</script>

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
    }
  }
}
</style>
