package com.grade.air.mapper;

import java.util.List;
import com.grade.air.domain.SsCampusStayApplicationType;

/**
 * 假期留校申请反馈Mapper接口
 * 
 * @author l
 * @date 2023-06-04
 */
public interface SsCampusStayApplicationTypeMapper 
{
    /**
     * 查询假期留校申请反馈
     * 
     * @param id 假期留校申请反馈主键
     * @return 假期留校申请反馈
     */
    public SsCampusStayApplicationType selectSsCampusStayApplicationTypeById(Long id);

    /**
     * 查询假期留校申请反馈列表
     * 
     * @param ssCampusStayApplicationType 假期留校申请反馈
     * @return 假期留校申请反馈集合
     */
    public List<SsCampusStayApplicationType> selectSsCampusStayApplicationTypeList(SsCampusStayApplicationType ssCampusStayApplicationType);

    /**
     * 新增假期留校申请反馈
     * 
     * @param ssCampusStayApplicationType 假期留校申请反馈
     * @return 结果
     */
    public int insertSsCampusStayApplicationType(SsCampusStayApplicationType ssCampusStayApplicationType);

    /**
     * 修改假期留校申请反馈
     * 
     * @param ssCampusStayApplicationType 假期留校申请反馈
     * @return 结果
     */
    public int updateSsCampusStayApplicationType(SsCampusStayApplicationType ssCampusStayApplicationType);

    /**
     * 删除假期留校申请反馈
     * 
     * @param id 假期留校申请反馈主键
     * @return 结果
     */
    public int deleteSsCampusStayApplicationTypeById(Long id);

    /**
     * 批量删除假期留校申请反馈
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSsCampusStayApplicationTypeByIds(Long[] ids);
}
