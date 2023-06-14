import request from '@/utils/request'

// 查询预报到登记反馈列表
export function listRegistrationbd(query) {
  return request({
    url: '/air/registrationbd/list',
    method: 'get',
    params: query
  })
}

// 查询预报到登记反馈详细
export function getRegistrationbd(registrationID) {
  return request({
    url: '/air/registrationbd/' + registrationID,
    method: 'get'
  })
}

// 新增预报到登记反馈
export function addRegistrationbd(data) {
  return request({
    url: '/air/registrationbd',
    method: 'post',
    data: data
  })
}

// 修改预报到登记反馈
export function updateRegistrationbd(data) {
  return request({
    url: '/air/registrationbd',
    method: 'put',
    data: data
  })
}

// 删除预报到登记反馈
export function delRegistrationbd(registrationID) {
  return request({
    url: '/air/registrationbd/' + registrationID,
    method: 'delete'
  })
}
