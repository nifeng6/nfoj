<template>
  <div class="menu">
    <el-menu
      :default-active="$router.currentRoute.value.path"
      router
      mode="horizontal"
      style="height: 100%"
    >
      <el-menu-item index="/home">
        <i class="iconfont icon-shouye iconnav"></i> {{ t('header.home') }}
      </el-menu-item>
      <el-menu-item index="/ctf">
        <i class="iconfont icon-flag iconnav"></i>{{ t('header.safelab') }}
      </el-menu-item>
      <el-menu-item index="/tools">
        <i class="iconfont icon-Tool iconnav"></i>{{ t('header.safelab') }}
      </el-menu-item>
      <el-menu-item index="/coder">
        <i class="iconfont icon-codelibrary iconnav"></i>
        {{ t('header.onlinecode') }}
      </el-menu-item>
      <el-menu-item index="/bbs">
        <i class="iconfont icon-community iconnav"></i>{{ t('header.bbs') }}
      </el-menu-item>
    </el-menu>
  </div>
</template>

<script setup lang="ts">
import useI18n from '@/hooks/i18n-hook'

const {
  currentLocale,
  changeLocale,
  i18n: { t }
} = useI18n()
</script>

<style scoped lang="less">
@media screen and (max-width: 768px) {
  .menu {
    display: none;
  }
}
.menu {
  flex: 1;
  color: #495060;
  .iconnav {
    margin-right: 5px;
  }
  .el-menu--horizontal {
    border-bottom: 0;
  }
  .el-menu-item {
    padding: 15px;
    &.is-active {
      background: linear-gradient(270deg, #f2f7fc, #fefefe) !important;
    }
  }
  .el-menu-item:hover,
  .el-menu-item:focus {
    background: linear-gradient(270deg, #f2f7fc, #fefefe) !important;
    border-bottom: 2px solid var(--el-menu-active-color);
    transition: all 0.2s ease;
  }
}
</style>
