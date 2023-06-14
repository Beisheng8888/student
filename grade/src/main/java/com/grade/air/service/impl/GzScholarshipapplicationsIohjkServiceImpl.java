package com.grade.air.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.grade.air.mapper.GzScholarshipapplicationsIohjkMapper;
import com.grade.air.domain.GzScholarshipapplicationsIohjk;
import com.grade.air.service.IGzScholarshipapplicationsIohjkService;

/**
 * 资助申请结果Service业务层处理
 * 
 * @author l
 * @date 2023-06-04
 */
@Service
public class GzScholarshipapplicationsIohjkServiceImpl implements IGzScholarshipapplicationsIohjkService 
{
    @Autowired
    private GzScholarshipapplicationsIohjkMapper gzScholarshipapplicationsIohjkMapper;

    /**
     * 查询资助申请结果
     * 
     * @param id 资助申请结果主键
     * @return 资助申请结果
     */
    @Override
    public GzScholarshipapplicationsIohjk selectGzScholarshipapplicationsIohjkById(Long id)
    {
        return gzScholarshipapplicationsIohjkMapper.selectGzScholarshipapplicationsIohjkById(id);
    }

    /**
     * 查询资助申请结果列表
     * 
     * @param gzScholarshipapplicationsIohjk 资助申请结果
     * @return 资助申请结果
     */
    @Override
    @DataScope(userAlias = "recuit")
    public List<GzScholarshipapplicationsIohjk> selectGzScholarshipapplicationsIohjkList(GzScholarshipapplicationsIohjk gzScholarshipapplicationsIohjk)
    {
        return gzScholarshipapplicationsIohjkMapper.selectGzScholarshipapplicationsIohjkList(gzScholarshipapplicationsIohjk);
    }

    /**
     * 新增资助申请结果
     * 
     * @param gzScholarshipapplicationsIohjk 资助申请结果
     * @return 结果
     */
    @Override
    public int insertGzScholarshipapplicationsIohjk(GzScholarshipapplicationsIohjk gzScholarshipapplicationsIohjk)
    {
        return gzScholarshipapplicationsIohjkMapper.insertGzScholarshipapplicationsIohjk(gzScholarshipapplicationsIohjk);
    }

    /**
     * 修改资助申请结果
     * 
     * @param gzScholarshipapplicationsIohjk 资助申请结果
     * @return 结果
     */
    @Override
    public int updateGzScholarshipapplicationsIohjk(GzScholarshipapplicationsIohjk gzScholarshipapplicationsIohjk)
    {
        return gzScholarshipapplicationsIohjkMapper.updateGzScholarshipapplicationsIohjk(gzScholarshipapplicationsIohjk);
    }

    /**
     * 批量删除资助申请结果
     * 
     * @param ids 需要删除的资助申请结果主键
     * @return 结果
     */
    @Override
    public int deleteGzScholarshipapplicationsIohjkByIds(Long[] ids)
    {
        return gzScholarshipapplicationsIohjkMapper.deleteGzScholarshipapplicationsIohjkByIds(ids);
    }

    /**
     * 删除资助申请结果信息
     * 
     * @param id 资助申请结果主键
     * @return 结果
     */
    @Override
    public int deleteGzScholarshipapplicationsIohjkById(Long id)
    {
        return gzScholarshipapplicationsIohjkMapper.deleteGzScholarshipapplicationsIohjkById(id);
    }
}
