package com.grade.air.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.grade.air.mapper.SsNetworkFaultRepairApplicationDemoMapper;
import com.grade.air.domain.SsNetworkFaultRepairApplicationDemo;
import com.grade.air.service.ISsNetworkFaultRepairApplicationDemoService;

/**
 * 网络故障保修反馈Service业务层处理
 * 
 * @author l
 * @date 2023-06-04
 */
@Service
public class SsNetworkFaultRepairApplicationDemoServiceImpl implements ISsNetworkFaultRepairApplicationDemoService 
{
    @Autowired
    private SsNetworkFaultRepairApplicationDemoMapper ssNetworkFaultRepairApplicationDemoMapper;

    /**
     * 查询网络故障保修反馈
     * 
     * @param id 网络故障保修反馈主键
     * @return 网络故障保修反馈
     */
    @Override
    public SsNetworkFaultRepairApplicationDemo selectSsNetworkFaultRepairApplicationDemoById(Long id)
    {
        return ssNetworkFaultRepairApplicationDemoMapper.selectSsNetworkFaultRepairApplicationDemoById(id);
    }

    /**
     * 查询网络故障保修反馈列表
     * 
     * @param ssNetworkFaultRepairApplicationDemo 网络故障保修反馈
     * @return 网络故障保修反馈
     */
    @Override
    public List<SsNetworkFaultRepairApplicationDemo> selectSsNetworkFaultRepairApplicationDemoList(SsNetworkFaultRepairApplicationDemo ssNetworkFaultRepairApplicationDemo)
    {
        return ssNetworkFaultRepairApplicationDemoMapper.selectSsNetworkFaultRepairApplicationDemoList(ssNetworkFaultRepairApplicationDemo);
    }

    /**
     * 新增网络故障保修反馈
     * 
     * @param ssNetworkFaultRepairApplicationDemo 网络故障保修反馈
     * @return 结果
     */
    @Override
    public int insertSsNetworkFaultRepairApplicationDemo(SsNetworkFaultRepairApplicationDemo ssNetworkFaultRepairApplicationDemo)
    {
        return ssNetworkFaultRepairApplicationDemoMapper.insertSsNetworkFaultRepairApplicationDemo(ssNetworkFaultRepairApplicationDemo);
    }

    /**
     * 修改网络故障保修反馈
     * 
     * @param ssNetworkFaultRepairApplicationDemo 网络故障保修反馈
     * @return 结果
     */
    @Override
    public int updateSsNetworkFaultRepairApplicationDemo(SsNetworkFaultRepairApplicationDemo ssNetworkFaultRepairApplicationDemo)
    {
        return ssNetworkFaultRepairApplicationDemoMapper.updateSsNetworkFaultRepairApplicationDemo(ssNetworkFaultRepairApplicationDemo);
    }

    /**
     * 批量删除网络故障保修反馈
     * 
     * @param ids 需要删除的网络故障保修反馈主键
     * @return 结果
     */
    @Override
    public int deleteSsNetworkFaultRepairApplicationDemoByIds(Long[] ids)
    {
        return ssNetworkFaultRepairApplicationDemoMapper.deleteSsNetworkFaultRepairApplicationDemoByIds(ids);
    }

    /**
     * 删除网络故障保修反馈信息
     * 
     * @param id 网络故障保修反馈主键
     * @return 结果
     */
    @Override
    public int deleteSsNetworkFaultRepairApplicationDemoById(Long id)
    {
        return ssNetworkFaultRepairApplicationDemoMapper.deleteSsNetworkFaultRepairApplicationDemoById(id);
    }
}
