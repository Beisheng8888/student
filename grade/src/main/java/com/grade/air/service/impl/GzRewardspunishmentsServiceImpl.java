package com.grade.air.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.grade.air.mapper.GzRewardspunishmentsMapper;
import com.grade.air.domain.GzRewardspunishments;
import com.grade.air.service.IGzRewardspunishmentsService;

/**
 * 学员奖惩Service业务层处理
 * 
 * @author l
 * @date 2023-06-04
 */
@Service
public class GzRewardspunishmentsServiceImpl implements IGzRewardspunishmentsService 
{
    @Autowired
    private GzRewardspunishmentsMapper gzRewardspunishmentsMapper;

    /**
     * 查询学员奖惩
     * 
     * @param recordID 学员奖惩主键
     * @return 学员奖惩
     */
    @Override
    public GzRewardspunishments selectGzRewardspunishmentsByRecordID(Long recordID)
    {
        return gzRewardspunishmentsMapper.selectGzRewardspunishmentsByRecordID(recordID);
    }

    /**
     * 查询学员奖惩列表
     * 
     * @param gzRewardspunishments 学员奖惩
     * @return 学员奖惩
     */
    @Override
    @DataScope(userAlias = "recuit")
    public List<GzRewardspunishments> selectGzRewardspunishmentsList(GzRewardspunishments gzRewardspunishments)
    {
        return gzRewardspunishmentsMapper.selectGzRewardspunishmentsList(gzRewardspunishments);
    }

    /**
     * 新增学员奖惩
     * 
     * @param gzRewardspunishments 学员奖惩
     * @return 结果
     */
    @Override
    public int insertGzRewardspunishments(GzRewardspunishments gzRewardspunishments)
    {
        return gzRewardspunishmentsMapper.insertGzRewardspunishments(gzRewardspunishments);
    }

    /**
     * 修改学员奖惩
     * 
     * @param gzRewardspunishments 学员奖惩
     * @return 结果
     */
    @Override
    public int updateGzRewardspunishments(GzRewardspunishments gzRewardspunishments)
    {
        return gzRewardspunishmentsMapper.updateGzRewardspunishments(gzRewardspunishments);
    }

    /**
     * 批量删除学员奖惩
     * 
     * @param recordIDs 需要删除的学员奖惩主键
     * @return 结果
     */
    @Override
    public int deleteGzRewardspunishmentsByRecordIDs(Long[] recordIDs)
    {
        return gzRewardspunishmentsMapper.deleteGzRewardspunishmentsByRecordIDs(recordIDs);
    }

    /**
     * 删除学员奖惩信息
     * 
     * @param recordID 学员奖惩主键
     * @return 结果
     */
    @Override
    public int deleteGzRewardspunishmentsByRecordID(Long recordID)
    {
        return gzRewardspunishmentsMapper.deleteGzRewardspunishmentsByRecordID(recordID);
    }
}
