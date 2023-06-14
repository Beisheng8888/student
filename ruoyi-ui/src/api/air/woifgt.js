import request from '@/utils/request'

// 查询宿舍报修反馈列表
export function listWoifgt(query) {
  return request({
    url: '/air/woifgt/list',
    method: 'get',
    params: query
  })
}

// 查询宿舍报修反馈详细
export function getWoifgt(id) {
  return request({
    url: '/air/woifgt/' + id,
    method: 'get'
  })
}

// 新增宿舍报修反馈
export function addWoifgt(data) {
  return request({
    url: '/air/woifgt',
    method: 'post',
    data: data
  })
}

// 修改宿舍报修反馈
export function updateWoifgt(data) {
  return request({
    url: '/air/woifgt',
    method: 'put',
    data: data
  })
}

// 删除宿舍报修反馈
export function delWoifgt(id) {
  return request({
    url: '/air/woifgt/' + id,
    method: 'delete'
  })
}
