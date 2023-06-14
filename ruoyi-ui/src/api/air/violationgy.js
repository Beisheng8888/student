import request from '@/utils/request'

// 查询宿舍违纪列表
export function listViolationgy(query) {
  return request({
    url: '/air/violationgy/list',
    method: 'get',
    params: query
  })
}

// 查询宿舍违纪详细
export function getViolationgy(violationId) {
  return request({
    url: '/air/violationgy/' + violationId,
    method: 'get'
  })
}

// 新增宿舍违纪
export function addViolationgy(data) {
  return request({
    url: '/air/violationgy',
    method: 'post',
    data: data
  })
}

// 修改宿舍违纪
export function updateViolationgy(data) {
  return request({
    url: '/air/violationgy',
    method: 'put',
    data: data
  })
}

// 删除宿舍违纪
export function delViolationgy(violationId) {
  return request({
    url: '/air/violationgy/' + violationId,
    method: 'delete'
  })
}
