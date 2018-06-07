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
}
