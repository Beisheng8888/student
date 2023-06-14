import request from '@/utils/request'

// 查询网络故障保修反馈列表
export function listDemogo(query) {
  return request({
    url: '/air/demogo/list',
    method: 'get',
    params: query
  })
}

// 查询网络故障保修反馈详细
export function getDemogo(id) {
  return request({
    url: '/air/demogo/' + id,
    method: 'get'
  })
}

// 新增网络故障保修反馈
export function addDemogo(data) {
  return request({
    url: '/air/demogo',
    method: 'post',
    data: data
  })
}

// 修改网络故障保修反馈
export function updateDemogo(data) {
  return request({
    url: '/air/demogo',
    method: 'put',
    data: data
  })
}

// 删除网络故障保修反馈
export function delDemogo(id) {
  return request({
    url: '/air/demogo/' + id,
    method: 'delete'
  })
}
