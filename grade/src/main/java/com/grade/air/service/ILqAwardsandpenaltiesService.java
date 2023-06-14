package com.grade.air.service;

import java.util.List;
import com.grade.air.domain.LqAwardsandpenalties;

/**
 * 奖惩通告Service接口
 * 
 * @author l
 * @date 2023-06-04
 */
public interface ILqAwardsandpenaltiesService 
{
    /**
     * 查询奖惩通告
     * 
     * @param studentID 奖惩通告主键
     * @return 奖惩通告
     */
    public LqAwardsandpenalties selectLqAwardsandpenaltiesByStudentID(Long studentID);

    /**
     * 查询奖惩通告列表
     * 
     * @param lqAwardsandpenalties 奖惩通告
     * @return 奖惩通告集合
     */
    public List<LqAwardsandpenalties> selectLqAwardsandpenaltiesList(LqAwardsandpenalties lqAwardsandpenalties);

    /**
     * 新增奖惩通告
     * 
     * @param lqAwardsandpenalties 奖惩通告
     * @return 结果
     */
    public int insertLqAwardsandpenalties(LqAwardsandpenalties lqAwardsandpenalties);

    /**
     * 修改奖惩通告
     * 
     * @param lqAwardsandpenalties 奖惩通告
     * @return 结果
     */
    public int updateLqAwardsandpenalties(LqAwardsandpenalties lqAwardsandpenalties);

    /**
     * 批量删除奖惩通告
     * 
     * @param studentIDs 需要删除的奖惩通告主键集合
     * @return 结果
     */
    public int deleteLqAwardsandpenaltiesByStudentIDs(Long[] studentIDs);

    /**
     * 删除奖惩通告信息
     * 
     * @param studentID 奖惩通告主键
     * @return 结果
     */
    public int deleteLqAwardsandpenaltiesByStudentID(Long studentID);
}
