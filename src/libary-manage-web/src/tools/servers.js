import axios from 'axios'
import qs from 'qs'

export class BaseApi {
  servers;

  /**
   * 初始化servers
   */
  constructor () {
    const headers = new Headers()
    this.servers = axios.create({
      baseURL: 'http://120.79.129.212:8080/Internet-bar',
      headers,
      timeout: 1,
      withCredentials: false
    })
    this.servers.defaults.timeout = 50000
    this.servers.interceptors.request.use(function (config) {
      return config
    }, function (error) {
      return Promise.reject(error || '网络繁忙，请稍候再试！')
    })
    this.servers.interceptors.response.use(function (response) {
      return response
    }, function (error) {
      return Promise.reject(error.response || '网络繁忙，请稍候再试！')
    })
  }
  connection (method = 'GET', url, body) {
    if (typeof body !== 'object') body = {}
    method = method.toLocaleLowerCase()
    if (method === 'get') {
      url = `${url}?${qs.stringify(body)}`
      body = {}
    } else {
      body = new URLSearchParams(body)
    }
    return Promise.resolve(this.servers[method](url, body))
  }
}

export const server = new BaseApi()
