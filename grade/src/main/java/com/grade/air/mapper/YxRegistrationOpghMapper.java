package com.grade.air.mapper;

import java.util.List;
import com.grade.air.domain.YxRegistrationOpgh;

/**
 * 预报到登记Mapper接口
 * 
 * @author l
 * @date 2023-06-04
 */
public interface YxRegistrationOpghMapper 
{
    /**
     * 查询预报到登记
     * 
     * @param id 预报到登记主键
     * @return 预报到登记
     */
    public YxRegistrationOpgh selectYxRegistrationOpghById(Long id);

    /**
     * 查询预报到登记列表
     * 
     * @param yxRegistrationOpgh 预报到登记
     * @return 预报到登记集合
     */
    public List<YxRegistrationOpgh> selectYxRegistrationOpghList(YxRegistrationOpgh yxRegistrationOpgh);

    /**
     * 新增预报到登记
     * 
     * @param yxRegistrationOpgh 预报到登记
     * @return 结果
     */
    public int insertYxRegistrationOpgh(YxRegistrationOpgh yxRegistrationOpgh);

    /**
     * 修改预报到登记
     * 
     * @param yxRegistrationOpgh 预报到登记
     * @return 结果
     */
    public int updateYxRegistrationOpgh(YxRegistrationOpgh yxRegistrationOpgh);

    /**
     * 删除预报到登记
     * 
     * @param id 预报到登记主键
     * @return 结果
     */
    public int deleteYxRegistrationOpghById(Long id);

    /**
     * 批量删除预报到登记
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteYxRegistrationOpghByIds(Long[] ids);
}
