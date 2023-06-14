import request from '@/utils/request'

// 查询资助申请列表
export function listScholarshipapplicationsec(query) {
  return request({
    url: '/air/scholarshipapplicationsec/list',
    method: 'get',
    params: query
  })
}

// 查询资助申请详细
export function getScholarshipapplicationsec(applicationID) {
  return request({
    url: '/air/scholarshipapplicationsec/' + applicationID,
    method: 'get'
  })
}

// 新增资助申请
export function addScholarshipapplicationsec(data) {
  return request({
    url: '/air/scholarshipapplicationsec',
    method: 'post',
    data: data
  })
}

// 修改资助申请
export function updateScholarshipapplicationsec(data) {
  return request({
    url: '/air/scholarshipapplicationsec',
    method: 'put',
    data: data
  })
}

// 删除资助申请
export function delScholarshipapplicationsec(applicationID) {
  return request({
    url: '/air/scholarshipapplicationsec/' + applicationID,
    method: 'delete'
  })
}
