import request from '@/utils/request'

// 查询离校注意事项公告列表
export function listDeparturenotices(query) {
  return request({
    url: '/air/departurenotices/list',
    method: 'get',
    params: query
  })
}

// 查询离校注意事项公告详细
export function getDeparturenotices(noticeID) {
  return request({
    url: '/air/departurenotices/' + noticeID,
    method: 'get'
  })
}

// 新增离校注意事项公告
export function addDeparturenotices(data) {
  return request({
    url: '/air/departurenotices',
    method: 'post',
    data: data
  })
}

// 修改离校注意事项公告
export function updateDeparturenotices(data) {
  return request({
    url: '/air/departurenotices',
    method: 'put',
    data: data
  })
}

// 删除离校注意事项公告
export function delDeparturenotices(noticeID) {
  return request({
    url: '/air/departurenotices/' + noticeID,
    method: 'delete'
  })
}
