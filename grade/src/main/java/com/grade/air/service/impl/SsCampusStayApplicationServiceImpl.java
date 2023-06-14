package com.grade.air.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.grade.air.mapper.SsCampusStayApplicationMapper;
import com.grade.air.domain.SsCampusStayApplication;
import com.grade.air.service.ISsCampusStayApplicationService;

/**
 * 假期留校申请Service业务层处理
 * 
 * @author l
 * @date 2023-06-04
 */
@Service
public class SsCampusStayApplicationServiceImpl implements ISsCampusStayApplicationService 
{
    @Autowired
    private SsCampusStayApplicationMapper ssCampusStayApplicationMapper;

    /**
     * 查询假期留校申请
     * 
     * @param applicationId 假期留校申请主键
     * @return 假期留校申请
     */
    @Override
    public SsCampusStayApplication selectSsCampusStayApplicationByApplicationId(Long applicationId)
    {
        return ssCampusStayApplicationMapper.selectSsCampusStayApplicationByApplicationId(applicationId);
    }

    /**
     * 查询假期留校申请列表
     * 
     * @param ssCampusStayApplication 假期留校申请
     * @return 假期留校申请
     */
    @Override
    public List<SsCampusStayApplication> selectSsCampusStayApplicationList(SsCampusStayApplication ssCampusStayApplication)
    {
        return ssCampusStayApplicationMapper.selectSsCampusStayApplicationList(ssCampusStayApplication);
    }

    /**
     * 新增假期留校申请
     * 
     * @param ssCampusStayApplication 假期留校申请
     * @return 结果
     */
    @Override
    public int insertSsCampusStayApplication(SsCampusStayApplication ssCampusStayApplication)
    {
        return ssCampusStayApplicationMapper.insertSsCampusStayApplication(ssCampusStayApplication);
    }

    /**
     * 修改假期留校申请
     * 
     * @param ssCampusStayApplication 假期留校申请
     * @return 结果
     */
    @Override
    public int updateSsCampusStayApplication(SsCampusStayApplication ssCampusStayApplication)
    {
        return ssCampusStayApplicationMapper.updateSsCampusStayApplication(ssCampusStayApplication);
    }

    /**
     * 批量删除假期留校申请
     * 
     * @param applicationIds 需要删除的假期留校申请主键
     * @return 结果
     */
    @Override
    public int deleteSsCampusStayApplicationByApplicationIds(Long[] applicationIds)
    {
        return ssCampusStayApplicationMapper.deleteSsCampusStayApplicationByApplicationIds(applicationIds);
    }

    /**
     * 删除假期留校申请信息
     * 
     * @param applicationId 假期留校申请主键
     * @return 结果
     */
    @Override
    public int deleteSsCampusStayApplicationByApplicationId(Long applicationId)
    {
        return ssCampusStayApplicationMapper.deleteSsCampusStayApplicationByApplicationId(applicationId);
    }
}
