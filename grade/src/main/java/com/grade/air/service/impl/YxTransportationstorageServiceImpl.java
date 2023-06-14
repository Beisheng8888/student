package com.grade.air.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.grade.air.mapper.YxTransportationstorageMapper;
import com.grade.air.domain.YxTransportationstorage;
import com.grade.air.service.IYxTransportationstorageService;

/**
 * 接送与寄存Service业务层处理
 * 
 * @author l
 * @date 2023-06-04
 */
@Service
public class YxTransportationstorageServiceImpl implements IYxTransportationstorageService 
{
    @Autowired
    private YxTransportationstorageMapper yxTransportationstorageMapper;

    /**
     * 查询接送与寄存
     * 
     * @param transportationStorageID 接送与寄存主键
     * @return 接送与寄存
     */
    @Override
    public YxTransportationstorage selectYxTransportationstorageByTransportationStorageID(Long transportationStorageID)
    {
        return yxTransportationstorageMapper.selectYxTransportationstorageByTransportationStorageID(transportationStorageID);
    }

    /**
     * 查询接送与寄存列表
     * 
     * @param yxTransportationstorage 接送与寄存
     * @return 接送与寄存
     */
    @Override
    @DataScope(userAlias = "recuit")
    public List<YxTransportationstorage> selectYxTransportationstorageList(YxTransportationstorage yxTransportationstorage)
    {
        return yxTransportationstorageMapper.selectYxTransportationstorageList(yxTransportationstorage);
    }

    /**
     * 新增接送与寄存
     * 
     * @param yxTransportationstorage 接送与寄存
     * @return 结果
     */
    @Override
    public int insertYxTransportationstorage(YxTransportationstorage yxTransportationstorage)
    {
        return yxTransportationstorageMapper.insertYxTransportationstorage(yxTransportationstorage);
    }

    /**
     * 修改接送与寄存
     * 
     * @param yxTransportationstorage 接送与寄存
     * @return 结果
     */
    @Override
    public int updateYxTransportationstorage(YxTransportationstorage yxTransportationstorage)
    {
        return yxTransportationstorageMapper.updateYxTransportationstorage(yxTransportationstorage);
    }

    /**
     * 批量删除接送与寄存
     * 
     * @param transportationStorageIDs 需要删除的接送与寄存主键
     * @return 结果
     */
    @Override
    public int deleteYxTransportationstorageByTransportationStorageIDs(Long[] transportationStorageIDs)
    {
        return yxTransportationstorageMapper.deleteYxTransportationstorageByTransportationStorageIDs(transportationStorageIDs);
    }

    /**
     * 删除接送与寄存信息
     * 
     * @param transportationStorageID 接送与寄存主键
     * @return 结果
     */
    @Override
    public int deleteYxTransportationstorageByTransportationStorageID(Long transportationStorageID)
    {
        return yxTransportationstorageMapper.deleteYxTransportationstorageByTransportationStorageID(transportationStorageID);
    }
}
