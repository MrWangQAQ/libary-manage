import {server} from '@/tools/servers'

export class BookApi {
  static getList (data) {
    return server.connection('GET', '/bookInfo/getList', data)
  }
  static addBook (data) {
    return server.connection('POST', '/bookInfo/addBook', data)
  }
  static deleteBook (id) {
    return server.connection('POST', '/bookInfo/deleteBook', {id})
  }
  static editBook (data) {
    return server.connection('POST', '/bookInfo/editBook', data)
  }
  static selectBookById (id) {
    return server.connection('GET', '/bookInfo/selectBookById', {id})
  }
}
