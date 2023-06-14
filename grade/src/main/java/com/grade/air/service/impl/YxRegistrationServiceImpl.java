package com.grade.air.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.grade.air.mapper.YxRegistrationMapper;
import com.grade.air.domain.YxRegistration;
import com.grade.air.service.IYxRegistrationService;

/**
 * 预报到登记反馈Service业务层处理
 * 
 * @author l
 * @date 2023-06-04
 */
@Service
public class YxRegistrationServiceImpl implements IYxRegistrationService 
{
    @Autowired
    private YxRegistrationMapper yxRegistrationMapper;

    /**
     * 查询预报到登记反馈
     * 
     * @param registrationID 预报到登记反馈主键
     * @return 预报到登记反馈
     */
    @Override
    public YxRegistration selectYxRegistrationByRegistrationID(Long registrationID)
    {
        return yxRegistrationMapper.selectYxRegistrationByRegistrationID(registrationID);
    }

    /**
     * 查询预报到登记反馈列表
     * 
     * @param yxRegistration 预报到登记反馈
     * @return 预报到登记反馈
     */
    @Override
    @DataScope(userAlias = "recuit")
    public List<YxRegistration> selectYxRegistrationList(YxRegistration yxRegistration)
    {
        return yxRegistrationMapper.selectYxRegistrationList(yxRegistration);
    }

    /**
     * 新增预报到登记反馈
     * 
     * @param yxRegistration 预报到登记反馈
     * @return 结果
     */
    @Override
    public int insertYxRegistration(YxRegistration yxRegistration)
    {
        return yxRegistrationMapper.insertYxRegistration(yxRegistration);
    }

    /**
     * 修改预报到登记反馈
     * 
     * @param yxRegistration 预报到登记反馈
     * @return 结果
     */
    @Override
    public int updateYxRegistration(YxRegistration yxRegistration)
    {
        return yxRegistrationMapper.updateYxRegistration(yxRegistration);
    }

    /**
     * 批量删除预报到登记反馈
     * 
     * @param registrationIDs 需要删除的预报到登记反馈主键
     * @return 结果
     */
    @Override
    public int deleteYxRegistrationByRegistrationIDs(Long[] registrationIDs)
    {
        return yxRegistrationMapper.deleteYxRegistrationByRegistrationIDs(registrationIDs);
    }

    /**
     * 删除预报到登记反馈信息
     * 
     * @param registrationID 预报到登记反馈主键
     * @return 结果
     */
    @Override
    public int deleteYxRegistrationByRegistrationID(Long registrationID)
    {
        return yxRegistrationMapper.deleteYxRegistrationByRegistrationID(registrationID);
    }
}
