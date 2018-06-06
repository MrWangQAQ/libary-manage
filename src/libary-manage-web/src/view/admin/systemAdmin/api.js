import {server} from '@/tools/servers'

export class SysAdminManageApi {
  static changePassword (data) {
    return server.connection('POST', '/bookAdminManage/changePassword', data)
  }

  static editData (data) {
    return server.connection('POST', '/bookAdminManage/editData', data)
  }

  static getDataById (id) {
    return server.connection('GET', '/bookAdminManage/getDataById', {id})
  }
}
