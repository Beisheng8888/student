package com.grade.air.service;

import java.util.List;
import com.grade.air.domain.LixiaoDepartureapplicationsIfop;

/**
 * 离校审核结果Service接口
 * 
 * @author l
 * @date 2023-06-04
 */
public interface ILixiaoDepartureapplicationsIfopService 
{
    /**
     * 查询离校审核结果
     * 
     * @param id 离校审核结果主键
     * @return 离校审核结果
     */
    public LixiaoDepartureapplicationsIfop selectLixiaoDepartureapplicationsIfopById(Long id);

    /**
     * 查询离校审核结果列表
     * 
     * @param lixiaoDepartureapplicationsIfop 离校审核结果
     * @return 离校审核结果集合
     */
    public List<LixiaoDepartureapplicationsIfop> selectLixiaoDepartureapplicationsIfopList(LixiaoDepartureapplicationsIfop lixiaoDepartureapplicationsIfop);

    /**
     * 新增离校审核结果
     * 
     * @param lixiaoDepartureapplicationsIfop 离校审核结果
     * @return 结果
     */
    public int insertLixiaoDepartureapplicationsIfop(LixiaoDepartureapplicationsIfop lixiaoDepartureapplicationsIfop);

    /**
     * 修改离校审核结果
     * 
     * @param lixiaoDepartureapplicationsIfop 离校审核结果
     * @return 结果
     */
    public int updateLixiaoDepartureapplicationsIfop(LixiaoDepartureapplicationsIfop lixiaoDepartureapplicationsIfop);

    /**
     * 批量删除离校审核结果
     * 
     * @param ids 需要删除的离校审核结果主键集合
     * @return 结果
     */
    public int deleteLixiaoDepartureapplicationsIfopByIds(Long[] ids);

    /**
     * 删除离校审核结果信息
     * 
     * @param id 离校审核结果主键
     * @return 结果
     */
    public int deleteLixiaoDepartureapplicationsIfopById(Long id);
}
