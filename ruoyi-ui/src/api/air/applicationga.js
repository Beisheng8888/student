import request from '@/utils/request'

// 查询假期留校申请列表
export function listApplicationga(query) {
  return request({
    url: '/air/applicationga/list',
    method: 'get',
    params: query
  })
}

// 查询假期留校申请详细
export function getApplicationga(applicationId) {
  return request({
    url: '/air/applicationga/' + applicationId,
    method: 'get'
  })
}

// 新增假期留校申请
export function addApplicationga(data) {
  return request({
    url: '/air/applicationga',
    method: 'post',
    data: data
  })
}

// 修改假期留校申请
export function updateApplicationga(data) {
  return request({
    url: '/air/applicationga',
    method: 'put',
    data: data
  })
}

// 删除假期留校申请
export function delApplicationga(applicationId) {
  return request({
    url: '/air/applicationga/' + applicationId,
    method: 'delete'
  })
}
