import request from '@/utils/request'

export function userList(data) {
  return request({
    url: '/api/user/list',
    method: 'post',
    data
  })
}
