package com.grade.air.mapper;

import java.util.List;
import com.grade.air.domain.LqStudents;

/**
 * 学生信息Mapper接口
 * 
 * @author l
 * @date 2023-06-04
 */
public interface LqStudentsMapper 
{
    /**
     * 查询学生信息
     * 
     * @param studentID 学生信息主键
     * @return 学生信息
     */
    public LqStudents selectLqStudentsByStudentID(Long studentID);

    /**
     * 查询学生信息列表
     * 
     * @param lqStudents 学生信息
     * @return 学生信息集合
     */
    public List<LqStudents> selectLqStudentsList(LqStudents lqStudents);

    /**
     * 新增学生信息
     * 
     * @param lqStudents 学生信息
     * @return 结果
     */
    public int insertLqStudents(LqStudents lqStudents);

    /**
     * 修改学生信息
     * 
     * @param lqStudents 学生信息
     * @return 结果
     */
    public int updateLqStudents(LqStudents lqStudents);

    /**
     * 删除学生信息
     * 
     * @param studentID 学生信息主键
     * @return 结果
     */
    public int deleteLqStudentsByStudentID(Long studentID);

    /**
     * 批量删除学生信息
     * 
     * @param studentIDs 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLqStudentsByStudentIDs(Long[] studentIDs);
}
