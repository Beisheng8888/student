import request from '@/utils/request'

// 查询学员奖惩列表
export function listRewardspunishmentseb(query) {
  return request({
    url: '/air/rewardspunishmentseb/list',
    method: 'get',
    params: query
  })
}

// 查询学员奖惩详细
export function getRewardspunishmentseb(recordID) {
  return request({
    url: '/air/rewardspunishmentseb/' + recordID,
    method: 'get'
  })
}

// 新增学员奖惩
export function addRewardspunishmentseb(data) {
  return request({
    url: '/air/rewardspunishmentseb',
    method: 'post',
    data: data
  })
}

// 修改学员奖惩
export function updateRewardspunishmentseb(data) {
  return request({
    url: '/air/rewardspunishmentseb',
    method: 'put',
    data: data
  })
}

// 删除学员奖惩
export function delRewardspunishmentseb(recordID) {
  return request({
    url: '/air/rewardspunishmentseb/' + recordID,
    method: 'delete'
  })
}
