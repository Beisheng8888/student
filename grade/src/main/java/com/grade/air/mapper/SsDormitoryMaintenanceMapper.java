package com.grade.air.mapper;

import java.util.List;
import com.grade.air.domain.SsDormitoryMaintenance;

/**
 * 宿舍报修Mapper接口
 * 
 * @author l
 * @date 2023-06-04
 */
public interface SsDormitoryMaintenanceMapper 
{
    /**
     * 查询宿舍报修
     * 
     * @param maintenanceId 宿舍报修主键
     * @return 宿舍报修
     */
    public SsDormitoryMaintenance selectSsDormitoryMaintenanceByMaintenanceId(Long maintenanceId);

    /**
     * 查询宿舍报修列表
     * 
     * @param ssDormitoryMaintenance 宿舍报修
     * @return 宿舍报修集合
     */
    public List<SsDormitoryMaintenance> selectSsDormitoryMaintenanceList(SsDormitoryMaintenance ssDormitoryMaintenance);

    /**
     * 新增宿舍报修
     * 
     * @param ssDormitoryMaintenance 宿舍报修
     * @return 结果
     */
    public int insertSsDormitoryMaintenance(SsDormitoryMaintenance ssDormitoryMaintenance);

    /**
     * 修改宿舍报修
     * 
     * @param ssDormitoryMaintenance 宿舍报修
     * @return 结果
     */
    public int updateSsDormitoryMaintenance(SsDormitoryMaintenance ssDormitoryMaintenance);

    /**
     * 删除宿舍报修
     * 
     * @param maintenanceId 宿舍报修主键
     * @return 结果
     */
    public int deleteSsDormitoryMaintenanceByMaintenanceId(Long maintenanceId);

    /**
     * 批量删除宿舍报修
     * 
     * @param maintenanceIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSsDormitoryMaintenanceByMaintenanceIds(Long[] maintenanceIds);
}
