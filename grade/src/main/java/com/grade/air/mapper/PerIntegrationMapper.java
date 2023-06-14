package com.grade.air.mapper;

import java.util.List;
import com.grade.air.domain.PerIntegration;

/**
 * 数据集成Mapper接口
 * 
 * @author l
 * @date 2023-06-04
 */
public interface PerIntegrationMapper 
{
    /**
     * 查询数据集成
     * 
     * @param id 数据集成主键
     * @return 数据集成
     */
    public PerIntegration selectPerIntegrationById(Long id);

    /**
     * 查询数据集成列表
     * 
     * @param perIntegration 数据集成
     * @return 数据集成集合
     */
    public List<PerIntegration> selectPerIntegrationList(PerIntegration perIntegration);

    /**
     * 新增数据集成
     * 
     * @param perIntegration 数据集成
     * @return 结果
     */
    public int insertPerIntegration(PerIntegration perIntegration);

    /**
     * 修改数据集成
     * 
     * @param perIntegration 数据集成
     * @return 结果
     */
    public int updatePerIntegration(PerIntegration perIntegration);

    /**
     * 删除数据集成
     * 
     * @param id 数据集成主键
     * @return 结果
     */
    public int deletePerIntegrationById(Long id);

    /**
     * 批量删除数据集成
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePerIntegrationByIds(Long[] ids);
}
