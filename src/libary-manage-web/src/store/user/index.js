/**
 * user
 */

import {LoginApi} from '../../view/admin/login/api';
import {Auth} from './auth';

const defaultUser = {type: '', user: '', password: '', remember: false};

export default {
  state: {
    /** 用户登陆角色信息 */
    userInfo: Auth.getUserInfo() || {},
    /** 是否登陆 */
    isLogin: Auth.getLogin() || false,
    /** 用户登陆账户密码 */
    accountPwd: Auth.getAccountPwd() || defaultUser,
    /** 角色权限点 */
    roles: [],
  },
  /** 计算属性 */
  getters: {
  },
  /** 更改 Vuex 的 store 中的状态的唯一方法是提交 mutation */
  mutations: {
    ACCOUNT_AUTH_STATUS_CHANGED(state, data) {
      const d = data.data.data;
      if (data.params.remember) {
        state.accountPwd = data.params;
        Auth.setAccountPwd(data.params)
      }
      console.log('当前登录角色信息： %o', d);
      state.userInfo = d;
      state.isLogin = true;
      Auth.setUserInfo(JSON.stringify(d));
      Auth.setLogin();
    },
    ACCOUNT_LOGOUT_FAILURE(state) {
      state.userInfo = {};
      state.accountPwd = {};
      state.roles = [];
      state.isLogin = false;
      Auth.removeAccountPwd();
      Auth.removeUserInfo();
      Auth.removeLogin();
    },
    ACCOUNT_LOGOUT_ROULES(state) {
      state.roles = Auth.getUserInfo()
    }
  },
  /** Action 提交的是 mutation，而不是直接变更状态。Action 可以包含任意异步操作。 */
  actions: {
    /** 登录 */
    accountLoginSubmit({commit}, params) {
      return new Promise((resolve, reject) => {
        LoginApi.Login(params).then((res) => {
          commit('ACCOUNT_AUTH_STATUS_CHANGED', {...res, params});
          resolve()
        }).catch(err => {
          reject(err);
          commit('ACCOUNT_LOGOUT_FAILURE');
        })
      })
    },
    /** 登出 */
    accountLogoutSubmit({commit}) {
      return new Promise((resolve, reject) => {
        commit('ACCOUNT_LOGOUT_FAILURE');
        resolve()
      })
    },
    /** 赋值角色权限 */
    accountSetRoules({commit}) {
      return new Promise(resolve => {
        commit('ACCOUNT_LOGOUT_ROULES');
        resolve()
      })
    }
  }
}
