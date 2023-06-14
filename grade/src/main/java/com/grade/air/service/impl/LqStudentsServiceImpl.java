package com.grade.air.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.grade.air.mapper.LqStudentsMapper;
import com.grade.air.domain.LqStudents;
import com.grade.air.service.ILqStudentsService;

/**
 * 学生信息Service业务层处理
 * 
 * @author l
 * @date 2023-06-04
 */
@Service
public class LqStudentsServiceImpl implements ILqStudentsService 
{
    @Autowired
    private LqStudentsMapper lqStudentsMapper;

    /**
     * 查询学生信息
     * 
     * @param studentID 学生信息主键
     * @return 学生信息
     */
    @Override
    public LqStudents selectLqStudentsByStudentID(Long studentID)
    {
        return lqStudentsMapper.selectLqStudentsByStudentID(studentID);
    }

    /**
     * 查询学生信息列表
     * 
     * @param lqStudents 学生信息
     * @return 学生信息
     */
    @Override
    @DataScope(userAlias = "recuit")
    public List<LqStudents> selectLqStudentsList(LqStudents lqStudents)
    {
        return lqStudentsMapper.selectLqStudentsList(lqStudents);
    }

    /**
     * 新增学生信息
     * 
     * @param lqStudents 学生信息
     * @return 结果
     */
    @Override
    public int insertLqStudents(LqStudents lqStudents)
    {
        return lqStudentsMapper.insertLqStudents(lqStudents);
    }

    /**
     * 修改学生信息
     * 
     * @param lqStudents 学生信息
     * @return 结果
     */
    @Override
    public int updateLqStudents(LqStudents lqStudents)
    {
        return lqStudentsMapper.updateLqStudents(lqStudents);
    }

    /**
     * 批量删除学生信息
     * 
     * @param studentIDs 需要删除的学生信息主键
     * @return 结果
     */
    @Override
    public int deleteLqStudentsByStudentIDs(Long[] studentIDs)
    {
        return lqStudentsMapper.deleteLqStudentsByStudentIDs(studentIDs);
    }

    /**
     * 删除学生信息信息
     * 
     * @param studentID 学生信息主键
     * @return 结果
     */
    @Override
    public int deleteLqStudentsByStudentID(Long studentID)
    {
        return lqStudentsMapper.deleteLqStudentsByStudentID(studentID);
    }
}
