import request from '@/utils/request'

// 查询数据集成列表
export function listIntegrationfg(query) {
  return request({
    url: '/air/integrationfg/list',
    method: 'get',
    params: query
  })
}

// 查询数据集成详细
export function getIntegrationfg(id) {
  return request({
    url: '/air/integrationfg/' + id,
    method: 'get'
  })
}

// 新增数据集成
export function addIntegrationfg(data) {
  return request({
    url: '/air/integrationfg',
    method: 'post',
    data: data
  })
}

// 修改数据集成
export function updateIntegrationfg(data) {
  return request({
    url: '/air/integrationfg',
    method: 'put',
    data: data
  })
}

// 删除数据集成
export function delIntegrationfg(id) {
  return request({
    url: '/air/integrationfg/' + id,
    method: 'delete'
  })
}
