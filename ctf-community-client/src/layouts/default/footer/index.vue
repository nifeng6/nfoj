<template>
  <div class="footer">
    <div class="wrapper">
      <div class="footer-top">
        <div class="footer-top-item">
          <div class="footer-top-item-title">NFOJ</div>
          <ul>
            <li>
              <a href="#" target="_blank">NFOJ</a>
            </li>
          </ul>
        </div>
        <div class="footer-top-item">
          <div class="footer-top-item-title">
            {{ t('footer.service') }}
          </div>
          <ul>
            <li>
              <a href="#" target="_blank">{{
                t('footer.service.systeminfo')
              }}</a>
            </li>
            <li>
              <a href="#" target="_blank">{{
                t('footer.service.usersubmission')
              }}</a>
            </li>
          </ul>
        </div>
        <div class="footer-top-item">
          <div class="footer-top-item-title">{{ t('footer.dev') }}</div>
          <ul>
            <li>
              <a href="#" target="_blank">Github</a>
            </li>
            <li>
              <a href="#" target="_blank">Gitee</a>
            </li>
          </ul>
        </div>
        <div class="footer-top-item">
          <div class="footer-top-item-title">{{ t('footer.support') }}</div>
          <ul>
            <li>
              <a href="#" target="_blank">{{ t('footer.support.about') }}</a>
            </li>
            <li>
              <a href="#" target="_blank">{{ t('footer.support.help') }}</a>
            </li>
          </ul>
        </div>
      </div>
      <div class="footer-bottom">
        <p>
          <span>copyright </span>
          <span>倪风 ©2022</span>
          <span>备案号：xxxxxxxxxxxxx</span>
          <span class="i18n-dropdown">
            <el-dropdown @command="changeWebLanguage" placement="top">
              <span class="el-dropdown-link">
                <i class="fa fa-globe" aria-hidden="true">
                  {{ currentLocale == 'zh-CN' ? '简体中文' : 'English' }}</i
                ><i class="el-icon-arrow-up el-icon--right"></i>
              </span>
              <template #dropdown>
                <el-dropdown-menu>
                  <el-dropdown-item command="zh-CN">简体中文</el-dropdown-item>
                  <el-dropdown-item command="en-US">English</el-dropdown-item>
                </el-dropdown-menu>
              </template>
            </el-dropdown>
          </span>
        </p>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import useI18n from '@/hooks/i18n-hook'

const {
  currentLocale,
  changeLocale,
  i18n: { t }
} = useI18n()

const changeWebLanguage = () => {
  changeLocale(currentLocale.value == 'zh-CN' ? 'en-US' : 'zh-CN')
}
</script>

<style scoped lang="less">
// 移动端自适应
// @media screen and (max-width: 768px) {
// }

.footer {
  background-color: #fff;
  .wrapper {
    max-width: 1250px;
    margin: 0 auto;
    padding: 20px 0;
    .footer-top {
      display: flex;
      justify-content: space-between;
      text-align: center;
      margin-bottom: 30px;

      .footer-top-item-title {
        font-size: 18px;
        font-weight: 700;
      }
      ul {
        margin-top: 20px;
        li {
          margin-bottom: 10px;
        }
      }
    }
    .footer-bottom {
      text-align: center;
      color: #999;
      font-size: 12px;
      .i18n-dropdown {
        margin-left: 10px;
        cursor: pointer;
      }
    }
  }
}
</style>
