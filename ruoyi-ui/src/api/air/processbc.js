import request from '@/utils/request'

// 查询报到行政流程反馈列表
export function listProcessbc(query) {
  return request({
    url: '/air/processbc/list',
    method: 'get',
    params: query
  })
}

// 查询报到行政流程反馈详细
export function getProcessbc(recordId) {
  return request({
    url: '/air/processbc/' + recordId,
    method: 'get'
  })
}

// 新增报到行政流程反馈
export function addProcessbc(data) {
  return request({
    url: '/air/processbc',
    method: 'post',
    data: data
  })
}

// 修改报到行政流程反馈
export function updateProcessbc(data) {
  return request({
    url: '/air/processbc',
    method: 'put',
    data: data
  })
}

// 删除报到行政流程反馈
export function delProcessbc(recordId) {
  return request({
    url: '/air/processbc/' + recordId,
    method: 'delete'
  })
}
