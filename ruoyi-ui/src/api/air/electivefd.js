import request from '@/utils/request'

// 查询学员成绩列表
export function listElectivefd(query) {
  return request({
    url: '/air/electivefd/list',
    method: 'get',
    params: query
  })
}

// 查询学员成绩详细
export function getElectivefd(id) {
  return request({
    url: '/air/electivefd/' + id,
    method: 'get'
  })
}

// 新增学员成绩
export function addElectivefd(data) {
  return request({
    url: '/air/electivefd',
    method: 'post',
    data: data
  })
}

// 修改学员成绩
export function updateElectivefd(data) {
  return request({
    url: '/air/electivefd',
    method: 'put',
    data: data
  })
}

// 删除学员成绩
export function delElectivefd(id) {
  return request({
    url: '/air/electivefd/' + id,
    method: 'delete'
  })
}
