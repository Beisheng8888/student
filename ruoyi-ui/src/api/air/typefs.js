import request from '@/utils/request'

// 查询课程信息列表
export function listTypefs(query) {
  return request({
    url: '/air/typefs/list',
    method: 'get',
    params: query
  })
}

// 查询课程信息详细
export function getTypefs(id) {
  return request({
    url: '/air/typefs/' + id,
    method: 'get'
  })
}

// 新增课程信息
export function addTypefs(data) {
  return request({
    url: '/air/typefs',
    method: 'post',
    data: data
  })
}

// 修改课程信息
export function updateTypefs(data) {
  return request({
    url: '/air/typefs',
    method: 'put',
    data: data
  })
}

// 删除课程信息
export function delTypefs(id) {
  return request({
    url: '/air/typefs/' + id,
    method: 'delete'
  })
}
