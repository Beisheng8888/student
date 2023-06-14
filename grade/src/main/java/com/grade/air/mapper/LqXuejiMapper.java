package com.grade.air.mapper;

import java.util.List;
import com.grade.air.domain.LqXueji;

/**
 * 学籍调动Mapper接口
 * 
 * @author l
 * @date 2023-06-04
 */
public interface LqXuejiMapper 
{
    /**
     * 查询学籍调动
     * 
     * @param id 学籍调动主键
     * @return 学籍调动
     */
    public LqXueji selectLqXuejiById(Long id);

    /**
     * 查询学籍调动列表
     * 
     * @param lqXueji 学籍调动
     * @return 学籍调动集合
     */
    public List<LqXueji> selectLqXuejiList(LqXueji lqXueji);

    /**
     * 新增学籍调动
     * 
     * @param lqXueji 学籍调动
     * @return 结果
     */
    public int insertLqXueji(LqXueji lqXueji);

    /**
     * 修改学籍调动
     * 
     * @param lqXueji 学籍调动
     * @return 结果
     */
    public int updateLqXueji(LqXueji lqXueji);

    /**
     * 删除学籍调动
     * 
     * @param id 学籍调动主键
     * @return 结果
     */
    public int deleteLqXuejiById(Long id);

    /**
     * 批量删除学籍调动
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLqXuejiByIds(Long[] ids);
}
