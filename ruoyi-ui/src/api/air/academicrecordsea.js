import request from '@/utils/request'

// 查询学籍成绩列表
export function listAcademicrecordsea(query) {
  return request({
    url: '/air/academicrecordsea/list',
    method: 'get',
    params: query
  })
}

// 查询学籍成绩详细
export function getAcademicrecordsea(recordID) {
  return request({
    url: '/air/academicrecordsea/' + recordID,
    method: 'get'
  })
}

// 新增学籍成绩
export function addAcademicrecordsea(data) {
  return request({
    url: '/air/academicrecordsea',
    method: 'post',
    data: data
  })
}

// 修改学籍成绩
export function updateAcademicrecordsea(data) {
  return request({
    url: '/air/academicrecordsea',
    method: 'put',
    data: data
  })
}

// 删除学籍成绩
export function delAcademicrecordsea(recordID) {
  return request({
    url: '/air/academicrecordsea/' + recordID,
    method: 'delete'
  })
}
