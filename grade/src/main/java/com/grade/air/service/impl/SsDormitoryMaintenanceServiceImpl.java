package com.grade.air.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.grade.air.mapper.SsDormitoryMaintenanceMapper;
import com.grade.air.domain.SsDormitoryMaintenance;
import com.grade.air.service.ISsDormitoryMaintenanceService;

/**
 * 宿舍报修Service业务层处理
 * 
 * @author l
 * @date 2023-06-04
 */
@Service
public class SsDormitoryMaintenanceServiceImpl implements ISsDormitoryMaintenanceService 
{
    @Autowired
    private SsDormitoryMaintenanceMapper ssDormitoryMaintenanceMapper;

    /**
     * 查询宿舍报修
     * 
     * @param maintenanceId 宿舍报修主键
     * @return 宿舍报修
     */
    @Override
    public SsDormitoryMaintenance selectSsDormitoryMaintenanceByMaintenanceId(Long maintenanceId)
    {
        return ssDormitoryMaintenanceMapper.selectSsDormitoryMaintenanceByMaintenanceId(maintenanceId);
    }

    /**
     * 查询宿舍报修列表
     * 
     * @param ssDormitoryMaintenance 宿舍报修
     * @return 宿舍报修
     */
    @Override
    public List<SsDormitoryMaintenance> selectSsDormitoryMaintenanceList(SsDormitoryMaintenance ssDormitoryMaintenance)
    {
        return ssDormitoryMaintenanceMapper.selectSsDormitoryMaintenanceList(ssDormitoryMaintenance);
    }

    /**
     * 新增宿舍报修
     * 
     * @param ssDormitoryMaintenance 宿舍报修
     * @return 结果
     */
    @Override
    public int insertSsDormitoryMaintenance(SsDormitoryMaintenance ssDormitoryMaintenance)
    {
        return ssDormitoryMaintenanceMapper.insertSsDormitoryMaintenance(ssDormitoryMaintenance);
    }

    /**
     * 修改宿舍报修
     * 
     * @param ssDormitoryMaintenance 宿舍报修
     * @return 结果
     */
    @Override
    public int updateSsDormitoryMaintenance(SsDormitoryMaintenance ssDormitoryMaintenance)
    {
        return ssDormitoryMaintenanceMapper.updateSsDormitoryMaintenance(ssDormitoryMaintenance);
    }

    /**
     * 批量删除宿舍报修
     * 
     * @param maintenanceIds 需要删除的宿舍报修主键
     * @return 结果
     */
    @Override
    public int deleteSsDormitoryMaintenanceByMaintenanceIds(Long[] maintenanceIds)
    {
        return ssDormitoryMaintenanceMapper.deleteSsDormitoryMaintenanceByMaintenanceIds(maintenanceIds);
    }

    /**
     * 删除宿舍报修信息
     * 
     * @param maintenanceId 宿舍报修主键
     * @return 结果
     */
    @Override
    public int deleteSsDormitoryMaintenanceByMaintenanceId(Long maintenanceId)
    {
        return ssDormitoryMaintenanceMapper.deleteSsDormitoryMaintenanceByMaintenanceId(maintenanceId);
    }
}
