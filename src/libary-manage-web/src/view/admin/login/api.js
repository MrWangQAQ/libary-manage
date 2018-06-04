import {server} from '@/tools/servers'

export class LoginApi {
  static Login (data) {
    return server.connection('POST', '/login/judge', data)
  }
}
