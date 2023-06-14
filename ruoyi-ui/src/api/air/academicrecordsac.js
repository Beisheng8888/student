import request from '@/utils/request'

// 查询R学习情况列表
export function listAcademicrecordsac(query) {
  return request({
    url: '/air/academicrecordsac/list',
    method: 'get',
    params: query
  })
}

// 查询学习情况详细
export function getAcademicrecordsac(studentID) {
  return request({
    url: '/air/academicrecordsac/' + studentID,
    method: 'get'
  })
}

// 新增学习情况
export function addAcademicrecordsac(data) {
  return request({
    url: '/air/academicrecordsac',
    method: 'post',
    data: data
  })
}

// 修改学习情况
export function updateAcademicrecordsac(data) {
  return request({
    url: '/air/academicrecordsac',
    method: 'put',
    data: data
  })
}

// 删除学习情况
export function delAcademicrecordsac(studentID) {
  return request({
    url: '/air/academicrecordsac/' + studentID,
    method: 'delete'
  })
}
