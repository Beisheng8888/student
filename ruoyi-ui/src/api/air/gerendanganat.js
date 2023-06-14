import request from '@/utils/request'

// 查询学生档案维护列表
export function listGerendanganat(query) {
  return request({
    url: '/air/gerendanganat/list',
    method: 'get',
    params: query
  })
}

// 查询学生档案维护详细
export function getGerendanganat(id) {
  return request({
    url: '/air/gerendanganat/' + id,
    method: 'get'
  })
}

// 新增学生档案维护
export function addGerendanganat(data) {
  return request({
    url: '/air/gerendanganat',
    method: 'post',
    data: data
  })
}

// 修改学生档案维护
export function updateGerendanganat(data) {
  return request({
    url: '/air/gerendanganat',
    method: 'put',
    data: data
  })
}

// 删除学生档案维护
export function delGerendanganat(id) {
  return request({
    url: '/air/gerendanganat/' + id,
    method: 'delete'
  })
}
