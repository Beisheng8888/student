package com.grade.air.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.grade.air.mapper.GzScholarshipapplicationsMapper;
import com.grade.air.domain.GzScholarshipapplications;
import com.grade.air.service.IGzScholarshipapplicationsService;

/**
 * 资助申请Service业务层处理
 * 
 * @author l
 * @date 2023-06-04
 */
@Service
public class GzScholarshipapplicationsServiceImpl implements IGzScholarshipapplicationsService 
{
    @Autowired
    private GzScholarshipapplicationsMapper gzScholarshipapplicationsMapper;

    /**
     * 查询资助申请
     * 
     * @param applicationID 资助申请主键
     * @return 资助申请
     */
    @Override
    public GzScholarshipapplications selectGzScholarshipapplicationsByApplicationID(Long applicationID)
    {
        return gzScholarshipapplicationsMapper.selectGzScholarshipapplicationsByApplicationID(applicationID);
    }

    /**
     * 查询资助申请列表
     * 
     * @param gzScholarshipapplications 资助申请
     * @return 资助申请
     */
    @Override
    @DataScope(userAlias = "recuit")
    public List<GzScholarshipapplications> selectGzScholarshipapplicationsList(GzScholarshipapplications gzScholarshipapplications)
    {
        return gzScholarshipapplicationsMapper.selectGzScholarshipapplicationsList(gzScholarshipapplications);
    }

    /**
     * 新增资助申请
     * 
     * @param gzScholarshipapplications 资助申请
     * @return 结果
     */
    @Override
    public int insertGzScholarshipapplications(GzScholarshipapplications gzScholarshipapplications)
    {
        return gzScholarshipapplicationsMapper.insertGzScholarshipapplications(gzScholarshipapplications);
    }

    /**
     * 修改资助申请
     * 
     * @param gzScholarshipapplications 资助申请
     * @return 结果
     */
    @Override
    public int updateGzScholarshipapplications(GzScholarshipapplications gzScholarshipapplications)
    {
        return gzScholarshipapplicationsMapper.updateGzScholarshipapplications(gzScholarshipapplications);
    }

    /**
     * 批量删除资助申请
     * 
     * @param applicationIDs 需要删除的资助申请主键
     * @return 结果
     */
    @Override
    public int deleteGzScholarshipapplicationsByApplicationIDs(Long[] applicationIDs)
    {
        return gzScholarshipapplicationsMapper.deleteGzScholarshipapplicationsByApplicationIDs(applicationIDs);
    }

    /**
     * 删除资助申请信息
     * 
     * @param applicationID 资助申请主键
     * @return 结果
     */
    @Override
    public int deleteGzScholarshipapplicationsByApplicationID(Long applicationID)
    {
        return gzScholarshipapplicationsMapper.deleteGzScholarshipapplicationsByApplicationID(applicationID);
    }
}
