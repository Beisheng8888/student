package com.grade.air.mapper;

import java.util.List;
import com.grade.air.domain.YxOpRegis;

/**
 * 行政报到Mapper接口
 * 
 * @author l
 * @date 2023-06-04
 */
public interface YxOpRegisMapper 
{
    /**
     * 查询行政报到
     * 
     * @param id 行政报到主键
     * @return 行政报到
     */
    public YxOpRegis selectYxOpRegisById(Long id);

    /**
     * 查询行政报到列表
     * 
     * @param yxOpRegis 行政报到
     * @return 行政报到集合
     */
    public List<YxOpRegis> selectYxOpRegisList(YxOpRegis yxOpRegis);

    /**
     * 新增行政报到
     * 
     * @param yxOpRegis 行政报到
     * @return 结果
     */
    public int insertYxOpRegis(YxOpRegis yxOpRegis);

    /**
     * 修改行政报到
     * 
     * @param yxOpRegis 行政报到
     * @return 结果
     */
    public int updateYxOpRegis(YxOpRegis yxOpRegis);

    /**
     * 删除行政报到
     * 
     * @param id 行政报到主键
     * @return 结果
     */
    public int deleteYxOpRegisById(Long id);

    /**
     * 批量删除行政报到
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteYxOpRegisByIds(Long[] ids);
}
