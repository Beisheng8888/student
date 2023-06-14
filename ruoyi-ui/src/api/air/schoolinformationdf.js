import request from '@/utils/request'

// 查询学校信息列表
export function listSchoolinformationdf(query) {
  return request({
    url: '/air/schoolinformationdf/list',
    method: 'get',
    params: query
  })
}

// 查询学校信息详细
export function getSchoolinformationdf(informationID) {
  return request({
    url: '/air/schoolinformationdf/' + informationID,
    method: 'get'
  })
}

// 新增学校信息
export function addSchoolinformationdf(data) {
  return request({
    url: '/air/schoolinformationdf',
    method: 'post',
    data: data
  })
}

// 修改学校信息
export function updateSchoolinformationdf(data) {
  return request({
    url: '/air/schoolinformationdf',
    method: 'put',
    data: data
  })
}

// 删除学校信息
export function delSchoolinformationdf(informationID) {
  return request({
    url: '/air/schoolinformationdf/' + informationID,
    method: 'delete'
  })
}
