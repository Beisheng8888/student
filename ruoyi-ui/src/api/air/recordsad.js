import request from '@/utils/request'

// 查询个人违纪处分列表
export function listRecordsad(query) {
  return request({
    url: '/air/recordsad/list',
    method: 'get',
    params: query
  })
}

// 查询个人违纪处分详细
export function getRecordsad(recordId) {
  return request({
    url: '/air/recordsad/' + recordId,
    method: 'get'
  })
}

// 新增个人违纪处分
export function addRecordsad(data) {
  return request({
    url: '/air/recordsad',
    method: 'post',
    data: data
  })
}

// 修改个人违纪处分
export function updateRecordsad(data) {
  return request({
    url: '/air/recordsad',
    method: 'put',
    data: data
  })
}

// 删除个人违纪处分
export function delRecordsad(recordId) {
  return request({
    url: '/air/recordsad/' + recordId,
    method: 'delete'
  })
}
