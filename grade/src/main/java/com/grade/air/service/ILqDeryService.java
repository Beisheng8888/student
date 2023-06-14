package com.grade.air.service;

import java.util.List;
import com.grade.air.domain.LqDery;

/**
 * 学籍调动结果Service接口
 * 
 * @author l
 * @date 2023-06-04
 */
public interface ILqDeryService 
{
    /**
     * 查询学籍调动结果
     * 
     * @param id 学籍调动结果主键
     * @return 学籍调动结果
     */
    public LqDery selectLqDeryById(Long id);

    /**
     * 查询学籍调动结果列表
     * 
     * @param lqDery 学籍调动结果
     * @return 学籍调动结果集合
     */
    public List<LqDery> selectLqDeryList(LqDery lqDery);

    /**
     * 新增学籍调动结果
     * 
     * @param lqDery 学籍调动结果
     * @return 结果
     */
    public int insertLqDery(LqDery lqDery);

    /**
     * 修改学籍调动结果
     * 
     * @param lqDery 学籍调动结果
     * @return 结果
     */
    public int updateLqDery(LqDery lqDery);

    /**
     * 批量删除学籍调动结果
     * 
     * @param ids 需要删除的学籍调动结果主键集合
     * @return 结果
     */
    public int deleteLqDeryByIds(Long[] ids);

    /**
     * 删除学籍调动结果信息
     * 
     * @param id 学籍调动结果主键
     * @return 结果
     */
    public int deleteLqDeryById(Long id);


}
