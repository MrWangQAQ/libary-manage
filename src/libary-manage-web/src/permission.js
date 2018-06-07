import router from './router'
import {store} from './store'
import {Msg} from './tools/message';
/** 路由控制 */
router.beforeEach((to, from, next) => {
  let loginI = '';
  for (let key in store.getters.userInfo) {
    loginI += key;     //获取key值
  }
  /** 判断用户是否已经登录 */
  if (store.getters.isLogin) {
    /** 已经登录情况下访问 /, 则直接进入 /admin */
    if(to.path === '/'){
      /** 判断为系统管理员*/
      if(loginI.search("adminName") != -1){
        next('/admin')
      }
      /** 判断为图书管理员*/
      if(loginI.search("adName") != -1){
        next('/bookManageUI')
      }
      /**判断是用户*/
      if(loginI.search("userName") != -1){
        next('/userUI')
      }
    } else {
      /** 判断为系统管理员*/
      if(loginI.search("adminName") != -1){
        if(to.fullPath.search('admin') != -1){
          next()
        }else {
          next('/admin')
        }
      }
      /** 判断为图书管理员*/
      if(loginI.search("adName") != -1){
        if(to.fullPath.search('bookManageUI') != -1){
          next()
        }else {
          next('/bookManageUI')
        }
      }
      /**判断是用户*/
      if(loginI.search("userName") != -1){
        if(to.fullPath.search('userUI') != -1){
          next()
        }else {
          next('/userUI')
        }
      }
    }
  } else if(to.path === '/login') {
    next();
  }else {
    next('/login');
    Msg.error("未登录");
  }
});
