import { createRouter, createWebHistory } from 'vue-router'

import  AdminRouter  from './modules/admin'

import IndexRouter from './modules'

const router = createRouter({
  history: createWebHistory(),
  routes: [...AdminRouter, ...IndexRouter]
})

export default router
