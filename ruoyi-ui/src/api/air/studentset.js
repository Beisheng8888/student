import request from '@/utils/request'

// 查询学生证办理列表
export function listStudentset(query) {
  return request({
    url: '/air/studentset/list',
    method: 'get',
    params: query
  })
}

// 查询学生证办理详细
export function getStudentset(studentID) {
  return request({
    url: '/air/studentset/' + studentID,
    method: 'get'
  })
}

// 新增学生证办理
export function addStudentset(data) {
  return request({
    url: '/air/studentset',
    method: 'post',
    data: data
  })
}

// 修改学生证办理
export function updateStudentset(data) {
  return request({
    url: '/air/studentset',
    method: 'put',
    data: data
  })
}

// 删除学生证办理
export function delStudentset(studentID) {
  return request({
    url: '/air/studentset/' + studentID,
    method: 'delete'
  })
}
