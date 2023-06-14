package com.grade.air.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.grade.air.mapper.PerElectiveMapper;
import com.grade.air.domain.PerElective;
import com.grade.air.service.IPerElectiveService;

/**
 * 学员成绩Service业务层处理
 * 
 * @author l
 * @date 2023-06-04
 */
@Service
public class PerElectiveServiceImpl implements IPerElectiveService 
{
    @Autowired
    private PerElectiveMapper perElectiveMapper;

    /**
     * 查询学员成绩
     * 
     * @param id 学员成绩主键
     * @return 学员成绩
     */
    @Override
    public PerElective selectPerElectiveById(Long id)
    {
        return perElectiveMapper.selectPerElectiveById(id);
    }

    /**
     * 查询学员成绩列表
     * 
     * @param perElective 学员成绩
     * @return 学员成绩
     */
    @Override
    public List<PerElective> selectPerElectiveList(PerElective perElective)
    {
        return perElectiveMapper.selectPerElectiveList(perElective);
    }

    /**
     * 新增学员成绩
     * 
     * @param perElective 学员成绩
     * @return 结果
     */
    @Override
    public int insertPerElective(PerElective perElective)
    {
        return perElectiveMapper.insertPerElective(perElective);
    }

    /**
     * 修改学员成绩
     * 
     * @param perElective 学员成绩
     * @return 结果
     */
    @Override
    public int updatePerElective(PerElective perElective)
    {
        return perElectiveMapper.updatePerElective(perElective);
    }

    /**
     * 批量删除学员成绩
     * 
     * @param ids 需要删除的学员成绩主键
     * @return 结果
     */
    @Override
    public int deletePerElectiveByIds(Long[] ids)
    {
        return perElectiveMapper.deletePerElectiveByIds(ids);
    }

    /**
     * 删除学员成绩信息
     * 
     * @param id 学员成绩主键
     * @return 结果
     */
    @Override
    public int deletePerElectiveById(Long id)
    {
        return perElectiveMapper.deletePerElectiveById(id);
    }
}
