package com.grade.air.mapper;

import java.util.List;
import com.grade.air.domain.LqAwardsandpenalties;

/**
 * 奖惩通告Mapper接口
 * 
 * @author l
 * @date 2023-06-04
 */
public interface LqAwardsandpenaltiesMapper 
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
     * 删除奖惩通告
     * 
     * @param studentID 奖惩通告主键
     * @return 结果
     */
    public int deleteLqAwardsandpenaltiesByStudentID(Long studentID);

    /**
     * 批量删除奖惩通告
     * 
     * @param studentIDs 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLqAwardsandpenaltiesByStudentIDs(Long[] studentIDs);
}
