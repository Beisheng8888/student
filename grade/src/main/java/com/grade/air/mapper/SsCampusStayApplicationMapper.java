package com.grade.air.mapper;

import java.util.List;
import com.grade.air.domain.SsCampusStayApplication;

/**
 * 假期留校申请Mapper接口
 * 
 * @author l
 * @date 2023-06-04
 */
public interface SsCampusStayApplicationMapper 
{
    /**
     * 查询假期留校申请
     * 
     * @param applicationId 假期留校申请主键
     * @return 假期留校申请
     */
    public SsCampusStayApplication selectSsCampusStayApplicationByApplicationId(Long applicationId);

    /**
     * 查询假期留校申请列表
     * 
     * @param ssCampusStayApplication 假期留校申请
     * @return 假期留校申请集合
     */
    public List<SsCampusStayApplication> selectSsCampusStayApplicationList(SsCampusStayApplication ssCampusStayApplication);

    /**
     * 新增假期留校申请
     * 
     * @param ssCampusStayApplication 假期留校申请
     * @return 结果
     */
    public int insertSsCampusStayApplication(SsCampusStayApplication ssCampusStayApplication);

    /**
     * 修改假期留校申请
     * 
     * @param ssCampusStayApplication 假期留校申请
     * @return 结果
     */
    public int updateSsCampusStayApplication(SsCampusStayApplication ssCampusStayApplication);

    /**
     * 删除假期留校申请
     * 
     * @param applicationId 假期留校申请主键
     * @return 结果
     */
    public int deleteSsCampusStayApplicationByApplicationId(Long applicationId);

    /**
     * 批量删除假期留校申请
     * 
     * @param applicationIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSsCampusStayApplicationByApplicationIds(Long[] applicationIds);
}
