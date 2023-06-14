import request from '@/utils/request'

// 查询宿舍信息列表
export function listInformationgc(query) {
  return request({
    url: '/air/informationgc/list',
    method: 'get',
    params: query
  })
}

// 查询宿舍信息详细
export function getInformationgc(dormitoryId) {
  return request({
    url: '/air/informationgc/' + dormitoryId,
    method: 'get'
  })
}

// 新增宿舍信息
export function addInformationgc(data) {
  return request({
    url: '/air/informationgc',
    method: 'post',
    data: data
  })
}

// 修改宿舍信息
export function updateInformationgc(data) {
  return request({
    url: '/air/informationgc',
    method: 'put',
    data: data
  })
}

// 删除宿舍信息
export function delInformationgc(dormitoryId) {
  return request({
    url: '/air/informationgc/' + dormitoryId,
    method: 'delete'
  })
}
