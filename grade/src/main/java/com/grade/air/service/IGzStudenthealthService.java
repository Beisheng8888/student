package com.grade.air.service;

import java.util.List;
import com.grade.air.domain.GzStudenthealth;

/**
 * 学员健康Service接口
 * 
 * @author l
 * @date 2023-06-04
 */
public interface IGzStudenthealthService 
{
    /**
     * 查询学员健康
     * 
     * @param recordID 学员健康主键
     * @return 学员健康
     */
    public GzStudenthealth selectGzStudenthealthByRecordID(Long recordID);

    /**
     * 查询学员健康列表
     * 
     * @param gzStudenthealth 学员健康
     * @return 学员健康集合
     */
    public List<GzStudenthealth> selectGzStudenthealthList(GzStudenthealth gzStudenthealth);

    /**
     * 新增学员健康
     * 
     * @param gzStudenthealth 学员健康
     * @return 结果
     */
    public int insertGzStudenthealth(GzStudenthealth gzStudenthealth);

    /**
     * 修改学员健康
     * 
     * @param gzStudenthealth 学员健康
     * @return 结果
     */
    public int updateGzStudenthealth(GzStudenthealth gzStudenthealth);

    /**
     * 批量删除学员健康
     * 
     * @param recordIDs 需要删除的学员健康主键集合
     * @return 结果
     */
    public int deleteGzStudenthealthByRecordIDs(Long[] recordIDs);

    /**
     * 删除学员健康信息
     * 
     * @param recordID 学员健康主键
     * @return 结果
     */
    public int deleteGzStudenthealthByRecordID(Long recordID);
}
