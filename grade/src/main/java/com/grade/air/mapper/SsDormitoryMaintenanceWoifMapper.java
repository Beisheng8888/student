package com.grade.air.mapper;

import java.util.List;
import com.grade.air.domain.SsDormitoryMaintenanceWoif;

/**
 * 宿舍报修反馈Mapper接口
 * 
 * @author l
 * @date 2023-06-04
 */
public interface SsDormitoryMaintenanceWoifMapper 
{
    /**
     * 查询宿舍报修反馈
     * 
     * @param id 宿舍报修反馈主键
     * @return 宿舍报修反馈
     */
    public SsDormitoryMaintenanceWoif selectSsDormitoryMaintenanceWoifById(Long id);

    /**
     * 查询宿舍报修反馈列表
     * 
     * @param ssDormitoryMaintenanceWoif 宿舍报修反馈
     * @return 宿舍报修反馈集合
     */
    public List<SsDormitoryMaintenanceWoif> selectSsDormitoryMaintenanceWoifList(SsDormitoryMaintenanceWoif ssDormitoryMaintenanceWoif);

    /**
     * 新增宿舍报修反馈
     * 
     * @param ssDormitoryMaintenanceWoif 宿舍报修反馈
     * @return 结果
     */
    public int insertSsDormitoryMaintenanceWoif(SsDormitoryMaintenanceWoif ssDormitoryMaintenanceWoif);

    /**
     * 修改宿舍报修反馈
     * 
     * @param ssDormitoryMaintenanceWoif 宿舍报修反馈
     * @return 结果
     */
    public int updateSsDormitoryMaintenanceWoif(SsDormitoryMaintenanceWoif ssDormitoryMaintenanceWoif);

    /**
     * 删除宿舍报修反馈
     * 
     * @param id 宿舍报修反馈主键
     * @return 结果
     */
    public int deleteSsDormitoryMaintenanceWoifById(Long id);

    /**
     * 批量删除宿舍报修反馈
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSsDormitoryMaintenanceWoifByIds(Long[] ids);
}
