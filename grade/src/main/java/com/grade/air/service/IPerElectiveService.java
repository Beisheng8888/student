package com.grade.air.service;

import java.util.List;
import com.grade.air.domain.PerElective;

/**
 * 学员成绩Service接口
 * 
 * @author l
 * @date 2023-06-04
 */
public interface IPerElectiveService 
{
    /**
     * 查询学员成绩
     * 
     * @param id 学员成绩主键
     * @return 学员成绩
     */
    public PerElective selectPerElectiveById(Long id);

    /**
     * 查询学员成绩列表
     * 
     * @param perElective 学员成绩
     * @return 学员成绩集合
     */
    public List<PerElective> selectPerElectiveList(PerElective perElective);

    /**
     * 新增学员成绩
     * 
     * @param perElective 学员成绩
     * @return 结果
     */
    public int insertPerElective(PerElective perElective);

    /**
     * 修改学员成绩
     * 
     * @param perElective 学员成绩
     * @return 结果
     */
    public int updatePerElective(PerElective perElective);

    /**
     * 批量删除学员成绩
     * 
     * @param ids 需要删除的学员成绩主键集合
     * @return 结果
     */
    public int deletePerElectiveByIds(Long[] ids);

    /**
     * 删除学员成绩信息
     * 
     * @param id 学员成绩主键
     * @return 结果
     */
    public int deletePerElectiveById(Long id);
}
