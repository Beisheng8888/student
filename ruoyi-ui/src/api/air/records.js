import request from '@/utils/request'

// 查询档案查询列表
export function listRecords(query) {
  return request({
    url: '/air/records/list',
    method: 'get',
    params: query
  })
}

// 查询档案查询详细
export function getRecords(studentId) {
  return request({
    url: '/air/records/' + studentId,
    method: 'get'
  })
}

// 新增档案查询
export function addRecords(data) {
  return request({
    url: '/air/records',
    method: 'post',
    data: data
  })
}

// 修改档案查询
export function updateRecords(data) {
  return request({
    url: '/air/records',
    method: 'put',
    data: data
  })
}

// 删除档案查询
export function delRecords(studentId) {
  return request({
    url: '/air/records/' + studentId,
    method: 'delete'
  })
}
