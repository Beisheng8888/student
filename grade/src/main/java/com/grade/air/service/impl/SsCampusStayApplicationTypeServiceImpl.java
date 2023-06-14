package com.grade.air.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.grade.air.mapper.SsCampusStayApplicationTypeMapper;
import com.grade.air.domain.SsCampusStayApplicationType;
import com.grade.air.service.ISsCampusStayApplicationTypeService;

/**
 * 假期留校申请反馈Service业务层处理
 * 
 * @author l
 * @date 2023-06-04
 */
@Service
public class SsCampusStayApplicationTypeServiceImpl implements ISsCampusStayApplicationTypeService 
{
    @Autowired
    private SsCampusStayApplicationTypeMapper ssCampusStayApplicationTypeMapper;

    /**
     * 查询假期留校申请反馈
     * 
     * @param id 假期留校申请反馈主键
     * @return 假期留校申请反馈
     */
    @Override
    public SsCampusStayApplicationType selectSsCampusStayApplicationTypeById(Long id)
    {
        return ssCampusStayApplicationTypeMapper.selectSsCampusStayApplicationTypeById(id);
    }

    /**
     * 查询假期留校申请反馈列表
     * 
     * @param ssCampusStayApplicationType 假期留校申请反馈
     * @return 假期留校申请反馈
     */
    @Override
    public List<SsCampusStayApplicationType> selectSsCampusStayApplicationTypeList(SsCampusStayApplicationType ssCampusStayApplicationType)
    {
        return ssCampusStayApplicationTypeMapper.selectSsCampusStayApplicationTypeList(ssCampusStayApplicationType);
    }

    /**
     * 新增假期留校申请反馈
     * 
     * @param ssCampusStayApplicationType 假期留校申请反馈
     * @return 结果
     */
    @Override
    public int insertSsCampusStayApplicationType(SsCampusStayApplicationType ssCampusStayApplicationType)
    {
        return ssCampusStayApplicationTypeMapper.insertSsCampusStayApplicationType(ssCampusStayApplicationType);
    }

    /**
     * 修改假期留校申请反馈
     * 
     * @param ssCampusStayApplicationType 假期留校申请反馈
     * @return 结果
     */
    @Override
    public int updateSsCampusStayApplicationType(SsCampusStayApplicationType ssCampusStayApplicationType)
    {
        return ssCampusStayApplicationTypeMapper.updateSsCampusStayApplicationType(ssCampusStayApplicationType);
    }

    /**
     * 批量删除假期留校申请反馈
     * 
     * @param ids 需要删除的假期留校申请反馈主键
     * @return 结果
     */
    @Override
    public int deleteSsCampusStayApplicationTypeByIds(Long[] ids)
    {
        return ssCampusStayApplicationTypeMapper.deleteSsCampusStayApplicationTypeByIds(ids);
    }

    /**
     * 删除假期留校申请反馈信息
     * 
     * @param id 假期留校申请反馈主键
     * @return 结果
     */
    @Override
    public int deleteSsCampusStayApplicationTypeById(Long id)
    {
        return ssCampusStayApplicationTypeMapper.deleteSsCampusStayApplicationTypeById(id);
    }
}
