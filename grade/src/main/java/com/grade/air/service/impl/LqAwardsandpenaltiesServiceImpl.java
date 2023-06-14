package com.grade.air.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.grade.air.mapper.LqAwardsandpenaltiesMapper;
import com.grade.air.domain.LqAwardsandpenalties;
import com.grade.air.service.ILqAwardsandpenaltiesService;

/**
 * 奖惩通告Service业务层处理
 * 
 * @author l
 * @date 2023-06-04
 */
@Service
public class LqAwardsandpenaltiesServiceImpl implements ILqAwardsandpenaltiesService 
{
    @Autowired
    private LqAwardsandpenaltiesMapper lqAwardsandpenaltiesMapper;

    /**
     * 查询奖惩通告
     * 
     * @param studentID 奖惩通告主键
     * @return 奖惩通告
     */
    @Override
    public LqAwardsandpenalties selectLqAwardsandpenaltiesByStudentID(Long studentID)
    {
        return lqAwardsandpenaltiesMapper.selectLqAwardsandpenaltiesByStudentID(studentID);
    }

    /**
     * 查询奖惩通告列表
     * 
     * @param lqAwardsandpenalties 奖惩通告
     * @return 奖惩通告
     */
    @Override
    public List<LqAwardsandpenalties> selectLqAwardsandpenaltiesList(LqAwardsandpenalties lqAwardsandpenalties)
    {
        return lqAwardsandpenaltiesMapper.selectLqAwardsandpenaltiesList(lqAwardsandpenalties);
    }

    /**
     * 新增奖惩通告
     * 
     * @param lqAwardsandpenalties 奖惩通告
     * @return 结果
     */
    @Override
    public int insertLqAwardsandpenalties(LqAwardsandpenalties lqAwardsandpenalties)
    {
        return lqAwardsandpenaltiesMapper.insertLqAwardsandpenalties(lqAwardsandpenalties);
    }

    /**
     * 修改奖惩通告
     * 
     * @param lqAwardsandpenalties 奖惩通告
     * @return 结果
     */
    @Override
    public int updateLqAwardsandpenalties(LqAwardsandpenalties lqAwardsandpenalties)
    {
        return lqAwardsandpenaltiesMapper.updateLqAwardsandpenalties(lqAwardsandpenalties);
    }

    /**
     * 批量删除奖惩通告
     * 
     * @param studentIDs 需要删除的奖惩通告主键
     * @return 结果
     */
    @Override
    public int deleteLqAwardsandpenaltiesByStudentIDs(Long[] studentIDs)
    {
        return lqAwardsandpenaltiesMapper.deleteLqAwardsandpenaltiesByStudentIDs(studentIDs);
    }

    /**
     * 删除奖惩通告信息
     * 
     * @param studentID 奖惩通告主键
     * @return 结果
     */
    @Override
    public int deleteLqAwardsandpenaltiesByStudentID(Long studentID)
    {
        return lqAwardsandpenaltiesMapper.deleteLqAwardsandpenaltiesByStudentID(studentID);
    }
}
