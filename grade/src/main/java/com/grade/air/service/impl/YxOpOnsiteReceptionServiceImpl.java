package com.grade.air.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.grade.air.mapper.YxOpOnsiteReceptionMapper;
import com.grade.air.domain.YxOpOnsiteReception;
import com.grade.air.service.IYxOpOnsiteReceptionService;

/**
 * 现场接待数据Service业务层处理
 * 
 * @author l
 * @date 2023-06-04
 */
@Service
public class YxOpOnsiteReceptionServiceImpl implements IYxOpOnsiteReceptionService 
{
    @Autowired
    private YxOpOnsiteReceptionMapper yxOpOnsiteReceptionMapper;

    /**
     * 查询现场接待数据
     * 
     * @param recordId 现场接待数据主键
     * @return 现场接待数据
     */
    @Override
    public YxOpOnsiteReception selectYxOpOnsiteReceptionByRecordId(Long recordId)
    {
        return yxOpOnsiteReceptionMapper.selectYxOpOnsiteReceptionByRecordId(recordId);
    }

    /**
     * 查询现场接待数据列表
     * 
     * @param yxOpOnsiteReception 现场接待数据
     * @return 现场接待数据
     */
    @Override
    @DataScope(userAlias = "recuit")
    public List<YxOpOnsiteReception> selectYxOpOnsiteReceptionList(YxOpOnsiteReception yxOpOnsiteReception)
    {
        return yxOpOnsiteReceptionMapper.selectYxOpOnsiteReceptionList(yxOpOnsiteReception);
    }

    /**
     * 新增现场接待数据
     * 
     * @param yxOpOnsiteReception 现场接待数据
     * @return 结果
     */
    @Override
    public int insertYxOpOnsiteReception(YxOpOnsiteReception yxOpOnsiteReception)
    {
        return yxOpOnsiteReceptionMapper.insertYxOpOnsiteReception(yxOpOnsiteReception);
    }

    /**
     * 修改现场接待数据
     * 
     * @param yxOpOnsiteReception 现场接待数据
     * @return 结果
     */
    @Override
    public int updateYxOpOnsiteReception(YxOpOnsiteReception yxOpOnsiteReception)
    {
        return yxOpOnsiteReceptionMapper.updateYxOpOnsiteReception(yxOpOnsiteReception);
    }

    /**
     * 批量删除现场接待数据
     * 
     * @param recordIds 需要删除的现场接待数据主键
     * @return 结果
     */
    @Override
    public int deleteYxOpOnsiteReceptionByRecordIds(Long[] recordIds)
    {
        return yxOpOnsiteReceptionMapper.deleteYxOpOnsiteReceptionByRecordIds(recordIds);
    }

    /**
     * 删除现场接待数据信息
     * 
     * @param recordId 现场接待数据主键
     * @return 结果
     */
    @Override
    public int deleteYxOpOnsiteReceptionByRecordId(Long recordId)
    {
        return yxOpOnsiteReceptionMapper.deleteYxOpOnsiteReceptionByRecordId(recordId);
    }
}
