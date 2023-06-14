package com.grade.air.service;

import java.util.List;
import com.grade.air.domain.LixiaoDepartureapplications;

/**
 * 离校申请Service接口
 * 
 * @author l
 * @date 2023-06-04
 */
public interface ILixiaoDepartureapplicationsService 
{
    /**
     * 查询离校申请
     * 
     * @param applicationID 离校申请主键
     * @return 离校申请
     */
    public LixiaoDepartureapplications selectLixiaoDepartureapplicationsByApplicationID(Long applicationID);

    /**
     * 查询离校申请列表
     * 
     * @param lixiaoDepartureapplications 离校申请
     * @return 离校申请集合
     */
    public List<LixiaoDepartureapplications> selectLixiaoDepartureapplicationsList(LixiaoDepartureapplications lixiaoDepartureapplications);

    /**
     * 新增离校申请
     * 
     * @param lixiaoDepartureapplications 离校申请
     * @return 结果
     */
    public int insertLixiaoDepartureapplications(LixiaoDepartureapplications lixiaoDepartureapplications);

    /**
     * 修改离校申请
     * 
     * @param lixiaoDepartureapplications 离校申请
     * @return 结果
     */
    public int updateLixiaoDepartureapplications(LixiaoDepartureapplications lixiaoDepartureapplications);

    /**
     * 批量删除离校申请
     * 
     * @param applicationIDs 需要删除的离校申请主键集合
     * @return 结果
     */
    public int deleteLixiaoDepartureapplicationsByApplicationIDs(Long[] applicationIDs);

    /**
     * 删除离校申请信息
     * 
     * @param applicationID 离校申请主键
     * @return 结果
     */
    public int deleteLixiaoDepartureapplicationsByApplicationID(Long applicationID);
}
