package com.grade.air.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.grade.air.mapper.SsDormitoryMaintenanceWoifMapper;
import com.grade.air.domain.SsDormitoryMaintenanceWoif;
import com.grade.air.service.ISsDormitoryMaintenanceWoifService;

/**
 * 宿舍报修反馈Service业务层处理
 * 
 * @author l
 * @date 2023-06-04
 */
@Service
public class SsDormitoryMaintenanceWoifServiceImpl implements ISsDormitoryMaintenanceWoifService 
{
    @Autowired
    private SsDormitoryMaintenanceWoifMapper ssDormitoryMaintenanceWoifMapper;

    /**
     * 查询宿舍报修反馈
     * 
     * @param id 宿舍报修反馈主键
     * @return 宿舍报修反馈
     */
    @Override
    public SsDormitoryMaintenanceWoif selectSsDormitoryMaintenanceWoifById(Long id)
    {
        return ssDormitoryMaintenanceWoifMapper.selectSsDormitoryMaintenanceWoifById(id);
    }

    /**
     * 查询宿舍报修反馈列表
     * 
     * @param ssDormitoryMaintenanceWoif 宿舍报修反馈
     * @return 宿舍报修反馈
     */
    @Override
    public List<SsDormitoryMaintenanceWoif> selectSsDormitoryMaintenanceWoifList(SsDormitoryMaintenanceWoif ssDormitoryMaintenanceWoif)
    {
        return ssDormitoryMaintenanceWoifMapper.selectSsDormitoryMaintenanceWoifList(ssDormitoryMaintenanceWoif);
    }

    /**
     * 新增宿舍报修反馈
     * 
     * @param ssDormitoryMaintenanceWoif 宿舍报修反馈
     * @return 结果
     */
    @Override
    public int insertSsDormitoryMaintenanceWoif(SsDormitoryMaintenanceWoif ssDormitoryMaintenanceWoif)
    {
        return ssDormitoryMaintenanceWoifMapper.insertSsDormitoryMaintenanceWoif(ssDormitoryMaintenanceWoif);
    }

    /**
     * 修改宿舍报修反馈
     * 
     * @param ssDormitoryMaintenanceWoif 宿舍报修反馈
     * @return 结果
     */
    @Override
    public int updateSsDormitoryMaintenanceWoif(SsDormitoryMaintenanceWoif ssDormitoryMaintenanceWoif)
    {
        return ssDormitoryMaintenanceWoifMapper.updateSsDormitoryMaintenanceWoif(ssDormitoryMaintenanceWoif);
    }

    /**
     * 批量删除宿舍报修反馈
     * 
     * @param ids 需要删除的宿舍报修反馈主键
     * @return 结果
     */
    @Override
    public int deleteSsDormitoryMaintenanceWoifByIds(Long[] ids)
    {
        return ssDormitoryMaintenanceWoifMapper.deleteSsDormitoryMaintenanceWoifByIds(ids);
    }

    /**
     * 删除宿舍报修反馈信息
     * 
     * @param id 宿舍报修反馈主键
     * @return 结果
     */
    @Override
    public int deleteSsDormitoryMaintenanceWoifById(Long id)
    {
        return ssDormitoryMaintenanceWoifMapper.deleteSsDormitoryMaintenanceWoifById(id);
    }
}
