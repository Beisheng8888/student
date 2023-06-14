package com.grade.air.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.grade.air.mapper.LqDeryMapper;
import com.grade.air.domain.LqDery;
import com.grade.air.service.ILqDeryService;

/**
 * 学籍调动结果Service业务层处理
 * 
 * @author l
 * @date 2023-06-04
 */
@Service
public class LqDeryServiceImpl implements ILqDeryService 
{
    @Autowired
    private LqDeryMapper lqDeryMapper;

    /**
     * 查询学籍调动结果
     * 
     * @param id 学籍调动结果主键
     * @return 学籍调动结果
     */
    @Override
    public LqDery selectLqDeryById(Long id)
    {
        return lqDeryMapper.selectLqDeryById(id);
    }

    /**
     * 查询学籍调动结果列表
     * 
     * @param lqDery 学籍调动结果
     * @return 学籍调动结果
     */
    @Override
    @DataScope(userAlias = "recuit")
    public List<LqDery> selectLqDeryList(LqDery lqDery)
    {
        return lqDeryMapper.selectLqDeryList(lqDery);
    }

    /**
     * 新增学籍调动结果
     * 
     * @param lqDery 学籍调动结果
     * @return 结果
     */
    @Override
    public int insertLqDery(LqDery lqDery)
    {
        return lqDeryMapper.insertLqDery(lqDery);
    }

    /**
     * 修改学籍调动结果
     * 
     * @param lqDery 学籍调动结果
     * @return 结果
     */
    @Override
    public int updateLqDery(LqDery lqDery)
    {
        return lqDeryMapper.updateLqDery(lqDery);
    }

    /**
     * 批量删除学籍调动结果
     * 
     * @param ids 需要删除的学籍调动结果主键
     * @return 结果
     */
    @Override
    public int deleteLqDeryByIds(Long[] ids)
    {
        return lqDeryMapper.deleteLqDeryByIds(ids);
    }

    /**
     * 删除学籍调动结果信息
     * 
     * @param id 学籍调动结果主键
     * @return 结果
     */
    @Override
    public int deleteLqDeryById(Long id)
    {
        return lqDeryMapper.deleteLqDeryById(id);
    }
}
