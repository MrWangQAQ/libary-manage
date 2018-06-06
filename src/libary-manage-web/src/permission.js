import router from './router'
import {store} from './store'
import {Msg} from './tools/message';
/** 路由控制 */
router.beforeEach((to, from, next) => {
  /** 判断用户是否已经登录 */
  if (store.getters.isLogin) {
    /** 已经登录情况下访问 /login, 则直接进入 /admin */
    if(to.path === 'login' || to.path === '/'){
      next('/admin');
    } else {
      next();
    }
  } else if(to.path === '/login') {
    next();
  }else {
    next('/login');
    Msg.error("未登录");
  }
});
