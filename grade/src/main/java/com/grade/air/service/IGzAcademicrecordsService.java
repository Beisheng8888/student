package com.grade.air.service;

import java.util.List;
import com.grade.air.domain.GzAcademicrecords;

/**
 * 学籍成绩Service接口
 * 
 * @author l
 * @date 2023-06-04
 */
public interface IGzAcademicrecordsService 
{
    /**
     * 查询学籍成绩
     * 
     * @param recordID 学籍成绩主键
     * @return 学籍成绩
     */
    public GzAcademicrecords selectGzAcademicrecordsByRecordID(Long recordID);

    /**
     * 查询学籍成绩列表
     * 
     * @param gzAcademicrecords 学籍成绩
     * @return 学籍成绩集合
     */
    public List<GzAcademicrecords> selectGzAcademicrecordsList(GzAcademicrecords gzAcademicrecords);

    /**
     * 新增学籍成绩
     * 
     * @param gzAcademicrecords 学籍成绩
     * @return 结果
     */
    public int insertGzAcademicrecords(GzAcademicrecords gzAcademicrecords);

    /**
     * 修改学籍成绩
     * 
     * @param gzAcademicrecords 学籍成绩
     * @return 结果
     */
    public int updateGzAcademicrecords(GzAcademicrecords gzAcademicrecords);

    /**
     * 批量删除学籍成绩
     * 
     * @param recordIDs 需要删除的学籍成绩主键集合
     * @return 结果
     */
    public int deleteGzAcademicrecordsByRecordIDs(Long[] recordIDs);

    /**
     * 删除学籍成绩信息
     * 
     * @param recordID 学籍成绩主键
     * @return 结果
     */
    public int deleteGzAcademicrecordsByRecordID(Long recordID);
}
