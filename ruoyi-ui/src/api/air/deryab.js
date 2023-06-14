import request from '@/utils/request'

// 查询学籍调动结果列表
export function listDeryab(query) {
  return request({
    url: '/air/deryab/list',
    method: 'get',
    params: query
  })
}

// 查询学籍调动结果详细
export function getDeryab(id) {
  return request({
    url: '/air/deryab/' + id,
    method: 'get'
  })
}

// 新增学籍调动结果
export function addDeryab(data) {
  return request({
    url: '/air/deryab',
    method: 'post',
    data: data
  })
}

// 修改学籍调动结果
export function updateDeryab(data) {
  return request({
    url: '/air/deryab',
    method: 'put',
    data: data
  })
}

// 删除学籍调动结果
export function delDeryab(id) {
  return request({
    url: '/air/deryab/' + id,
    method: 'delete'
  })
}
