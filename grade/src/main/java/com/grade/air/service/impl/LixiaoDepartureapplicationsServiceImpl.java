package com.grade.air.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.grade.air.mapper.LixiaoDepartureapplicationsMapper;
import com.grade.air.domain.LixiaoDepartureapplications;
import com.grade.air.service.ILixiaoDepartureapplicationsService;

/**
 * 离校申请Service业务层处理
 * 
 * @author l
 * @date 2023-06-04
 */
@Service
public class LixiaoDepartureapplicationsServiceImpl implements ILixiaoDepartureapplicationsService 
{
    @Autowired
    private LixiaoDepartureapplicationsMapper lixiaoDepartureapplicationsMapper;

    /**
     * 查询离校申请
     * 
     * @param applicationID 离校申请主键
     * @return 离校申请
     */
    @Override
    public LixiaoDepartureapplications selectLixiaoDepartureapplicationsByApplicationID(Long applicationID)
    {
        return lixiaoDepartureapplicationsMapper.selectLixiaoDepartureapplicationsByApplicationID(applicationID);
    }

    /**
     * 查询离校申请列表
     * 
     * @param lixiaoDepartureapplications 离校申请
     * @return 离校申请
     */
    @Override
    public List<LixiaoDepartureapplications> selectLixiaoDepartureapplicationsList(LixiaoDepartureapplications lixiaoDepartureapplications)
    {
        return lixiaoDepartureapplicationsMapper.selectLixiaoDepartureapplicationsList(lixiaoDepartureapplications);
    }

    /**
     * 新增离校申请
     * 
     * @param lixiaoDepartureapplications 离校申请
     * @return 结果
     */
    @Override
    public int insertLixiaoDepartureapplications(LixiaoDepartureapplications lixiaoDepartureapplications)
    {
        return lixiaoDepartureapplicationsMapper.insertLixiaoDepartureapplications(lixiaoDepartureapplications);
    }

    /**
     * 修改离校申请
     * 
     * @param lixiaoDepartureapplications 离校申请
     * @return 结果
     */
    @Override
    public int updateLixiaoDepartureapplications(LixiaoDepartureapplications lixiaoDepartureapplications)
    {
        return lixiaoDepartureapplicationsMapper.updateLixiaoDepartureapplications(lixiaoDepartureapplications);
    }

    /**
     * 批量删除离校申请
     * 
     * @param applicationIDs 需要删除的离校申请主键
     * @return 结果
     */
    @Override
    public int deleteLixiaoDepartureapplicationsByApplicationIDs(Long[] applicationIDs)
    {
        return lixiaoDepartureapplicationsMapper.deleteLixiaoDepartureapplicationsByApplicationIDs(applicationIDs);
    }

    /**
     * 删除离校申请信息
     * 
     * @param applicationID 离校申请主键
     * @return 结果
     */
    @Override
    public int deleteLixiaoDepartureapplicationsByApplicationID(Long applicationID)
    {
        return lixiaoDepartureapplicationsMapper.deleteLixiaoDepartureapplicationsByApplicationID(applicationID);
    }
}
