import request from '@/utils/request'

// 查询离校申请列表
export function listDepartureapplicationspa(query) {
  return request({
    url: '/air/departureapplicationspa/list',
    method: 'get',
    params: query
  })
}

// 查询离校申请详细
export function getDepartureapplicationspa(applicationID) {
  return request({
    url: '/air/departureapplicationspa/' + applicationID,
    method: 'get'
  })
}

// 新增离校申请
export function addDepartureapplicationspa(data) {
  return request({
    url: '/air/departureapplicationspa',
    method: 'post',
    data: data
  })
}

// 修改离校申请
export function updateDepartureapplicationspa(data) {
  return request({
    url: '/air/departureapplicationspa',
    method: 'put',
    data: data
  })
}

// 删除离校申请
export function delDepartureapplicationspa(applicationID) {
  return request({
    url: '/air/departureapplicationspa/' + applicationID,
    method: 'delete'
  })
}
