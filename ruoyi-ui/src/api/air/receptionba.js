import request from '@/utils/request'

// 查询现场接待数据列表
export function listReceptionba(query) {
  return request({
    url: '/air/receptionba/list',
    method: 'get',
    params: query
  })
}

// 查询现场接待数据详细
export function getReceptionba(recordId) {
  return request({
    url: '/air/receptionba/' + recordId,
    method: 'get'
  })
}

// 新增现场接待数据
export function addReceptionba(data) {
  return request({
    url: '/air/receptionba',
    method: 'post',
    data: data
  })
}

// 修改现场接待数据
export function updateReceptionba(data) {
  return request({
    url: '/air/receptionba',
    method: 'put',
    data: data
  })
}

// 删除现场接待数据
export function delReceptionba(recordId) {
  return request({
    url: '/air/receptionba/' + recordId,
    method: 'delete'
  })
}
