package com.grade.air.service;

import java.util.List;
import com.grade.air.domain.SsDormitoryViolation;

/**
 * 宿舍违纪Service接口
 * 
 * @author l
 * @date 2023-06-04
 */
public interface ISsDormitoryViolationService 
{
    /**
     * 查询宿舍违纪
     * 
     * @param violationId 宿舍违纪主键
     * @return 宿舍违纪
     */
    public SsDormitoryViolation selectSsDormitoryViolationByViolationId(Long violationId);

    /**
     * 查询宿舍违纪列表
     * 
     * @param ssDormitoryViolation 宿舍违纪
     * @return 宿舍违纪集合
     */
    public List<SsDormitoryViolation> selectSsDormitoryViolationList(SsDormitoryViolation ssDormitoryViolation);

    /**
     * 新增宿舍违纪
     * 
     * @param ssDormitoryViolation 宿舍违纪
     * @return 结果
     */
    public int insertSsDormitoryViolation(SsDormitoryViolation ssDormitoryViolation);

    /**
     * 修改宿舍违纪
     * 
     * @param ssDormitoryViolation 宿舍违纪
     * @return 结果
     */
    public int updateSsDormitoryViolation(SsDormitoryViolation ssDormitoryViolation);

    /**
     * 批量删除宿舍违纪
     * 
     * @param violationIds 需要删除的宿舍违纪主键集合
     * @return 结果
     */
    public int deleteSsDormitoryViolationByViolationIds(Long[] violationIds);

    /**
     * 删除宿舍违纪信息
     * 
     * @param violationId 宿舍违纪主键
     * @return 结果
     */
    public int deleteSsDormitoryViolationByViolationId(Long violationId);
}
