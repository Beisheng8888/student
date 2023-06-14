package com.grade.air.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.grade.air.mapper.YxOpRegisMapper;
import com.grade.air.domain.YxOpRegis;
import com.grade.air.service.IYxOpRegisService;

/**
 * 行政报到Service业务层处理
 * 
 * @author l
 * @date 2023-06-04
 */
@Service
public class YxOpRegisServiceImpl implements IYxOpRegisService 
{
    @Autowired
    private YxOpRegisMapper yxOpRegisMapper;

    /**
     * 查询行政报到
     * 
     * @param id 行政报到主键
     * @return 行政报到
     */
    @Override
    public YxOpRegis selectYxOpRegisById(Long id)
    {
        return yxOpRegisMapper.selectYxOpRegisById(id);
    }

    /**
     * 查询行政报到列表
     * 
     * @param yxOpRegis 行政报到
     * @return 行政报到
     */
    @Override
    @DataScope(userAlias = "recuit")
    public List<YxOpRegis> selectYxOpRegisList(YxOpRegis yxOpRegis)
    {
        return yxOpRegisMapper.selectYxOpRegisList(yxOpRegis);
    }

    /**
     * 新增行政报到
     * 
     * @param yxOpRegis 行政报到
     * @return 结果
     */
    @Override
    public int insertYxOpRegis(YxOpRegis yxOpRegis)
    {
        return yxOpRegisMapper.insertYxOpRegis(yxOpRegis);
    }

    /**
     * 修改行政报到
     * 
     * @param yxOpRegis 行政报到
     * @return 结果
     */
    @Override
    public int updateYxOpRegis(YxOpRegis yxOpRegis)
    {
        return yxOpRegisMapper.updateYxOpRegis(yxOpRegis);
    }

    /**
     * 批量删除行政报到
     * 
     * @param ids 需要删除的行政报到主键
     * @return 结果
     */
    @Override
    public int deleteYxOpRegisByIds(Long[] ids)
    {
        return yxOpRegisMapper.deleteYxOpRegisByIds(ids);
    }

    /**
     * 删除行政报到信息
     * 
     * @param id 行政报到主键
     * @return 结果
     */
    @Override
    public int deleteYxOpRegisById(Long id)
    {
        return yxOpRegisMapper.deleteYxOpRegisById(id);
    }
}
