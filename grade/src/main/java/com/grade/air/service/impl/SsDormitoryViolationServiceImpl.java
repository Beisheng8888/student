package com.grade.air.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.grade.air.mapper.SsDormitoryViolationMapper;
import com.grade.air.domain.SsDormitoryViolation;
import com.grade.air.service.ISsDormitoryViolationService;

/**
 * 宿舍违纪Service业务层处理
 * 
 * @author l
 * @date 2023-06-04
 */
@Service
public class SsDormitoryViolationServiceImpl implements ISsDormitoryViolationService 
{
    @Autowired
    private SsDormitoryViolationMapper ssDormitoryViolationMapper;

    /**
     * 查询宿舍违纪
     * 
     * @param violationId 宿舍违纪主键
     * @return 宿舍违纪
     */
    @Override
    public SsDormitoryViolation selectSsDormitoryViolationByViolationId(Long violationId)
    {
        return ssDormitoryViolationMapper.selectSsDormitoryViolationByViolationId(violationId);
    }

    /**
     * 查询宿舍违纪列表
     * 
     * @param ssDormitoryViolation 宿舍违纪
     * @return 宿舍违纪
     */
    @Override
    @DataScope(userAlias = "recuit")
    public List<SsDormitoryViolation> selectSsDormitoryViolationList(SsDormitoryViolation ssDormitoryViolation)
    {
        return ssDormitoryViolationMapper.selectSsDormitoryViolationList(ssDormitoryViolation);
    }

    /**
     * 新增宿舍违纪
     * 
     * @param ssDormitoryViolation 宿舍违纪
     * @return 结果
     */
    @Override
    public int insertSsDormitoryViolation(SsDormitoryViolation ssDormitoryViolation)
    {
        return ssDormitoryViolationMapper.insertSsDormitoryViolation(ssDormitoryViolation);
    }

    /**
     * 修改宿舍违纪
     * 
     * @param ssDormitoryViolation 宿舍违纪
     * @return 结果
     */
    @Override
    public int updateSsDormitoryViolation(SsDormitoryViolation ssDormitoryViolation)
    {
        return ssDormitoryViolationMapper.updateSsDormitoryViolation(ssDormitoryViolation);
    }

    /**
     * 批量删除宿舍违纪
     * 
     * @param violationIds 需要删除的宿舍违纪主键
     * @return 结果
     */
    @Override
    public int deleteSsDormitoryViolationByViolationIds(Long[] violationIds)
    {
        return ssDormitoryViolationMapper.deleteSsDormitoryViolationByViolationIds(violationIds);
    }

    /**
     * 删除宿舍违纪信息
     * 
     * @param violationId 宿舍违纪主键
     * @return 结果
     */
    @Override
    public int deleteSsDormitoryViolationByViolationId(Long violationId)
    {
        return ssDormitoryViolationMapper.deleteSsDormitoryViolationByViolationId(violationId);
    }
}
