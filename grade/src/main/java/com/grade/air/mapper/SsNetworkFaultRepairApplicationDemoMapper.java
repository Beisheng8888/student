package com.grade.air.mapper;

import java.util.List;
import com.grade.air.domain.SsNetworkFaultRepairApplicationDemo;

/**
 * 网络故障保修反馈Mapper接口
 * 
 * @author l
 * @date 2023-06-04
 */
public interface SsNetworkFaultRepairApplicationDemoMapper 
{
    /**
     * 查询网络故障保修反馈
     * 
     * @param id 网络故障保修反馈主键
     * @return 网络故障保修反馈
     */
    public SsNetworkFaultRepairApplicationDemo selectSsNetworkFaultRepairApplicationDemoById(Long id);

    /**
     * 查询网络故障保修反馈列表
     * 
     * @param ssNetworkFaultRepairApplicationDemo 网络故障保修反馈
     * @return 网络故障保修反馈集合
     */
    public List<SsNetworkFaultRepairApplicationDemo> selectSsNetworkFaultRepairApplicationDemoList(SsNetworkFaultRepairApplicationDemo ssNetworkFaultRepairApplicationDemo);

    /**
     * 新增网络故障保修反馈
     * 
     * @param ssNetworkFaultRepairApplicationDemo 网络故障保修反馈
     * @return 结果
     */
    public int insertSsNetworkFaultRepairApplicationDemo(SsNetworkFaultRepairApplicationDemo ssNetworkFaultRepairApplicationDemo);

    /**
     * 修改网络故障保修反馈
     * 
     * @param ssNetworkFaultRepairApplicationDemo 网络故障保修反馈
     * @return 结果
     */
    public int updateSsNetworkFaultRepairApplicationDemo(SsNetworkFaultRepairApplicationDemo ssNetworkFaultRepairApplicationDemo);

    /**
     * 删除网络故障保修反馈
     * 
     * @param id 网络故障保修反馈主键
     * @return 结果
     */
    public int deleteSsNetworkFaultRepairApplicationDemoById(Long id);

    /**
     * 批量删除网络故障保修反馈
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSsNetworkFaultRepairApplicationDemoByIds(Long[] ids);
}
