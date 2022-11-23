<template>
  <div class="friendly-link">
    <el-card class="notice" shadow="never">
      <template></template>
      <template #header>
        <div class="friendly-title">
          <span class="title-text">
            <el-icon><Link /></el-icon>
            <span>友情链接</span>
          </span>
        </div>
      </template>
      <div class="friendly-content">
        <el-row>
          <el-col :span="8">
            <el-tooltip
              effect="dark"
              content="集美大学诚毅学院"
              placement="top"
            >
              <a href="http://chengyi.jmu.edu.cn/" target="_blank">
                <img src="@/assets/image/cyxy.png" alt="集美大学诚毅学院" />
              </a>
            </el-tooltip>
          </el-col>
        </el-row>
      </div>
    </el-card>
  </div>
</template>

<script setup lang="ts">
import { Link } from '@element-plus/icons-vue'
</script>

<style scoped lang="less">
.friendly-link {
  margin: 15px 0;
  ::v-deep .el-card__header {
    padding: 10px 20px;
  }
  .friendly-title {
    display: flex;
    justify-content: space-between;
    align-items: center;
    color: #409eff;
    font-family: Raleway;
    .title-text {
      display: flex;
      align-items: center;
      span {
        margin-left: 5px;
      }
    }
  }
  .friendly-content {
    a {
      border-radius: 3px;
      border: 1px solid #409eff;
      display: block;
      padding: 5px 10px;
      img {
        width: 100%;
      }
    }
  }
}
</style>
