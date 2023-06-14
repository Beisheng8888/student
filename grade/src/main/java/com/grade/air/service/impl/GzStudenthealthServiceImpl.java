package com.grade.air.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.grade.air.mapper.GzStudenthealthMapper;
import com.grade.air.domain.GzStudenthealth;
import com.grade.air.service.IGzStudenthealthService;

/**
 * 学员健康Service业务层处理
 * 
 * @author l
 * @date 2023-06-04
 */
@Service
public class GzStudenthealthServiceImpl implements IGzStudenthealthService 
{
    @Autowired
    private GzStudenthealthMapper gzStudenthealthMapper;

    /**
     * 查询学员健康
     * 
     * @param recordID 学员健康主键
     * @return 学员健康
     */
    @Override
    public GzStudenthealth selectGzStudenthealthByRecordID(Long recordID)
    {
        return gzStudenthealthMapper.selectGzStudenthealthByRecordID(recordID);
    }

    /**
     * 查询学员健康列表
     * 
     * @param gzStudenthealth 学员健康
     * @return 学员健康
     */
    @Override
    @DataScope(userAlias = "recuit")
    public List<GzStudenthealth> selectGzStudenthealthList(GzStudenthealth gzStudenthealth)
    {
        return gzStudenthealthMapper.selectGzStudenthealthList(gzStudenthealth);
    }

    /**
     * 新增学员健康
     * 
     * @param gzStudenthealth 学员健康
     * @return 结果
     */
    @Override
    public int insertGzStudenthealth(GzStudenthealth gzStudenthealth)
    {
        return gzStudenthealthMapper.insertGzStudenthealth(gzStudenthealth);
    }

    /**
     * 修改学员健康
     * 
     * @param gzStudenthealth 学员健康
     * @return 结果
     */
    @Override
    public int updateGzStudenthealth(GzStudenthealth gzStudenthealth)
    {
        return gzStudenthealthMapper.updateGzStudenthealth(gzStudenthealth);
    }

    /**
     * 批量删除学员健康
     * 
     * @param recordIDs 需要删除的学员健康主键
     * @return 结果
     */
    @Override
    public int deleteGzStudenthealthByRecordIDs(Long[] recordIDs)
    {
        return gzStudenthealthMapper.deleteGzStudenthealthByRecordIDs(recordIDs);
    }

    /**
     * 删除学员健康信息
     * 
     * @param recordID 学员健康主键
     * @return 结果
     */
    @Override
    public int deleteGzStudenthealthByRecordID(Long recordID)
    {
        return gzStudenthealthMapper.deleteGzStudenthealthByRecordID(recordID);
    }
}
