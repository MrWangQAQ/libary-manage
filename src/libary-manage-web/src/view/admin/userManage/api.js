import {server} from '@/tools/servers'

export class UserManageApi {
  static getList (data) {
    return server.connection('GET', '/userManage/getList', data)
  }

  static add (data) {
    return server.connection('POST', '/userManage/addUser', data)
  }

  static selectUserInfoById (id) {
    return server.connection('GET', '/userManage/selectUserInfoById', {id})
  }

  static deleteUser (data) {
    return server.connection('POST', '/userManage/deleteUser', data)
  }

  static editUser (data) {
    return server.connection('POST', '/userManage/editUser', data)
  }

  static resetPassword (userId) {
    return server.connection('GET', '/userManage/resetPassword', {userId})
  }
}
