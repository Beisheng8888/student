package com.grade.air.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.grade.air.mapper.SsNetworkFaultRepairApplicationMapper;
import com.grade.air.domain.SsNetworkFaultRepairApplication;
import com.grade.air.service.ISsNetworkFaultRepairApplicationService;

/**
 * 网络故障保修Service业务层处理
 * 
 * @author l
 * @date 2023-06-04
 */
@Service
public class SsNetworkFaultRepairApplicationServiceImpl implements ISsNetworkFaultRepairApplicationService 
{
    @Autowired
    private SsNetworkFaultRepairApplicationMapper ssNetworkFaultRepairApplicationMapper;

    /**
     * 查询网络故障保修
     * 
     * @param applicationId 网络故障保修主键
     * @return 网络故障保修
     */
    @Override
    public SsNetworkFaultRepairApplication selectSsNetworkFaultRepairApplicationByApplicationId(Long applicationId)
    {
        return ssNetworkFaultRepairApplicationMapper.selectSsNetworkFaultRepairApplicationByApplicationId(applicationId);
    }

    /**
     * 查询网络故障保修列表
     * 
     * @param ssNetworkFaultRepairApplication 网络故障保修
     * @return 网络故障保修
     */
    @Override
    public List<SsNetworkFaultRepairApplication> selectSsNetworkFaultRepairApplicationList(SsNetworkFaultRepairApplication ssNetworkFaultRepairApplication)
    {
        return ssNetworkFaultRepairApplicationMapper.selectSsNetworkFaultRepairApplicationList(ssNetworkFaultRepairApplication);
    }

    /**
     * 新增网络故障保修
     * 
     * @param ssNetworkFaultRepairApplication 网络故障保修
     * @return 结果
     */
    @Override
    public int insertSsNetworkFaultRepairApplication(SsNetworkFaultRepairApplication ssNetworkFaultRepairApplication)
    {
        return ssNetworkFaultRepairApplicationMapper.insertSsNetworkFaultRepairApplication(ssNetworkFaultRepairApplication);
    }

    /**
     * 修改网络故障保修
     * 
     * @param ssNetworkFaultRepairApplication 网络故障保修
     * @return 结果
     */
    @Override
    public int updateSsNetworkFaultRepairApplication(SsNetworkFaultRepairApplication ssNetworkFaultRepairApplication)
    {
        return ssNetworkFaultRepairApplicationMapper.updateSsNetworkFaultRepairApplication(ssNetworkFaultRepairApplication);
    }

    /**
     * 批量删除网络故障保修
     * 
     * @param applicationIds 需要删除的网络故障保修主键
     * @return 结果
     */
    @Override
    public int deleteSsNetworkFaultRepairApplicationByApplicationIds(Long[] applicationIds)
    {
        return ssNetworkFaultRepairApplicationMapper.deleteSsNetworkFaultRepairApplicationByApplicationIds(applicationIds);
    }

    /**
     * 删除网络故障保修信息
     * 
     * @param applicationId 网络故障保修主键
     * @return 结果
     */
    @Override
    public int deleteSsNetworkFaultRepairApplicationByApplicationId(Long applicationId)
    {
        return ssNetworkFaultRepairApplicationMapper.deleteSsNetworkFaultRepairApplicationByApplicationId(applicationId);
    }
}
