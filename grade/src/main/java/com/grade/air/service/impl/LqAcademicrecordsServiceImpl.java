package com.grade.air.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.grade.air.mapper.LqAcademicrecordsMapper;
import com.grade.air.domain.LqAcademicrecords;
import com.grade.air.service.ILqAcademicrecordsService;

/**
 * 学习情况Service业务层处理
 * 
 * @author l
 * @date 2023-06-04
 */
@Service
public class LqAcademicrecordsServiceImpl implements ILqAcademicrecordsService 
{
    @Autowired
    private LqAcademicrecordsMapper lqAcademicrecordsMapper;

    /**
     * 查询学习情况
     * 
     * @param studentID 学习情况主键
     * @return 学习情况
     */
    @Override
    public LqAcademicrecords selectLqAcademicrecordsByStudentID(Long studentID)
    {
        return lqAcademicrecordsMapper.selectLqAcademicrecordsByStudentID(studentID);
    }

    /**
     * 查询学习情况列表
     * 
     * @param lqAcademicrecords 学习情况
     * @return 学习情况
     */
    @Override
    @DataScope(userAlias = "recuit")
    public List<LqAcademicrecords> selectLqAcademicrecordsList(LqAcademicrecords lqAcademicrecords)
    {
        return lqAcademicrecordsMapper.selectLqAcademicrecordsList(lqAcademicrecords);
    }

    /**
     * 新增学习情况
     * 
     * @param lqAcademicrecords 学习情况
     * @return 结果
     */
    @Override
    public int insertLqAcademicrecords(LqAcademicrecords lqAcademicrecords)
    {
        return lqAcademicrecordsMapper.insertLqAcademicrecords(lqAcademicrecords);
    }

    /**
     * 修改学习情况
     * 
     * @param lqAcademicrecords 学习情况
     * @return 结果
     */
    @Override
    public int updateLqAcademicrecords(LqAcademicrecords lqAcademicrecords)
    {
        return lqAcademicrecordsMapper.updateLqAcademicrecords(lqAcademicrecords);
    }

    /**
     * 批量删除学习情况
     * 
     * @param studentIDs 需要删除的学习情况主键
     * @return 结果
     */
    @Override
    public int deleteLqAcademicrecordsByStudentIDs(Long[] studentIDs)
    {
        return lqAcademicrecordsMapper.deleteLqAcademicrecordsByStudentIDs(studentIDs);
    }

    /**
     * 删除学习情况信息
     * 
     * @param studentID 学习情况主键
     * @return 结果
     */
    @Override
    public int deleteLqAcademicrecordsByStudentID(Long studentID)
    {
        return lqAcademicrecordsMapper.deleteLqAcademicrecordsByStudentID(studentID);
    }
}
