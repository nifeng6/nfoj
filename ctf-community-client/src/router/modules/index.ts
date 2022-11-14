import type { RouteRecordRaw } from 'vue-router'
import Home from '@/views/index/home/index.vue'
import Ctf from '@/views/index/ctf/index.vue'
import Tools from '@/views/index/tools/index.vue'
import Coder from '@/views/index/coder/index.vue'

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
        component: Home
      },
      {
        path: 'ctf',
        name: 'ctf',
        meta: {
          title: '安全靶场'
        },
        component: () => Ctf
      },
      {
        path: 'tools',
        name: 'tools',
        meta: {
          title: '在线工具'
        },
        component: Tools
      },
      {
        path: 'coder',
        name: 'coder',
        meta: {
          title: '在线编程'
        },
        component: Coder
      },
      {
        path: 'reset-password',
        name: 'reset-password',
        meta: {
          title: '重置密码'
        },
        component: () => import('@/views/index/reset-password/index.vue')
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
        redirect: '/account/base',
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

export default IndexRouter
