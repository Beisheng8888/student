package com.grade.air.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.grade.air.mapper.LqDisciplinaryRecordsMapper;
import com.grade.air.domain.LqDisciplinaryRecords;
import com.grade.air.service.ILqDisciplinaryRecordsService;

/**
 * 个人违纪处分Service业务层处理
 * 
 * @author l
 * @date 2023-06-04
 */
@Service
public class LqDisciplinaryRecordsServiceImpl implements ILqDisciplinaryRecordsService 
{
    @Autowired
    private LqDisciplinaryRecordsMapper lqDisciplinaryRecordsMapper;

    /**
     * 查询个人违纪处分
     * 
     * @param recordId 个人违纪处分主键
     * @return 个人违纪处分
     */
    @Override
    public LqDisciplinaryRecords selectLqDisciplinaryRecordsByRecordId(Long recordId)
    {
        return lqDisciplinaryRecordsMapper.selectLqDisciplinaryRecordsByRecordId(recordId);
    }

    /**
     * 查询个人违纪处分列表
     * 
     * @param lqDisciplinaryRecords 个人违纪处分
     * @return 个人违纪处分
     */
    @Override
    @DataScope(userAlias = "recuit")
    public List<LqDisciplinaryRecords> selectLqDisciplinaryRecordsList(LqDisciplinaryRecords lqDisciplinaryRecords)
    {
        return lqDisciplinaryRecordsMapper.selectLqDisciplinaryRecordsList(lqDisciplinaryRecords);
    }

    /**
     * 新增个人违纪处分
     * 
     * @param lqDisciplinaryRecords 个人违纪处分
     * @return 结果
     */
    @Override
    public int insertLqDisciplinaryRecords(LqDisciplinaryRecords lqDisciplinaryRecords)
    {
        return lqDisciplinaryRecordsMapper.insertLqDisciplinaryRecords(lqDisciplinaryRecords);
    }

    /**
     * 修改个人违纪处分
     * 
     * @param lqDisciplinaryRecords 个人违纪处分
     * @return 结果
     */
    @Override
    public int updateLqDisciplinaryRecords(LqDisciplinaryRecords lqDisciplinaryRecords)
    {
        return lqDisciplinaryRecordsMapper.updateLqDisciplinaryRecords(lqDisciplinaryRecords);
    }

    /**
     * 批量删除个人违纪处分
     * 
     * @param recordIds 需要删除的个人违纪处分主键
     * @return 结果
     */
    @Override
    public int deleteLqDisciplinaryRecordsByRecordIds(Long[] recordIds)
    {
        return lqDisciplinaryRecordsMapper.deleteLqDisciplinaryRecordsByRecordIds(recordIds);
    }

    /**
     * 删除个人违纪处分信息
     * 
     * @param recordId 个人违纪处分主键
     * @return 结果
     */
    @Override
    public int deleteLqDisciplinaryRecordsByRecordId(Long recordId)
    {
        return lqDisciplinaryRecordsMapper.deleteLqDisciplinaryRecordsByRecordId(recordId);
    }
}
