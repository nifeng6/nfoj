import type { RouteRecordRaw } from 'vue-router'

const AdminRouter: Array<RouteRecordRaw> = [
  {
    path: '/admin',
    component: () => import('@/layouts/admin/index.vue'),
    redirect: '/admin/dashboard',
    children: [
      {
        path: 'dashboard',
        name: 'admin-dashboard',
        meta: {
          title: '仪表盘'
        },
        component: () => import('@/views/admin/dashboard/index.vue')
      },
      {
        path: 'user',
        name: 'admin-user',
        meta: {
          title: '用户管理'
        },
        component: () => import('@/views/admin/user/index.vue')
      },
      {
        path: 'labs',
        name: 'admin-labs',
        meta: {
          title: '靶场管理'
        },
        component: () => import('@/views/admin/labs/index.vue')
      },
      {
        path: 'labs',
        name: 'admin-labs-docker',
        meta: {
          title: '容器规则'
        },
        component: () => import('@/views/admin/labs-docker/index.vue')
      },
      {
        path: 'tools',
        name: 'admin-tools',
        meta: {
          title: '工具管理'
        },
        component: () => import('@/views/admin/tools/index.vue')
      },

      {
        path: 'bbs-reply',
        name: 'admin-bbs-reply',
        meta: {
          title: '社区评论管理'
        },
        component: () => import('@/views/admin/bbs-reply/index.vue')
      },
      {
        path: 'bbs-article',
        name: 'admin-bbs-article',
        meta: {
          title: '社区文章管理'
        },
        component: () => import('@/views/admin/bbs-article/index.vue')
      }
    ]
  }
]

export default AdminRouter
