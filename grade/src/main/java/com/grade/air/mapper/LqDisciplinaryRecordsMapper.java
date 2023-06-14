package com.grade.air.mapper;

import java.util.List;
import com.grade.air.domain.LqDisciplinaryRecords;

/**
 * 个人违纪处分Mapper接口
 * 
 * @author l
 * @date 2023-06-04
 */
public interface LqDisciplinaryRecordsMapper 
{
    /**
     * 查询个人违纪处分
     * 
     * @param recordId 个人违纪处分主键
     * @return 个人违纪处分
     */
    public LqDisciplinaryRecords selectLqDisciplinaryRecordsByRecordId(Long recordId);

    /**
     * 查询个人违纪处分列表
     * 
     * @param lqDisciplinaryRecords 个人违纪处分
     * @return 个人违纪处分集合
     */
    public List<LqDisciplinaryRecords> selectLqDisciplinaryRecordsList(LqDisciplinaryRecords lqDisciplinaryRecords);

    /**
     * 新增个人违纪处分
     * 
     * @param lqDisciplinaryRecords 个人违纪处分
     * @return 结果
     */
    public int insertLqDisciplinaryRecords(LqDisciplinaryRecords lqDisciplinaryRecords);

    /**
     * 修改个人违纪处分
     * 
     * @param lqDisciplinaryRecords 个人违纪处分
     * @return 结果
     */
    public int updateLqDisciplinaryRecords(LqDisciplinaryRecords lqDisciplinaryRecords);

    /**
     * 删除个人违纪处分
     * 
     * @param recordId 个人违纪处分主键
     * @return 结果
     */
    public int deleteLqDisciplinaryRecordsByRecordId(Long recordId);

    /**
     * 批量删除个人违纪处分
     * 
     * @param recordIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLqDisciplinaryRecordsByRecordIds(Long[] recordIds);
}
