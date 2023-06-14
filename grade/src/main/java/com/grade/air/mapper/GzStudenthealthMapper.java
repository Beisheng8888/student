package com.grade.air.mapper;

import java.util.List;
import com.grade.air.domain.GzStudenthealth;

/**
 * 学员健康Mapper接口
 * 
 * @author l
 * @date 2023-06-04
 */
public interface GzStudenthealthMapper 
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
     * 删除学员健康
     * 
     * @param recordID 学员健康主键
     * @return 结果
     */
    public int deleteGzStudenthealthByRecordID(Long recordID);

    /**
     * 批量删除学员健康
     * 
     * @param recordIDs 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteGzStudenthealthByRecordIDs(Long[] recordIDs);
}
