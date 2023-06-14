import request from '@/utils/request'

// 查询资助申请结果列表
export function listIohjked(query) {
  return request({
    url: '/air/iohjked/list',
    method: 'get',
    params: query
  })
}

// 查询资助申请结果详细
export function getIohjked(id) {
  return request({
    url: '/air/iohjked/' + id,
    method: 'get'
  })
}

// 新增资助申请结果
export function addIohjked(data) {
  return request({
    url: '/air/iohjked',
    method: 'post',
    data: data
  })
}

// 修改资助申请结果
export function updateIohjked(data) {
  return request({
    url: '/air/iohjked',
    method: 'put',
    data: data
  })
}

// 删除资助申请结果
export function delIohjked(id) {
  return request({
    url: '/air/iohjked/' + id,
    method: 'delete'
  })
}
