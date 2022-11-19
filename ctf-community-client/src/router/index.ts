import { createRouter, createWebHistory } from 'vue-router'

import AdminRouter from './modules/admin'

import IndexRouter from './modules'

import store from '@/stores'

import useCommonAccountStore from '@/stores/modules/common/account'

const commonAccount = useCommonAccountStore(store)

const router = createRouter({
  history: createWebHistory(),
  routes: [...AdminRouter, ...IndexRouter]
})

// 路由判断登录 根据路由配置文件的参数(全局身份验证token)
router.beforeEach((to, from, next) => {
  const isAdmin = commonAccount.isAdmin
  const token = localStorage.getItem('token')

  if (to.meta.requireAuth) {
    // 需要登录权限
    if (token) {
      // 需要登录权限，且已登录
      // 判断是否需要管理员权限
      if (to.meta.requireAdmin) {
        console.log(1111)

        // 非管理员，直接跳转到首页
        if (!isAdmin) {
          next({
            path: '/'
          })
        }
      }
      // 否则，直接跳转到对应的路由
      next()
    } else {
      // 需要登录权限，但是没有登录

      // 未登录，如果当前访问的是管理员页面，直接跳转到管理员登录界面，否则直接跳转到首页
      if (to.path.split('/')[1] === 'admin') {
        next({
          path: '/admin/login'
        })
      } else {
        next({
          path: '/'
        })
      }
    }
  } else {
    // 不需要登录权限的
    // 如果页面为管理员登录页面，且具有管理员身份，直接跳转到后台首页
    if (to.path.startsWith('/admin/login') && token && isAdmin) {
      // 已登录，且是管理员，访问的是登录页面，直接跳转到后台首页
      next({
        path: '/admin'
      })
    }

    next()
  }
})

export default router
