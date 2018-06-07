import {server} from '@/tools/servers'

export class UserUIApi {

  static selectUserInfoById (id) {
    return server.connection('GET', '/userManage/selectUserInfoById', {id})
  }
}
