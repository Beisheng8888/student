package com.grade.air.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.grade.air.mapper.LqGerendanganMapper;
import com.grade.air.domain.LqGerendangan;
import com.grade.air.service.ILqGerendanganService;

/**
 * 学生档案维护Service业务层处理
 * 
 * @author l
 * @date 2023-06-04
 */
@Service
public class LqGerendanganServiceImpl implements ILqGerendanganService 
{
    @Autowired
    private LqGerendanganMapper lqGerendanganMapper;

    /**
     * 查询学生档案维护
     * 
     * @param id 学生档案维护主键
     * @return 学生档案维护
     */
    @Override
    public LqGerendangan selectLqGerendanganById(Long id)
    {
        return lqGerendanganMapper.selectLqGerendanganById(id);
    }

    /**
     * 查询学生档案维护列表
     * 
     * @param lqGerendangan 学生档案维护
     * @return 学生档案维护
     */
    @Override
    @DataScope(userAlias = "recuit")
    public List<LqGerendangan> selectLqGerendanganList(LqGerendangan lqGerendangan)
    {
        return lqGerendanganMapper.selectLqGerendanganList(lqGerendangan);
    }

    /**
     * 新增学生档案维护
     * 
     * @param lqGerendangan 学生档案维护
     * @return 结果
     */
    @Override
    public int insertLqGerendangan(LqGerendangan lqGerendangan)
    {
        return lqGerendanganMapper.insertLqGerendangan(lqGerendangan);
    }

    /**
     * 修改学生档案维护
     * 
     * @param lqGerendangan 学生档案维护
     * @return 结果
     */
    @Override
    public int updateLqGerendangan(LqGerendangan lqGerendangan)
    {
        return lqGerendanganMapper.updateLqGerendangan(lqGerendangan);
    }

    /**
     * 批量删除学生档案维护
     * 
     * @param ids 需要删除的学生档案维护主键
     * @return 结果
     */
    @Override
    public int deleteLqGerendanganByIds(Long[] ids)
    {
        return lqGerendanganMapper.deleteLqGerendanganByIds(ids);
    }

    /**
     * 删除学生档案维护信息
     * 
     * @param id 学生档案维护主键
     * @return 结果
     */
    @Override
    public int deleteLqGerendanganById(Long id)
    {
        return lqGerendanganMapper.deleteLqGerendanganById(id);
    }
}
