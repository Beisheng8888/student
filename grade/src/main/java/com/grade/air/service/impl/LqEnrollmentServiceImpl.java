package com.grade.air.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.grade.air.mapper.LqEnrollmentMapper;
import com.grade.air.domain.LqEnrollment;
import com.grade.air.service.ILqEnrollmentService;

/**
 * 学籍情况Service业务层处理
 * 
 * @author l
 * @date 2023-06-04
 */
@Service
public class LqEnrollmentServiceImpl implements ILqEnrollmentService 
{
    @Autowired
    private LqEnrollmentMapper lqEnrollmentMapper;

    /**
     * 查询学籍情况
     * 
     * @param studentID 学籍情况主键
     * @return 学籍情况
     */
    @Override
    public LqEnrollment selectLqEnrollmentByStudentID(Long studentID)
    {
        return lqEnrollmentMapper.selectLqEnrollmentByStudentID(studentID);
    }

    /**
     * 查询学籍情况列表
     * 
     * @param lqEnrollment 学籍情况
     * @return 学籍情况
     */
    @Override
    @DataScope(userAlias = "recuit")
    public List<LqEnrollment> selectLqEnrollmentList(LqEnrollment lqEnrollment)
    {
        return lqEnrollmentMapper.selectLqEnrollmentList(lqEnrollment);
    }

    /**
     * 新增学籍情况
     * 
     * @param lqEnrollment 学籍情况
     * @return 结果
     */
    @Override
    public int insertLqEnrollment(LqEnrollment lqEnrollment)
    {
        return lqEnrollmentMapper.insertLqEnrollment(lqEnrollment);
    }

    /**
     * 修改学籍情况
     * 
     * @param lqEnrollment 学籍情况
     * @return 结果
     */
    @Override
    public int updateLqEnrollment(LqEnrollment lqEnrollment)
    {
        return lqEnrollmentMapper.updateLqEnrollment(lqEnrollment);
    }

    /**
     * 批量删除学籍情况
     * 
     * @param studentIDs 需要删除的学籍情况主键
     * @return 结果
     */
    @Override
    public int deleteLqEnrollmentByStudentIDs(Long[] studentIDs)
    {
        return lqEnrollmentMapper.deleteLqEnrollmentByStudentIDs(studentIDs);
    }

    /**
     * 删除学籍情况信息
     * 
     * @param studentID 学籍情况主键
     * @return 结果
     */
    @Override
    public int deleteLqEnrollmentByStudentID(Long studentID)
    {
        return lqEnrollmentMapper.deleteLqEnrollmentByStudentID(studentID);
    }
}
