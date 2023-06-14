package com.grade.air.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.grade.air.mapper.LqXuejiMapper;
import com.grade.air.domain.LqXueji;
import com.grade.air.service.ILqXuejiService;

/**
 * 学籍调动Service业务层处理
 * 
 * @author l
 * @date 2023-06-04
 */
@Service
public class LqXuejiServiceImpl implements ILqXuejiService 
{
    @Autowired
    private LqXuejiMapper lqXuejiMapper;

    /**
     * 查询学籍调动
     * 
     * @param id 学籍调动主键
     * @return 学籍调动
     */
    @Override
    public LqXueji selectLqXuejiById(Long id)
    {
        return lqXuejiMapper.selectLqXuejiById(id);
    }

    /**
     * 查询学籍调动列表
     * 
     * @param lqXueji 学籍调动
     * @return 学籍调动
     */
    @Override
    @DataScope(userAlias = "recuit")
    public List<LqXueji> selectLqXuejiList(LqXueji lqXueji)
    {
        return lqXuejiMapper.selectLqXuejiList(lqXueji);
    }

    /**
     * 新增学籍调动
     * 
     * @param lqXueji 学籍调动
     * @return 结果
     */
    @Override
    public int insertLqXueji(LqXueji lqXueji)
    {
        return lqXuejiMapper.insertLqXueji(lqXueji);
    }

    /**
     * 修改学籍调动
     * 
     * @param lqXueji 学籍调动
     * @return 结果
     */
    @Override
    public int updateLqXueji(LqXueji lqXueji)
    {
        return lqXuejiMapper.updateLqXueji(lqXueji);
    }

    /**
     * 批量删除学籍调动
     * 
     * @param ids 需要删除的学籍调动主键
     * @return 结果
     */
    @Override
    public int deleteLqXuejiByIds(Long[] ids)
    {
        return lqXuejiMapper.deleteLqXuejiByIds(ids);
    }

    /**
     * 删除学籍调动信息
     * 
     * @param id 学籍调动主键
     * @return 结果
     */
    @Override
    public int deleteLqXuejiById(Long id)
    {
        return lqXuejiMapper.deleteLqXuejiById(id);
    }
}
