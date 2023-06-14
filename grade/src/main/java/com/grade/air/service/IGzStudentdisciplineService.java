package com.grade.air.service;

import java.util.List;
import com.grade.air.domain.GzStudentdiscipline;

/**
 * 学员通报Service接口
 * 
 * @author l
 * @date 2023-06-04
 */
public interface IGzStudentdisciplineService 
{
    /**
     * 查询学员通报
     * 
     * @param recordID 学员通报主键
     * @return 学员通报
     */
    public GzStudentdiscipline selectGzStudentdisciplineByRecordID(Long recordID);

    /**
     * 查询学员通报列表
     * 
     * @param gzStudentdiscipline 学员通报
     * @return 学员通报集合
     */
    public List<GzStudentdiscipline> selectGzStudentdisciplineList(GzStudentdiscipline gzStudentdiscipline);

    /**
     * 新增学员通报
     * 
     * @param gzStudentdiscipline 学员通报
     * @return 结果
     */
    public int insertGzStudentdiscipline(GzStudentdiscipline gzStudentdiscipline);

    /**
     * 修改学员通报
     * 
     * @param gzStudentdiscipline 学员通报
     * @return 结果
     */
    public int updateGzStudentdiscipline(GzStudentdiscipline gzStudentdiscipline);

    /**
     * 批量删除学员通报
     * 
     * @param recordIDs 需要删除的学员通报主键集合
     * @return 结果
     */
    public int deleteGzStudentdisciplineByRecordIDs(Long[] recordIDs);

    /**
     * 删除学员通报信息
     * 
     * @param recordID 学员通报主键
     * @return 结果
     */
    public int deleteGzStudentdisciplineByRecordID(Long recordID);
}
