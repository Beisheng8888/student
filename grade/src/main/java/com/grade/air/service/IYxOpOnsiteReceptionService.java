package com.grade.air.service;

import java.util.List;
import com.grade.air.domain.YxOpOnsiteReception;

/**
 * 现场接待数据Service接口
 * 
 * @author l
 * @date 2023-06-04
 */
public interface IYxOpOnsiteReceptionService 
{
    /**
     * 查询现场接待数据
     * 
     * @param recordId 现场接待数据主键
     * @return 现场接待数据
     */
    public YxOpOnsiteReception selectYxOpOnsiteReceptionByRecordId(Long recordId);

    /**
     * 查询现场接待数据列表
     * 
     * @param yxOpOnsiteReception 现场接待数据
     * @return 现场接待数据集合
     */
    public List<YxOpOnsiteReception> selectYxOpOnsiteReceptionList(YxOpOnsiteReception yxOpOnsiteReception);

    /**
     * 新增现场接待数据
     * 
     * @param yxOpOnsiteReception 现场接待数据
     * @return 结果
     */
    public int insertYxOpOnsiteReception(YxOpOnsiteReception yxOpOnsiteReception);

    /**
     * 修改现场接待数据
     * 
     * @param yxOpOnsiteReception 现场接待数据
     * @return 结果
     */
    public int updateYxOpOnsiteReception(YxOpOnsiteReception yxOpOnsiteReception);

    /**
     * 批量删除现场接待数据
     * 
     * @param recordIds 需要删除的现场接待数据主键集合
     * @return 结果
     */
    public int deleteYxOpOnsiteReceptionByRecordIds(Long[] recordIds);

    /**
     * 删除现场接待数据信息
     * 
     * @param recordId 现场接待数据主键
     * @return 结果
     */
    public int deleteYxOpOnsiteReceptionByRecordId(Long recordId);
}
