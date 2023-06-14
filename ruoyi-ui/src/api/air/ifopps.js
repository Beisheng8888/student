import request from '@/utils/request'

// 查询离校审核结果列表
export function listIfopps(query) {
  return request({
    url: '/air/ifopps/list',
    method: 'get',
    params: query
  })
}

// 查询离校审核结果详细
export function getIfopps(id) {
  return request({
    url: '/air/ifopps/' + id,
    method: 'get'
  })
}

// 新增离校审核结果
export function addIfopps(data) {
  return request({
    url: '/air/ifopps',
    method: 'post',
    data: data
  })
}

// 修改离校审核结果
export function updateIfopps(data) {
  return request({
    url: '/air/ifopps',
    method: 'put',
    data: data
  })
}

// 删除离校审核结果
export function delIfopps(id) {
  return request({
    url: '/air/ifopps/' + id,
    method: 'delete'
  })
}
