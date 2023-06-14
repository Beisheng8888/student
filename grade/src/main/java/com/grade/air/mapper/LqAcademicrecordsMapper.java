package com.grade.air.mapper;

import java.util.List;
import com.grade.air.domain.LqAcademicrecords;

/**
 * 学习情况Mapper接口
 * 
 * @author l
 * @date 2023-06-04
 */
public interface LqAcademicrecordsMapper 
{
    /**
     * 查询学习情况
     * 
     * @param studentID 学习情况主键
     * @return 学习情况
     */
    public LqAcademicrecords selectLqAcademicrecordsByStudentID(Long studentID);

    /**
     * 查询学习情况列表
     * 
     * @param lqAcademicrecords 学习情况
     * @return 学习情况集合
     */
    public List<LqAcademicrecords> selectLqAcademicrecordsList(LqAcademicrecords lqAcademicrecords);

    /**
     * 新增学习情况
     * 
     * @param lqAcademicrecords 学习情况
     * @return 结果
     */
    public int insertLqAcademicrecords(LqAcademicrecords lqAcademicrecords);

    /**
     * 修改学习情况
     * 
     * @param lqAcademicrecords 学习情况
     * @return 结果
     */
    public int updateLqAcademicrecords(LqAcademicrecords lqAcademicrecords);

    /**
     * 删除学习情况
     * 
     * @param studentID 学习情况主键
     * @return 结果
     */
    public int deleteLqAcademicrecordsByStudentID(Long studentID);

    /**
     * 批量删除学习情况
     * 
     * @param studentIDs 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLqAcademicrecordsByStudentIDs(Long[] studentIDs);


}
