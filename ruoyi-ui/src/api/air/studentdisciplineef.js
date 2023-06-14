import request from '@/utils/request'

// 查询学员通报列表
export function listStudentdisciplineef(query) {
  return request({
    url: '/air/studentdisciplineef/list',
    method: 'get',
    params: query
  })
}

// 查询学员通报详细
export function getStudentdisciplineef(recordID) {
  return request({
    url: '/air/studentdisciplineef/' + recordID,
    method: 'get'
  })
}

// 新增学员通报
export function addStudentdisciplineef(data) {
  return request({
    url: '/air/studentdisciplineef',
    method: 'post',
    data: data
  })
}

// 修改学员通报
export function updateStudentdisciplineef(data) {
  return request({
    url: '/air/studentdisciplineef',
    method: 'put',
    data: data
  })
}

// 删除学员通报
export function delStudentdisciplineef(recordID) {
  return request({
    url: '/air/studentdisciplineef/' + recordID,
    method: 'delete'
  })
}
