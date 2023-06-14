package com.grade.air.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.grade.air.mapper.GzAcademicrecordsMapper;
import com.grade.air.domain.GzAcademicrecords;
import com.grade.air.service.IGzAcademicrecordsService;

/**
 * 学籍成绩Service业务层处理
 * 
 * @author l
 * @date 2023-06-04
 */
@Service
public class GzAcademicrecordsServiceImpl implements IGzAcademicrecordsService 
{
    @Autowired
    private GzAcademicrecordsMapper gzAcademicrecordsMapper;

    /**
     * 查询学籍成绩
     * 
     * @param recordID 学籍成绩主键
     * @return 学籍成绩
     */
    @Override
    public GzAcademicrecords selectGzAcademicrecordsByRecordID(Long recordID)
    {
        return gzAcademicrecordsMapper.selectGzAcademicrecordsByRecordID(recordID);
    }

    /**
     * 查询学籍成绩列表
     * 
     * @param gzAcademicrecords 学籍成绩
     * @return 学籍成绩
     */
    @Override
    @DataScope(userAlias = "recuit")
    public List<GzAcademicrecords> selectGzAcademicrecordsList(GzAcademicrecords gzAcademicrecords)
    {
        return gzAcademicrecordsMapper.selectGzAcademicrecordsList(gzAcademicrecords);
    }

    /**
     * 新增学籍成绩
     * 
     * @param gzAcademicrecords 学籍成绩
     * @return 结果
     */
    @Override
    public int insertGzAcademicrecords(GzAcademicrecords gzAcademicrecords)
    {
        return gzAcademicrecordsMapper.insertGzAcademicrecords(gzAcademicrecords);
    }

    /**
     * 修改学籍成绩
     * 
     * @param gzAcademicrecords 学籍成绩
     * @return 结果
     */
    @Override
    public int updateGzAcademicrecords(GzAcademicrecords gzAcademicrecords)
    {
        return gzAcademicrecordsMapper.updateGzAcademicrecords(gzAcademicrecords);
    }

    /**
     * 批量删除学籍成绩
     * 
     * @param recordIDs 需要删除的学籍成绩主键
     * @return 结果
     */
    @Override
    public int deleteGzAcademicrecordsByRecordIDs(Long[] recordIDs)
    {
        return gzAcademicrecordsMapper.deleteGzAcademicrecordsByRecordIDs(recordIDs);
    }

    /**
     * 删除学籍成绩信息
     * 
     * @param recordID 学籍成绩主键
     * @return 结果
     */
    @Override
    public int deleteGzAcademicrecordsByRecordID(Long recordID)
    {
        return gzAcademicrecordsMapper.deleteGzAcademicrecordsByRecordID(recordID);
    }
}
