package com.grade.air.service;

import java.util.List;
import com.grade.air.domain.SsNetworkFaultRepairApplication;

/**
 * 网络故障保修Service接口
 * 
 * @author l
 * @date 2023-06-04
 */
public interface ISsNetworkFaultRepairApplicationService 
{
    /**
     * 查询网络故障保修
     * 
     * @param applicationId 网络故障保修主键
     * @return 网络故障保修
     */
    public SsNetworkFaultRepairApplication selectSsNetworkFaultRepairApplicationByApplicationId(Long applicationId);

    /**
     * 查询网络故障保修列表
     * 
     * @param ssNetworkFaultRepairApplication 网络故障保修
     * @return 网络故障保修集合
     */
    public List<SsNetworkFaultRepairApplication> selectSsNetworkFaultRepairApplicationList(SsNetworkFaultRepairApplication ssNetworkFaultRepairApplication);

    /**
     * 新增网络故障保修
     * 
     * @param ssNetworkFaultRepairApplication 网络故障保修
     * @return 结果
     */
    public int insertSsNetworkFaultRepairApplication(SsNetworkFaultRepairApplication ssNetworkFaultRepairApplication);

    /**
     * 修改网络故障保修
     * 
     * @param ssNetworkFaultRepairApplication 网络故障保修
     * @return 结果
     */
    public int updateSsNetworkFaultRepairApplication(SsNetworkFaultRepairApplication ssNetworkFaultRepairApplication);

    /**
     * 批量删除网络故障保修
     * 
     * @param applicationIds 需要删除的网络故障保修主键集合
     * @return 结果
     */
    public int deleteSsNetworkFaultRepairApplicationByApplicationIds(Long[] applicationIds);

    /**
     * 删除网络故障保修信息
     * 
     * @param applicationId 网络故障保修主键
     * @return 结果
     */
    public int deleteSsNetworkFaultRepairApplicationByApplicationId(Long applicationId);
}
