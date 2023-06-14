import request from '@/utils/request'

// 查询学员健康列表
export function listStudenthealther(query) {
  return request({
    url: '/air/studenthealther/list',
    method: 'get',
    params: query
  })
}

// 查询学员健康详细
export function getStudenthealther(recordID) {
  return request({
    url: '/air/studenthealther/' + recordID,
    method: 'get'
  })
}

// 新增学员健康
export function addStudenthealther(data) {
  return request({
    url: '/air/studenthealther',
    method: 'post',
    data: data
  })
}

// 修改学员健康
export function updateStudenthealther(data) {
  return request({
    url: '/air/studenthealther',
    method: 'put',
    data: data
  })
}

// 删除学员健康
export function delStudenthealther(recordID) {
  return request({
    url: '/air/studenthealther/' + recordID,
    method: 'delete'
  })
}
