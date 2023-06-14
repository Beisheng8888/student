import request from '@/utils/request'

// 查询宿舍报修列表
export function listMaintenancegd(query) {
  return request({
    url: '/air/maintenancegd/list',
    method: 'get',
    params: query
  })
}

// 查询宿舍报修详细
export function getMaintenancegd(maintenanceId) {
  return request({
    url: '/air/maintenancegd/' + maintenanceId,
    method: 'get'
  })
}

// 新增宿舍报修
export function addMaintenancegd(data) {
  return request({
    url: '/air/maintenancegd',
    method: 'post',
    data: data
  })
}

// 修改宿舍报修
export function updateMaintenancegd(data) {
  return request({
    url: '/air/maintenancegd',
    method: 'put',
    data: data
  })
}

// 删除宿舍报修
export function delMaintenancegd(maintenanceId) {
  return request({
    url: '/air/maintenancegd/' + maintenanceId,
    method: 'delete'
  })
}
