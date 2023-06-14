import request from '@/utils/request'

// 查询奖惩通告列表
export function listAwardsandpenaltiesad(query) {
  return request({
    url: '/air/awardsandpenaltiesad/list',
    method: 'get',
    params: query
  })
}

// 查询奖惩通告详细
export function getAwardsandpenaltiesad(studentID) {
  return request({
    url: '/air/awardsandpenaltiesad/' + studentID,
    method: 'get'
  })
}

// 新增奖惩通告
export function addAwardsandpenaltiesad(data) {
  return request({
    url: '/air/awardsandpenaltiesad',
    method: 'post',
    data: data
  })
}

// 修改奖惩通告
export function updateAwardsandpenaltiesad(data) {
  return request({
    url: '/air/awardsandpenaltiesad',
    method: 'put',
    data: data
  })
}

// 删除奖惩通告
export function delAwardsandpenaltiesad(studentID) {
  return request({
    url: '/air/awardsandpenaltiesad/' + studentID,
    method: 'delete'
  })
}
