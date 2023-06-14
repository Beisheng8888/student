import request from '@/utils/request'

// 查询接送与寄存列表
export function listTransportationstoragebg(query) {
  return request({
    url: '/air/transportationstoragebg/list',
    method: 'get',
    params: query
  })
}

// 查询接送与寄存详细
export function getTransportationstoragebg(transportationStorageID) {
  return request({
    url: '/air/transportationstoragebg/' + transportationStorageID,
    method: 'get'
  })
}

// 新增接送与寄存
export function addTransportationstoragebg(data) {
  return request({
    url: '/air/transportationstoragebg',
    method: 'post',
    data: data
  })
}

// 修改接送与寄存
export function updateTransportationstoragebg(data) {
  return request({
    url: '/air/transportationstoragebg',
    method: 'put',
    data: data
  })
}

// 删除接送与寄存
export function delTransportationstoragebg(transportationStorageID) {
  return request({
    url: '/air/transportationstoragebg/' + transportationStorageID,
    method: 'delete'
  })
}
