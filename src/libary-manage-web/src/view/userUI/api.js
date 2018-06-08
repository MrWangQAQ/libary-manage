import {server} from '@/tools/servers'

export class UserUIApi {

  static selectUserInfoById (id) {
    return server.connection('GET', '/userManage/selectUserInfoById', {id})
  }

  static changeInformation (data) {
    return server.connection('POST', '/userManage/changeInformation', data)
  }

  static changePassword (data) {
    return server.connection('POST', '/userManage/changePassword', data)
  }

  static getList (data) {
    return server.connection('GET', '/borrowManage/getList', data)
  }

  static getBookByNumber (data) {
    return server.connection('GET', '/borrowManage/getBookByNumber', data)
  }

  static getBookList (data) {
    return server.connection('GET', '/bookInfo/getListByBookName', data)
  }
}
