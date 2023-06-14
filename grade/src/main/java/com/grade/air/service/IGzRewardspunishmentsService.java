package com.grade.air.service;

import java.util.List;
import com.grade.air.domain.GzRewardspunishments;

/**
 * 学员奖惩Service接口
 * 
 * @author l
 * @date 2023-06-04
 */
public interface IGzRewardspunishmentsService 
{
    /**
     * 查询学员奖惩
     * 
     * @param recordID 学员奖惩主键
     * @return 学员奖惩
     */
    public GzRewardspunishments selectGzRewardspunishmentsByRecordID(Long recordID);

    /**
     * 查询学员奖惩列表
     * 
     * @param gzRewardspunishments 学员奖惩
     * @return 学员奖惩集合
     */
    public List<GzRewardspunishments> selectGzRewardspunishmentsList(GzRewardspunishments gzRewardspunishments);

    /**
     * 新增学员奖惩
     * 
     * @param gzRewardspunishments 学员奖惩
     * @return 结果
     */
    public int insertGzRewardspunishments(GzRewardspunishments gzRewardspunishments);

    /**
     * 修改学员奖惩
     * 
     * @param gzRewardspunishments 学员奖惩
     * @return 结果
     */
    public int updateGzRewardspunishments(GzRewardspunishments gzRewardspunishments);

    /**
     * 批量删除学员奖惩
     * 
     * @param recordIDs 需要删除的学员奖惩主键集合
     * @return 结果
     */
    public int deleteGzRewardspunishmentsByRecordIDs(Long[] recordIDs);

    /**
     * 删除学员奖惩信息
     * 
     * @param recordID 学员奖惩主键
     * @return 结果
     */
    public int deleteGzRewardspunishmentsByRecordID(Long recordID);
}
