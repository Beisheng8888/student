import request from '@/utils/request'

// 查询网络故障保修列表
export function listApplicationgh(query) {
  return request({
    url: '/air/applicationgh/list',
    method: 'get',
    params: query
  })
}

// 查询网络故障保修详细
export function getApplicationgh(applicationId) {
  return request({
    url: '/air/applicationgh/' + applicationId,
    method: 'get'
  })
}

// 新增网络故障保修
export function addApplicationgh(data) {
  return request({
    url: '/air/applicationgh',
    method: 'post',
    data: data
  })
}

// 修改网络故障保修
export function updateApplicationgh(data) {
  return request({
    url: '/air/applicationgh',
    method: 'put',
    data: data
  })
}

// 删除网络故障保修
export function delApplicationgh(applicationId) {
  return request({
    url: '/air/applicationgh/' + applicationId,
    method: 'delete'
  })
}
