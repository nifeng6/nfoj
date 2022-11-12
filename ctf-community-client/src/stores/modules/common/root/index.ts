import { defineStore } from 'pinia'
import { useRoute } from 'vue-router'

const useRootStore = defineStore('common-root', {
  state: () => ({
    // ...
  }),
  actions: {
    changeDomTitle(title: string = '') {
      const route = useRoute()
      if (title) {
        document.title = title + ' - NFOJ'
      } else {
        document.title = route.meta.title + ' - NFOJ'
      }
    }
  }
})

export default useRootStore
