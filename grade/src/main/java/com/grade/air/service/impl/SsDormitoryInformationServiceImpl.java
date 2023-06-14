package com.grade.air.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.grade.air.mapper.SsDormitoryInformationMapper;
import com.grade.air.domain.SsDormitoryInformation;
import com.grade.air.service.ISsDormitoryInformationService;

/**
 * 宿舍信息Service业务层处理
 * 
 * @author l
 * @date 2023-06-04
 */
@Service
public class SsDormitoryInformationServiceImpl implements ISsDormitoryInformationService 
{
    @Autowired
    private SsDormitoryInformationMapper ssDormitoryInformationMapper;

    /**
     * 查询宿舍信息
     * 
     * @param dormitoryId 宿舍信息主键
     * @return 宿舍信息
     */
    @Override
    public SsDormitoryInformation selectSsDormitoryInformationByDormitoryId(Long dormitoryId)
    {
        return ssDormitoryInformationMapper.selectSsDormitoryInformationByDormitoryId(dormitoryId);
    }

    /**
     * 查询宿舍信息列表
     * 
     * @param ssDormitoryInformation 宿舍信息
     * @return 宿舍信息
     */
    @Override
    public List<SsDormitoryInformation> selectSsDormitoryInformationList(SsDormitoryInformation ssDormitoryInformation)
    {
        return ssDormitoryInformationMapper.selectSsDormitoryInformationList(ssDormitoryInformation);
    }

    /**
     * 新增宿舍信息
     * 
     * @param ssDormitoryInformation 宿舍信息
     * @return 结果
     */
    @Override
    public int insertSsDormitoryInformation(SsDormitoryInformation ssDormitoryInformation)
    {
        return ssDormitoryInformationMapper.insertSsDormitoryInformation(ssDormitoryInformation);
    }

    /**
     * 修改宿舍信息
     * 
     * @param ssDormitoryInformation 宿舍信息
     * @return 结果
     */
    @Override
    public int updateSsDormitoryInformation(SsDormitoryInformation ssDormitoryInformation)
    {
        return ssDormitoryInformationMapper.updateSsDormitoryInformation(ssDormitoryInformation);
    }

    /**
     * 批量删除宿舍信息
     * 
     * @param dormitoryIds 需要删除的宿舍信息主键
     * @return 结果
     */
    @Override
    public int deleteSsDormitoryInformationByDormitoryIds(Long[] dormitoryIds)
    {
        return ssDormitoryInformationMapper.deleteSsDormitoryInformationByDormitoryIds(dormitoryIds);
    }

    /**
     * 删除宿舍信息信息
     * 
     * @param dormitoryId 宿舍信息主键
     * @return 结果
     */
    @Override
    public int deleteSsDormitoryInformationByDormitoryId(Long dormitoryId)
    {
        return ssDormitoryInformationMapper.deleteSsDormitoryInformationByDormitoryId(dormitoryId);
    }
}
