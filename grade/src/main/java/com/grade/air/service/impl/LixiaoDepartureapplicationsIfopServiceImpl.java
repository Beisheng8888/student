package com.grade.air.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.grade.air.mapper.LixiaoDepartureapplicationsIfopMapper;
import com.grade.air.domain.LixiaoDepartureapplicationsIfop;
import com.grade.air.service.ILixiaoDepartureapplicationsIfopService;

/**
 * 离校审核结果Service业务层处理
 * 
 * @author l
 * @date 2023-06-04
 */
@Service
public class LixiaoDepartureapplicationsIfopServiceImpl implements ILixiaoDepartureapplicationsIfopService 
{
    @Autowired
    private LixiaoDepartureapplicationsIfopMapper lixiaoDepartureapplicationsIfopMapper;

    /**
     * 查询离校审核结果
     * 
     * @param id 离校审核结果主键
     * @return 离校审核结果
     */
    @Override
    public LixiaoDepartureapplicationsIfop selectLixiaoDepartureapplicationsIfopById(Long id)
    {
        return lixiaoDepartureapplicationsIfopMapper.selectLixiaoDepartureapplicationsIfopById(id);
    }

    /**
     * 查询离校审核结果列表
     * 
     * @param lixiaoDepartureapplicationsIfop 离校审核结果
     * @return 离校审核结果
     */
    @Override
    public List<LixiaoDepartureapplicationsIfop> selectLixiaoDepartureapplicationsIfopList(LixiaoDepartureapplicationsIfop lixiaoDepartureapplicationsIfop)
    {
        return lixiaoDepartureapplicationsIfopMapper.selectLixiaoDepartureapplicationsIfopList(lixiaoDepartureapplicationsIfop);
    }

    /**
     * 新增离校审核结果
     * 
     * @param lixiaoDepartureapplicationsIfop 离校审核结果
     * @return 结果
     */
    @Override
    public int insertLixiaoDepartureapplicationsIfop(LixiaoDepartureapplicationsIfop lixiaoDepartureapplicationsIfop)
    {
        return lixiaoDepartureapplicationsIfopMapper.insertLixiaoDepartureapplicationsIfop(lixiaoDepartureapplicationsIfop);
    }

    /**
     * 修改离校审核结果
     * 
     * @param lixiaoDepartureapplicationsIfop 离校审核结果
     * @return 结果
     */
    @Override
    public int updateLixiaoDepartureapplicationsIfop(LixiaoDepartureapplicationsIfop lixiaoDepartureapplicationsIfop)
    {
        return lixiaoDepartureapplicationsIfopMapper.updateLixiaoDepartureapplicationsIfop(lixiaoDepartureapplicationsIfop);
    }

    /**
     * 批量删除离校审核结果
     * 
     * @param ids 需要删除的离校审核结果主键
     * @return 结果
     */
    @Override
    public int deleteLixiaoDepartureapplicationsIfopByIds(Long[] ids)
    {
        return lixiaoDepartureapplicationsIfopMapper.deleteLixiaoDepartureapplicationsIfopByIds(ids);
    }

    /**
     * 删除离校审核结果信息
     * 
     * @param id 离校审核结果主键
     * @return 结果
     */
    @Override
    public int deleteLixiaoDepartureapplicationsIfopById(Long id)
    {
        return lixiaoDepartureapplicationsIfopMapper.deleteLixiaoDepartureapplicationsIfopById(id);
    }
}
