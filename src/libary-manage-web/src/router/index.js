import Vue from 'vue'
import Router from 'vue-router'
import home from './home'
import userUI from './userUI'
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/login',
      name: 'login',
      component: () => import('../view/admin/login/login')
    },
    {
      path: '/admin',
      name: 'admin',
      component: () => import('../packages/ui/container'),
      children: [
        ...home
      ]
    },
    {
      path: '/bookManageUI',
      name: 'bookManageUI',
      component: () => import('../packages/ui/container'),
      children: [

      ]
    },
    {
      path: '/userUI',
      name: 'userUI',
      component: () => import('../packages/components/userUI/container'),
      children: [
        ...userUI
      ]
    }
  ]
})
