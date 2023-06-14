package com.grade.air.service;

import java.util.List;
import com.grade.air.domain.GzScholarshipapplicationsIohjk;

/**
 * 资助申请结果Service接口
 * 
 * @author l
 * @date 2023-06-04
 */
public interface IGzScholarshipapplicationsIohjkService 
{
    /**
     * 查询资助申请结果
     * 
     * @param id 资助申请结果主键
     * @return 资助申请结果
     */
    public GzScholarshipapplicationsIohjk selectGzScholarshipapplicationsIohjkById(Long id);

    /**
     * 查询资助申请结果列表
     * 
     * @param gzScholarshipapplicationsIohjk 资助申请结果
     * @return 资助申请结果集合
     */
    public List<GzScholarshipapplicationsIohjk> selectGzScholarshipapplicationsIohjkList(GzScholarshipapplicationsIohjk gzScholarshipapplicationsIohjk);

    /**
     * 新增资助申请结果
     * 
     * @param gzScholarshipapplicationsIohjk 资助申请结果
     * @return 结果
     */
    public int insertGzScholarshipapplicationsIohjk(GzScholarshipapplicationsIohjk gzScholarshipapplicationsIohjk);

    /**
     * 修改资助申请结果
     * 
     * @param gzScholarshipapplicationsIohjk 资助申请结果
     * @return 结果
     */
    public int updateGzScholarshipapplicationsIohjk(GzScholarshipapplicationsIohjk gzScholarshipapplicationsIohjk);

    /**
     * 批量删除资助申请结果
     * 
     * @param ids 需要删除的资助申请结果主键集合
     * @return 结果
     */
    public int deleteGzScholarshipapplicationsIohjkByIds(Long[] ids);

    /**
     * 删除资助申请结果信息
     * 
     * @param id 资助申请结果主键
     * @return 结果
     */
    public int deleteGzScholarshipapplicationsIohjkById(Long id);
}
