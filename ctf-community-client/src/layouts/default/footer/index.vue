<template>
  <div class="footer">
    <div class="footer-top">
      <div class="footer-text">
        <a href="#">了解CodeTip</a>
        <a href="#">加入CodeTip</a>
        <a href="#">帮助文档</a>
        <a href="#">用户协议</a>
        <a href="#">合作申请</a>
      </div>
    </div>
    <div class="wrapper">
      <p style="lineheight: normal; paddingtop: 20px; paddingbottom: 5px">
        <span>copyright </span>
        <span>倪风 ©2022</span>
      </p>
      <p style="lineheight: normal; paddingbottom: 5px">
        备案号：xxxxxxxxxxxxx
      </p>
      <p></p>
    </div>
  </div>
</template>

<style scoped lang="less">
.footer {
  margin: auto;
  background: #2c2f34;
  text-align: center;
  color: white;
  bottom: 0;
  padding: 15px;
}

.footer-text {
  margin: 26px auto;
}

.footer-top {
  border-bottom: 1px solid #4d515a;
}

.footer-text > a {
  color: #fff;
  margin-right: 36px;
}
.wrapper p {
  margin: 10px 0;
}
</style>
