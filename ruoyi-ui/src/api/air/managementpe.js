import request from '@/utils/request'

// 查询准毕业生管理数据列表
export function listManagementpe(query) {
  return request({
    url: '/air/managementpe/list',
    method: 'get',
    params: query
  })
}

// 查询准毕业生管理数据详细
export function getManagementpe(studentId) {
  return request({
    url: '/air/managementpe/' + studentId,
    method: 'get'
  })
}

// 新增准毕业生管理数据
export function addManagementpe(data) {
  return request({
    url: '/air/managementpe',
    method: 'post',
    data: data
  })
}

// 修改准毕业生管理数据
export function updateManagementpe(data) {
  return request({
    url: '/air/managementpe',
    method: 'put',
    data: data
  })
}

// 删除准毕业生管理数据
export function delManagementpe(studentId) {
  return request({
    url: '/air/managementpe/' + studentId,
    method: 'delete'
  })
}
