const sessionStorage = window.sessionStorage;

export class Auth {
  static setUserInfo(value = {}) {
    return sessionStorage.setItem('user.userInfo', JSON.stringify(value))
  }

  static getUserInfo() {
    return JSON.parse(JSON.parse(sessionStorage.getItem('user.userInfo')))
  }

  static removeUserInfo() {
    return sessionStorage.removeItem('user.userInfo')
  }

  static setAccountPwd(value = {}) {
    return sessionStorage.setItem('user.accountPwd', JSON.stringify(value))
  }

  static getAccountPwd() {
    return JSON.parse(sessionStorage.getItem('user.accountPwd'))
  }

  static removeAccountPwd() {
    return sessionStorage.removeItem('user.accountPwd')
  }

  static setLogin() {
    return sessionStorage.setItem('user.isLogin', true)
  }

  static getLogin() {
    return !!sessionStorage.getItem('user.isLogin')
  }

  static removeLogin() {
    return sessionStorage.removeItem('user.isLogin')
  }
}
