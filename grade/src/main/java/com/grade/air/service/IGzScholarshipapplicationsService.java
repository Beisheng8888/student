package com.grade.air.service;

import java.util.List;
import com.grade.air.domain.GzScholarshipapplications;

/**
 * 资助申请Service接口
 * 
 * @author l
 * @date 2023-06-04
 */
public interface IGzScholarshipapplicationsService 
{
    /**
     * 查询资助申请
     * 
     * @param applicationID 资助申请主键
     * @return 资助申请
     */
    public GzScholarshipapplications selectGzScholarshipapplicationsByApplicationID(Long applicationID);

    /**
     * 查询资助申请列表
     * 
     * @param gzScholarshipapplications 资助申请
     * @return 资助申请集合
     */
    public List<GzScholarshipapplications> selectGzScholarshipapplicationsList(GzScholarshipapplications gzScholarshipapplications);

    /**
     * 新增资助申请
     * 
     * @param gzScholarshipapplications 资助申请
     * @return 结果
     */
    public int insertGzScholarshipapplications(GzScholarshipapplications gzScholarshipapplications);

    /**
     * 修改资助申请
     * 
     * @param gzScholarshipapplications 资助申请
     * @return 结果
     */
    public int updateGzScholarshipapplications(GzScholarshipapplications gzScholarshipapplications);

    /**
     * 批量删除资助申请
     * 
     * @param applicationIDs 需要删除的资助申请主键集合
     * @return 结果
     */
    public int deleteGzScholarshipapplicationsByApplicationIDs(Long[] applicationIDs);

    /**
     * 删除资助申请信息
     * 
     * @param applicationID 资助申请主键
     * @return 结果
     */
    public int deleteGzScholarshipapplicationsByApplicationID(Long applicationID);
}
