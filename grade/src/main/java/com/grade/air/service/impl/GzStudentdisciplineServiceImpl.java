package com.grade.air.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.grade.air.mapper.GzStudentdisciplineMapper;
import com.grade.air.domain.GzStudentdiscipline;
import com.grade.air.service.IGzStudentdisciplineService;

/**
 * 学员通报Service业务层处理
 * 
 * @author l
 * @date 2023-06-04
 */
@Service
public class GzStudentdisciplineServiceImpl implements IGzStudentdisciplineService 
{
    @Autowired
    private GzStudentdisciplineMapper gzStudentdisciplineMapper;

    /**
     * 查询学员通报
     * 
     * @param recordID 学员通报主键
     * @return 学员通报
     */
    @Override
    public GzStudentdiscipline selectGzStudentdisciplineByRecordID(Long recordID)
    {
        return gzStudentdisciplineMapper.selectGzStudentdisciplineByRecordID(recordID);
    }

    /**
     * 查询学员通报列表
     * 
     * @param gzStudentdiscipline 学员通报
     * @return 学员通报
     */
    @Override
    @DataScope(userAlias = "recuit")
    public List<GzStudentdiscipline> selectGzStudentdisciplineList(GzStudentdiscipline gzStudentdiscipline)
    {
        return gzStudentdisciplineMapper.selectGzStudentdisciplineList(gzStudentdiscipline);
    }

    /**
     * 新增学员通报
     * 
     * @param gzStudentdiscipline 学员通报
     * @return 结果
     */
    @Override
    public int insertGzStudentdiscipline(GzStudentdiscipline gzStudentdiscipline)
    {
        return gzStudentdisciplineMapper.insertGzStudentdiscipline(gzStudentdiscipline);
    }

    /**
     * 修改学员通报
     * 
     * @param gzStudentdiscipline 学员通报
     * @return 结果
     */
    @Override
    public int updateGzStudentdiscipline(GzStudentdiscipline gzStudentdiscipline)
    {
        return gzStudentdisciplineMapper.updateGzStudentdiscipline(gzStudentdiscipline);
    }

    /**
     * 批量删除学员通报
     * 
     * @param recordIDs 需要删除的学员通报主键
     * @return 结果
     */
    @Override
    public int deleteGzStudentdisciplineByRecordIDs(Long[] recordIDs)
    {
        return gzStudentdisciplineMapper.deleteGzStudentdisciplineByRecordIDs(recordIDs);
    }

    /**
     * 删除学员通报信息
     * 
     * @param recordID 学员通报主键
     * @return 结果
     */
    @Override
    public int deleteGzStudentdisciplineByRecordID(Long recordID)
    {
        return gzStudentdisciplineMapper.deleteGzStudentdisciplineByRecordID(recordID);
    }
}
