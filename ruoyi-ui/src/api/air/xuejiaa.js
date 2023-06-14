import request from '@/utils/request'

// 查询学籍调动列表
export function listXuejiaa(query) {
  return request({
    url: '/air/xuejiaa/list',
    method: 'get',
    params: query
  })
}

// 查询学籍调动详细
export function getXuejiaa(id) {
  return request({
    url: '/air/xuejiaa/' + id,
    method: 'get'
  })
}

// 新增学籍调动
export function addXuejiaa(data) {
  return request({
    url: '/air/xuejiaa',
    method: 'post',
    data: data
  })
}

// 修改学籍调动
export function updateXuejiaa(data) {
  return request({
    url: '/air/xuejiaa',
    method: 'put',
    data: data
  })
}

// 删除学籍调动
export function delXuejiaa(id) {
  return request({
    url: '/air/xuejiaa/' + id,
    method: 'delete'
  })
}
