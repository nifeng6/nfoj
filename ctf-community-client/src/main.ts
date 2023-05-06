import { createApp } from 'vue'
import { createPinia } from 'pinia'
import directive from './directive'
import vueDompurify from 'vue-dompurify-html'
import i18n from './i18n'
import App from './App.vue'
import router from './router'
import 'normalize.css'

import '@/assets/css/index.less'

const app = createApp(App)
app.use(directive)
app.use(createPinia())
app.use(router)
app.use(i18n)
app.use(vueDompurify)

app.mount('#app')
