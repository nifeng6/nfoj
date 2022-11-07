import {
  createRouter,
  createWebHistory,
  createWebHashHistory
} from 'vue-router'
import type { RouteRecordRaw } from 'vue-router'

const AdminRouter: Array<RouteRecordRaw> = []

const IndexRouter: Array<RouteRecordRaw> = [
  {
    path: '/',
    component: () => import('@/layouts/default/index.vue'),
    redirect: '/home',
    children: [
      {
        path: 'home',
        name: 'home',
        meta: {
          title: '首页'
        },
        component: () => import('@/views/index/home/index.vue')
      },
      {
        path: 'ctf',
        name: 'ctf',
        meta: {
          title: '安全靶场'
        },
        component: () => import('@/views/index/ctf/index.vue')
      },
      {
        path: 'tools',
        name: 'tools',
        meta: {
          title: '在线工具'
        },
        component: () => import('@/views/index/tools/index.vue')
      },
      {
        path: 'coder',
        name: 'coder',
        meta: {
          title: '在线编程'
        },
        component: () => import('@/views/index/coder/index.vue')
      },
      {
        path: 'user/:user_id',
        name: 'user',
        meta: {
          title: '用户中心'
        },
        component: () => import('@/views/index/user/index.vue')
      },
      {
        path: 'account',
        name: 'account',
        meta: {
          title: '账户中心'
        },
        component: () => import('@/views/index/account/index.vue'),
        children: [
          {
            path: 'base',
            name: 'account-base',
            component: () => import('@/views/index/account/base/index.vue')
          },
          {
            path: 'security',
            name: 'account-security',
            component: () => import('@/views/index/account/security/index.vue')
          },
          {
            path: 'coin',
            name: 'account-coin',
            component: () => import('@/views/index/account/coin/index.vue')
          }
        ]
      },
      {
        path: 'bbs',
        name: 'bbs',
        meta: {
          title: '用户社区'
        },
        component: () => import('@/views/index/bbs/index.vue')
      },
      {
        path: 'article/:article_id',
        name: 'article',
        meta: {
          title: '文章详情'
        },
        component: () => import('@/views/index/article/index.vue')
      }
    ]
  }
]

const router = createRouter({
  history: createWebHashHistory(),
  routes: [...AdminRouter, ...IndexRouter]
})

export default router
