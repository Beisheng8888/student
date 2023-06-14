import request from '@/utils/request'

// 查询假期留校申请反馈列表
export function listTypegb(query) {
  return request({
    url: '/air/typegb/list',
    method: 'get',
    params: query
  })
}

// 查询假期留校申请反馈详细
export function getTypegb(id) {
  return request({
    url: '/air/typegb/' + id,
    method: 'get'
  })
}

// 新增假期留校申请反馈
export function addTypegb(data) {
  return request({
    url: '/air/typegb',
    method: 'post',
    data: data
  })
}

// 修改假期留校申请反馈
export function updateTypegb(data) {
  return request({
    url: '/air/typegb',
    method: 'put',
    data: data
  })
}

// 删除假期留校申请反馈
export function delTypegb(id) {
  return request({
    url: '/air/typegb/' + id,
    method: 'delete'
  })
}
