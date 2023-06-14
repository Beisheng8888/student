package com.grade.air.mapper;

import java.util.List;
import com.grade.air.domain.GzRewardspunishments;

/**
 * 学员奖惩Mapper接口
 * 
 * @author l
 * @date 2023-06-04
 */
public interface GzRewardspunishmentsMapper 
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
     * 删除学员奖惩
     * 
     * @param recordID 学员奖惩主键
     * @return 结果
     */
    public int deleteGzRewardspunishmentsByRecordID(Long recordID);

    /**
     * 批量删除学员奖惩
     * 
     * @param recordIDs 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteGzRewardspunishmentsByRecordIDs(Long[] recordIDs);
}
