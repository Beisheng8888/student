package com.grade.air.service;

import java.util.List;
import com.grade.air.domain.YxRegistration;

/**
 * 预报到登记反馈Service接口
 * 
 * @author l
 * @date 2023-06-04
 */
public interface IYxRegistrationService 
{
    /**
     * 查询预报到登记反馈
     * 
     * @param registrationID 预报到登记反馈主键
     * @return 预报到登记反馈
     */
    public YxRegistration selectYxRegistrationByRegistrationID(Long registrationID);

    /**
     * 查询预报到登记反馈列表
     * 
     * @param yxRegistration 预报到登记反馈
     * @return 预报到登记反馈集合
     */
    public List<YxRegistration> selectYxRegistrationList(YxRegistration yxRegistration);

    /**
     * 新增预报到登记反馈
     * 
     * @param yxRegistration 预报到登记反馈
     * @return 结果
     */
    public int insertYxRegistration(YxRegistration yxRegistration);

    /**
     * 修改预报到登记反馈
     * 
     * @param yxRegistration 预报到登记反馈
     * @return 结果
     */
    public int updateYxRegistration(YxRegistration yxRegistration);

    /**
     * 批量删除预报到登记反馈
     * 
     * @param registrationIDs 需要删除的预报到登记反馈主键集合
     * @return 结果
     */
    public int deleteYxRegistrationByRegistrationIDs(Long[] registrationIDs);

    /**
     * 删除预报到登记反馈信息
     * 
     * @param registrationID 预报到登记反馈主键
     * @return 结果
     */
    public int deleteYxRegistrationByRegistrationID(Long registrationID);
}
