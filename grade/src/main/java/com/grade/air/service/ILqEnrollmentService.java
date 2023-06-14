package com.grade.air.service;

import java.util.List;
import com.grade.air.domain.LqEnrollment;

/**
 * 学籍情况Service接口
 * 
 * @author l
 * @date 2023-06-04
 */
public interface ILqEnrollmentService 
{
    /**
     * 查询学籍情况
     * 
     * @param studentID 学籍情况主键
     * @return 学籍情况
     */
    public LqEnrollment selectLqEnrollmentByStudentID(Long studentID);

    /**
     * 查询学籍情况列表
     * 
     * @param lqEnrollment 学籍情况
     * @return 学籍情况集合
     */
    public List<LqEnrollment> selectLqEnrollmentList(LqEnrollment lqEnrollment);

    /**
     * 新增学籍情况
     * 
     * @param lqEnrollment 学籍情况
     * @return 结果
     */
    public int insertLqEnrollment(LqEnrollment lqEnrollment);

    /**
     * 修改学籍情况
     * 
     * @param lqEnrollment 学籍情况
     * @return 结果
     */
    public int updateLqEnrollment(LqEnrollment lqEnrollment);

    /**
     * 批量删除学籍情况
     * 
     * @param studentIDs 需要删除的学籍情况主键集合
     * @return 结果
     */
    public int deleteLqEnrollmentByStudentIDs(Long[] studentIDs);

    /**
     * 删除学籍情况信息
     * 
     * @param studentID 学籍情况主键
     * @return 结果
     */
    public int deleteLqEnrollmentByStudentID(Long studentID);
}
