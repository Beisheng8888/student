import request from '@/utils/request'

// 查询预报到登记列表
export function listOpghbe(query) {
  return request({
    url: '/air/opghbe/list',
    method: 'get',
    params: query
  })
}

// 查询预报到登记详细
export function getOpghbe(id) {
  return request({
    url: '/air/opghbe/' + id,
    method: 'get'
  })
}

// 新增预报到登记
export function addOpghbe(data) {
  return request({
    url: '/air/opghbe',
    method: 'post',
    data: data
  })
}

// 修改预报到登记
export function updateOpghbe(data) {
  return request({
    url: '/air/opghbe',
    method: 'put',
    data: data
  })
}

// 删除预报到登记
export function delOpghbe(id) {
  return request({
    url: '/air/opghbe/' + id,
    method: 'delete'
  })
}
