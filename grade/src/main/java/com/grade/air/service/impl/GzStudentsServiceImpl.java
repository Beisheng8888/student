package com.grade.air.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.grade.air.mapper.GzStudentsMapper;
import com.grade.air.domain.GzStudents;
import com.grade.air.service.IGzStudentsService;

/**
 * 学生证办理Service业务层处理
 * 
 * @author l
 * @date 2023-06-04
 */
@Service
public class GzStudentsServiceImpl implements IGzStudentsService 
{
    @Autowired
    private GzStudentsMapper gzStudentsMapper;

    /**
     * 查询学生证办理
     * 
     * @param studentID 学生证办理主键
     * @return 学生证办理
     */
    @Override
    public GzStudents selectGzStudentsByStudentID(Long studentID)
    {
        return gzStudentsMapper.selectGzStudentsByStudentID(studentID);
    }

    /**
     * 查询学生证办理列表
     * 
     * @param gzStudents 学生证办理
     * @return 学生证办理
     */
    @Override
    @DataScope(userAlias = "recuit")
    public List<GzStudents> selectGzStudentsList(GzStudents gzStudents)
    {
        return gzStudentsMapper.selectGzStudentsList(gzStudents);
    }

    /**
     * 新增学生证办理
     * 
     * @param gzStudents 学生证办理
     * @return 结果
     */
    @Override
    public int insertGzStudents(GzStudents gzStudents)
    {
        return gzStudentsMapper.insertGzStudents(gzStudents);
    }

    /**
     * 修改学生证办理
     * 
     * @param gzStudents 学生证办理
     * @return 结果
     */
    @Override
    public int updateGzStudents(GzStudents gzStudents)
    {
        return gzStudentsMapper.updateGzStudents(gzStudents);
    }

    /**
     * 批量删除学生证办理
     * 
     * @param studentIDs 需要删除的学生证办理主键
     * @return 结果
     */
    @Override
    public int deleteGzStudentsByStudentIDs(Long[] studentIDs)
    {
        return gzStudentsMapper.deleteGzStudentsByStudentIDs(studentIDs);
    }

    /**
     * 删除学生证办理信息
     * 
     * @param studentID 学生证办理主键
     * @return 结果
     */
    @Override
    public int deleteGzStudentsByStudentID(Long studentID)
    {
        return gzStudentsMapper.deleteGzStudentsByStudentID(studentID);
    }
}
