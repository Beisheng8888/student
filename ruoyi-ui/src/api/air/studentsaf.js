import request from '@/utils/request'

// 查询学生信息列表
export function listStudentsaf(query) {
  return request({
    url: '/air/studentsaf/list',
    method: 'get',
    params: query
  })
}

// 查询学生信息详细
export function getStudentsaf(studentID) {
  return request({
    url: '/air/studentsaf/' + studentID,
    method: 'get'
  })
}

// 新增学生信息
export function addStudentsaf(data) {
  return request({
    url: '/air/studentsaf',
    method: 'post',
    data: data
  })
}

// 修改学生信息
export function updateStudentsaf(data) {
  return request({
    url: '/air/studentsaf',
    method: 'put',
    data: data
  })
}

// 删除学生信息
export function delStudentsaf(studentID) {
  return request({
    url: '/air/studentsaf/' + studentID,
    method: 'delete'
  })
}
