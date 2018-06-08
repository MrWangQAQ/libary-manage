import {server} from '@/tools/servers'

export class BorrowBookApi {
  static borrowBook (data) {
    return server.connection('POST', '/borrowManage/borrowBook', data)
  }
  static backBook (data) {
    return server.connection('POST', '/borrowManage/backBook', data)
  }


  static getAllList (data) {
    return server.connection('GET', '/borrowManage/getAllList', data)
  }

  static getBook (data) {
    return server.connection('GET', '/borrowManage/getBook', data)
  }
  static judgeUser (data) {
    return server.connection('GET', '/borrowManage/judgeUser', data)
  }

  static changePassword (data) {
    return server.connection('POST', '/borrowManage/changePassword', data)
  }

  static getDataById (id) {
    return server.connection('GET', '/borrowManage/getDataById', {id})
  }

  static editData (data) {
    return server.connection('POST', '/borrowManage/editData', data)
  }
}
