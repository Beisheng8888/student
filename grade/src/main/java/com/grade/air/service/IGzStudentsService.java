package com.grade.air.service;

import java.util.List;
import com.grade.air.domain.GzStudents;

/**
 * 学生证办理Service接口
 * 
 * @author l
 * @date 2023-06-04
 */
public interface IGzStudentsService 
{
    /**
     * 查询学生证办理
     * 
     * @param studentID 学生证办理主键
     * @return 学生证办理
     */
    public GzStudents selectGzStudentsByStudentID(Long studentID);

    /**
     * 查询学生证办理列表
     * 
     * @param gzStudents 学生证办理
     * @return 学生证办理集合
     */
    public List<GzStudents> selectGzStudentsList(GzStudents gzStudents);

    /**
     * 新增学生证办理
     * 
     * @param gzStudents 学生证办理
     * @return 结果
     */
    public int insertGzStudents(GzStudents gzStudents);

    /**
     * 修改学生证办理
     * 
     * @param gzStudents 学生证办理
     * @return 结果
     */
    public int updateGzStudents(GzStudents gzStudents);

    /**
     * 批量删除学生证办理
     * 
     * @param studentIDs 需要删除的学生证办理主键集合
     * @return 结果
     */
    public int deleteGzStudentsByStudentIDs(Long[] studentIDs);

    /**
     * 删除学生证办理信息
     * 
     * @param studentID 学生证办理主键
     * @return 结果
     */
    public int deleteGzStudentsByStudentID(Long studentID);
}
