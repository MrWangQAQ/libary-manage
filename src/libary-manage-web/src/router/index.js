import Vue from 'vue'
import Router from 'vue-router'
import home from './home'
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
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
    }
  ]
})
