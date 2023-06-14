package com.grade.air.mapper;

import java.util.List;
import com.grade.air.domain.LqGerendangan;

/**
 * 学生档案维护Mapper接口
 * 
 * @author l
 * @date 2023-06-04
 */
public interface LqGerendanganMapper 
{
    /**
     * 查询学生档案维护
     * 
     * @param id 学生档案维护主键
     * @return 学生档案维护
     */
    public LqGerendangan selectLqGerendanganById(Long id);

    /**
     * 查询学生档案维护列表
     * 
     * @param lqGerendangan 学生档案维护
     * @return 学生档案维护集合
     */
    public List<LqGerendangan> selectLqGerendanganList(LqGerendangan lqGerendangan);

    /**
     * 新增学生档案维护
     * 
     * @param lqGerendangan 学生档案维护
     * @return 结果
     */
    public int insertLqGerendangan(LqGerendangan lqGerendangan);

    /**
     * 修改学生档案维护
     * 
     * @param lqGerendangan 学生档案维护
     * @return 结果
     */
    public int updateLqGerendangan(LqGerendangan lqGerendangan);

    /**
     * 删除学生档案维护
     * 
     * @param id 学生档案维护主键
     * @return 结果
     */
    public int deleteLqGerendanganById(Long id);

    /**
     * 批量删除学生档案维护
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLqGerendanganByIds(Long[] ids);
}
