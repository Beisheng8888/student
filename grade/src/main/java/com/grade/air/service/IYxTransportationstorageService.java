package com.grade.air.service;

import java.util.List;
import com.grade.air.domain.YxTransportationstorage;

/**
 * 接送与寄存Service接口
 * 
 * @author l
 * @date 2023-06-04
 */
public interface IYxTransportationstorageService 
{
    /**
     * 查询接送与寄存
     * 
     * @param transportationStorageID 接送与寄存主键
     * @return 接送与寄存
     */
    public YxTransportationstorage selectYxTransportationstorageByTransportationStorageID(Long transportationStorageID);

    /**
     * 查询接送与寄存列表
     * 
     * @param yxTransportationstorage 接送与寄存
     * @return 接送与寄存集合
     */
    public List<YxTransportationstorage> selectYxTransportationstorageList(YxTransportationstorage yxTransportationstorage);

    /**
     * 新增接送与寄存
     * 
     * @param yxTransportationstorage 接送与寄存
     * @return 结果
     */
    public int insertYxTransportationstorage(YxTransportationstorage yxTransportationstorage);

    /**
     * 修改接送与寄存
     * 
     * @param yxTransportationstorage 接送与寄存
     * @return 结果
     */
    public int updateYxTransportationstorage(YxTransportationstorage yxTransportationstorage);

    /**
     * 批量删除接送与寄存
     * 
     * @param transportationStorageIDs 需要删除的接送与寄存主键集合
     * @return 结果
     */
    public int deleteYxTransportationstorageByTransportationStorageIDs(Long[] transportationStorageIDs);

    /**
     * 删除接送与寄存信息
     * 
     * @param transportationStorageID 接送与寄存主键
     * @return 结果
     */
    public int deleteYxTransportationstorageByTransportationStorageID(Long transportationStorageID);
}
