import request from '@/utils/request'

// 查询学籍情况列表
export function listEnrollmentae(query) {
  return request({
    url: '/air/enrollmentae/list',
    method: 'get',
    params: query
  })
}

// 查询学籍情况详细
export function getEnrollmentae(studentID) {
  return request({
    url: '/air/enrollmentae/' + studentID,
    method: 'get'
  })
}

// 新增学籍情况
export function addEnrollmentae(data) {
  return request({
    url: '/air/enrollmentae',
    method: 'post',
    data: data
  })
}

// 修改学籍情况
export function updateEnrollmentae(data) {
  return request({
    url: '/air/enrollmentae',
    method: 'put',
    data: data
  })
}

// 删除学籍情况
export function delEnrollmentae(studentID) {
  return request({
    url: '/air/enrollmentae/' + studentID,
    method: 'delete'
  })
}
