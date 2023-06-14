package com.grade.air.mapper;

import java.util.List;
import com.grade.air.domain.StudentRecords;

/**
 * 档案查询Mapper接口
 * 
 * @author l
 * @date 2023-06-05
 */
public interface StudentRecordsMapper 
{
    /**
     * 查询档案查询
     * 
     * @param studentId 档案查询主键
     * @return 档案查询
     */
    public StudentRecords selectStudentRecordsByStudentId(Long studentId);

    /**
     * 查询档案查询列表
     * 
     * @param studentRecords 档案查询
     * @return 档案查询集合
     */
    public List<StudentRecords> selectStudentRecordsList(StudentRecords studentRecords);

    /**
     * 新增档案查询
     * 
     * @param studentRecords 档案查询
     * @return 结果
     */
    public int insertStudentRecords(StudentRecords studentRecords);

    /**
     * 修改档案查询
     * 
     * @param studentRecords 档案查询
     * @return 结果
     */
    public int updateStudentRecords(StudentRecords studentRecords);

    /**
     * 删除档案查询
     * 
     * @param studentId 档案查询主键
     * @return 结果
     */
    public int deleteStudentRecordsByStudentId(Long studentId);

    /**
     * 批量删除档案查询
     * 
     * @param studentIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStudentRecordsByStudentIds(Long[] studentIds);
}
