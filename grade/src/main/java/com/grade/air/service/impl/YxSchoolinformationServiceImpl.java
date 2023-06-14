package com.grade.air.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.grade.air.mapper.YxSchoolinformationMapper;
import com.grade.air.domain.YxSchoolinformation;
import com.grade.air.service.IYxSchoolinformationService;

/**
 * 学校信息Service业务层处理
 * 
 * @author l
 * @date 2023-06-04
 */
@Service
public class YxSchoolinformationServiceImpl implements IYxSchoolinformationService 
{
    @Autowired
    private YxSchoolinformationMapper yxSchoolinformationMapper;

    /**
     * 查询学校信息
     * 
     * @param informationID 学校信息主键
     * @return 学校信息
     */
    @Override
    public YxSchoolinformation selectYxSchoolinformationByInformationID(Long informationID)
    {
        return yxSchoolinformationMapper.selectYxSchoolinformationByInformationID(informationID);
    }

    /**
     * 查询学校信息列表
     * 
     * @param yxSchoolinformation 学校信息
     * @return 学校信息
     */
    @Override
    public List<YxSchoolinformation> selectYxSchoolinformationList(YxSchoolinformation yxSchoolinformation)
    {
        return yxSchoolinformationMapper.selectYxSchoolinformationList(yxSchoolinformation);
    }

    /**
     * 新增学校信息
     * 
     * @param yxSchoolinformation 学校信息
     * @return 结果
     */
    @Override
    public int insertYxSchoolinformation(YxSchoolinformation yxSchoolinformation)
    {
        return yxSchoolinformationMapper.insertYxSchoolinformation(yxSchoolinformation);
    }

    /**
     * 修改学校信息
     * 
     * @param yxSchoolinformation 学校信息
     * @return 结果
     */
    @Override
    public int updateYxSchoolinformation(YxSchoolinformation yxSchoolinformation)
    {
        return yxSchoolinformationMapper.updateYxSchoolinformation(yxSchoolinformation);
    }

    /**
     * 批量删除学校信息
     * 
     * @param informationIDs 需要删除的学校信息主键
     * @return 结果
     */
    @Override
    public int deleteYxSchoolinformationByInformationIDs(Long[] informationIDs)
    {
        return yxSchoolinformationMapper.deleteYxSchoolinformationByInformationIDs(informationIDs);
    }

    /**
     * 删除学校信息信息
     * 
     * @param informationID 学校信息主键
     * @return 结果
     */
    @Override
    public int deleteYxSchoolinformationByInformationID(Long informationID)
    {
        return yxSchoolinformationMapper.deleteYxSchoolinformationByInformationID(informationID);
    }
}
