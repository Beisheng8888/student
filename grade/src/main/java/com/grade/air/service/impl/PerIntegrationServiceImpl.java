package com.grade.air.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.grade.air.mapper.PerIntegrationMapper;
import com.grade.air.domain.PerIntegration;
import com.grade.air.service.IPerIntegrationService;

/**
 * 数据集成Service业务层处理
 * 
 * @author l
 * @date 2023-06-04
 */
@Service
public class PerIntegrationServiceImpl implements IPerIntegrationService 
{
    @Autowired
    private PerIntegrationMapper perIntegrationMapper;

    /**
     * 查询数据集成
     * 
     * @param id 数据集成主键
     * @return 数据集成
     */
    @Override
    public PerIntegration selectPerIntegrationById(Long id)
    {
        return perIntegrationMapper.selectPerIntegrationById(id);
    }

    /**
     * 查询数据集成列表
     * 
     * @param perIntegration 数据集成
     * @return 数据集成
     */
    @Override
    public List<PerIntegration> selectPerIntegrationList(PerIntegration perIntegration)
    {
        return perIntegrationMapper.selectPerIntegrationList(perIntegration);
    }

    /**
     * 新增数据集成
     * 
     * @param perIntegration 数据集成
     * @return 结果
     */
    @Override
    public int insertPerIntegration(PerIntegration perIntegration)
    {
        return perIntegrationMapper.insertPerIntegration(perIntegration);
    }

    /**
     * 修改数据集成
     * 
     * @param perIntegration 数据集成
     * @return 结果
     */
    @Override
    public int updatePerIntegration(PerIntegration perIntegration)
    {
        return perIntegrationMapper.updatePerIntegration(perIntegration);
    }

    /**
     * 批量删除数据集成
     * 
     * @param ids 需要删除的数据集成主键
     * @return 结果
     */
    @Override
    public int deletePerIntegrationByIds(Long[] ids)
    {
        return perIntegrationMapper.deletePerIntegrationByIds(ids);
    }

    /**
     * 删除数据集成信息
     * 
     * @param id 数据集成主键
     * @return 结果
     */
    @Override
    public int deletePerIntegrationById(Long id)
    {
        return perIntegrationMapper.deletePerIntegrationById(id);
    }
}
