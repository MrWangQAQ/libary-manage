import {server} from '@/tools/servers'

export class BookAdminManageApi {
  static getList (data) {
    return server.connection('GET', '/bookAdminManage/getList', data)
  }

  static editById (data) {
    return server.connection('POST', '/bookAdminManage/editById', data)
  }

  static addBookAdmin (data) {
    return server.connection('POST', '/bookAdminManage/addBookAdmin', data)
  }

  static deleteById (data) {
    return server.connection('POST', '/bookAdminManage/deleteById', data)
  }

  static changePassword (data) {
    return server.connection('POST', '/bookAdminManage/changePassword', data)
  }

  static selectById (id) {
    return server.connection('GET', '/bookAdminManage/selectById', {id})
  }
}
