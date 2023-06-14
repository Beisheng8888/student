import request from '@/utils/request'

// 查询卫生检查通知列表
export function listNoticegl(query) {
  return request({
    url: '/air/noticegl/list',
    method: 'get',
    params: query
  })
}

// 查询卫生检查通知详细
export function getNoticegl(inspectionId) {
  return request({
    url: '/air/noticegl/' + inspectionId,
    method: 'get'
  })
}

// 新增卫生检查通知
export function addNoticegl(data) {
  return request({
    url: '/air/noticegl',
    method: 'post',
    data: data
  })
}

// 修改卫生检查通知
export function updateNoticegl(data) {
  return request({
    url: '/air/noticegl',
    method: 'put',
    data: data
  })
}

// 删除卫生检查通知
export function delNoticegl(inspectionId) {
  return request({
    url: '/air/noticegl/' + inspectionId,
    method: 'delete'
  })
}
