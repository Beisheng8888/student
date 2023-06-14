import request from '@/utils/request'

// 查询课程考勤列表
export function listAttendancefa(query) {
  return request({
    url: '/air/attendancefa/list',
    method: 'get',
    params: query
  })
}

// 查询课程考勤详细
export function getAttendancefa(id) {
  return request({
    url: '/air/attendancefa/' + id,
    method: 'get'
  })
}

// 新增课程考勤
export function addAttendancefa(data) {
  return request({
    url: '/air/attendancefa',
    method: 'post',
    data: data
  })
}

// 修改课程考勤
export function updateAttendancefa(data) {
  return request({
    url: '/air/attendancefa',
    method: 'put',
    data: data
  })
}

// 删除课程考勤
export function delAttendancefa(id) {
  return request({
    url: '/air/attendancefa/' + id,
    method: 'delete'
  })
}
