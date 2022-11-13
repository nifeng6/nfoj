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
          <div class="footer-top-item-title">服务</div>
          <ul>
            <li>
              <a href="#" target="_blank">系统信息</a>
            </li>
            <li>
              <a href="#" target="_blank">用户投稿</a>
            </li>
          </ul>
        </div>
        <div class="footer-top-item">
          <div class="footer-top-item-title">开发</div>
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
          <div class="footer-top-item-title">支持</div>
          <ul>
            <li>
              <a href="#" target="_blank">关于</a>
            </li>
            <li>
              <a href="#" target="_blank">帮助</a>
            </li>
          </ul>
        </div>
      </div>
      <div class="footer-bottom">
        <p>
          <span>copyright </span>
          <span>倪风 ©2022</span>
          <span>备案号：xxxxxxxxxxxxx</span>
        </p>
      </div>
    </div>
  </div>
</template>

<style scoped lang="less">
.footer {
  background-color: #fff;
  .wrapper {
    width: 1250px;
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
        margin-top: 10px;
        li {
          margin-bottom: 10px;
        }
      }
    }
    .footer-bottom {
      text-align: center;
      color: #999;
      font-size: 12px;
    }
  }
}
</style>
