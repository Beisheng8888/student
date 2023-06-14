import request from '@/utils/request'

// 查询行政报到列表
export function listRegisbb(query) {
  return request({
    url: '/air/regisbb/list',
    method: 'get',
    params: query
  })
}

// 查询行政报到详细
export function getRegisbb(id) {
  return request({
    url: '/air/regisbb/' + id,
    method: 'get'
  })
}

// 新增行政报到
export function addRegisbb(data) {
  return request({
    url: '/air/regisbb',
    method: 'post',
    data: data
  })
}

// 修改行政报到
export function updateRegisbb(data) {
  return request({
    url: '/air/regisbb',
    method: 'put',
    data: data
  })
}

// 删除行政报到
export function delRegisbb(id) {
  return request({
    url: '/air/regisbb/' + id,
    method: 'delete'
  })
}
