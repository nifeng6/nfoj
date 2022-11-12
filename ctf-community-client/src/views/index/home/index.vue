<template>
  <div class="home">
    <div>
      <img
        style="max-width: 75%; padding: 3rem; max-height: 18rem"
        src="~@/assets/image/home.jpg"
      />
    </div>
    <h3 style="font-size: 1.75rem; text-align: center">
      欢迎访问<br />
      NFOJ
    </h3>
  </div>
</template>

<script setup lang="ts">
import usecommonRootStore from '@/stores/modules/common/root'

const commonRootStore = usecommonRootStore()
commonRootStore.changeDomTitle()
</script>

<style scoped lang="less">
.home {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  margin: 30px 0;
}
</style>
