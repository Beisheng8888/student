package com.grade.air.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.grade.air.mapper.YxRegistrationOpghMapper;
import com.grade.air.domain.YxRegistrationOpgh;
import com.grade.air.service.IYxRegistrationOpghService;

/**
 * 预报到登记Service业务层处理
 * 
 * @author l
 * @date 2023-06-04
 */
@Service
public class YxRegistrationOpghServiceImpl implements IYxRegistrationOpghService 
{
    @Autowired
    private YxRegistrationOpghMapper yxRegistrationOpghMapper;

    /**
     * 查询预报到登记
     * 
     * @param id 预报到登记主键
     * @return 预报到登记
     */
    @Override
    public YxRegistrationOpgh selectYxRegistrationOpghById(Long id)
    {
        return yxRegistrationOpghMapper.selectYxRegistrationOpghById(id);
    }

    /**
     * 查询预报到登记列表
     * 
     * @param yxRegistrationOpgh 预报到登记
     * @return 预报到登记
     */
    @Override
    @DataScope(userAlias = "recuit")
    public List<YxRegistrationOpgh> selectYxRegistrationOpghList(YxRegistrationOpgh yxRegistrationOpgh)
    {
        return yxRegistrationOpghMapper.selectYxRegistrationOpghList(yxRegistrationOpgh);
    }

    /**
     * 新增预报到登记
     * 
     * @param yxRegistrationOpgh 预报到登记
     * @return 结果
     */
    @Override
    public int insertYxRegistrationOpgh(YxRegistrationOpgh yxRegistrationOpgh)
    {
        return yxRegistrationOpghMapper.insertYxRegistrationOpgh(yxRegistrationOpgh);
    }

    /**
     * 修改预报到登记
     * 
     * @param yxRegistrationOpgh 预报到登记
     * @return 结果
     */
    @Override
    public int updateYxRegistrationOpgh(YxRegistrationOpgh yxRegistrationOpgh)
    {
        return yxRegistrationOpghMapper.updateYxRegistrationOpgh(yxRegistrationOpgh);
    }

    /**
     * 批量删除预报到登记
     * 
     * @param ids 需要删除的预报到登记主键
     * @return 结果
     */
    @Override
    public int deleteYxRegistrationOpghByIds(Long[] ids)
    {
        return yxRegistrationOpghMapper.deleteYxRegistrationOpghByIds(ids);
    }

    /**
     * 删除预报到登记信息
     * 
     * @param id 预报到登记主键
     * @return 结果
     */
    @Override
    public int deleteYxRegistrationOpghById(Long id)
    {
        return yxRegistrationOpghMapper.deleteYxRegistrationOpghById(id);
    }
}
