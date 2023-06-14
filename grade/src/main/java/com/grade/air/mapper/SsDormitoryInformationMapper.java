package com.grade.air.mapper;

import java.util.List;
import com.grade.air.domain.SsDormitoryInformation;

/**
 * 宿舍信息Mapper接口
 * 
 * @author l
 * @date 2023-06-04
 */
public interface SsDormitoryInformationMapper 
{
    /**
     * 查询宿舍信息
     * 
     * @param dormitoryId 宿舍信息主键
     * @return 宿舍信息
     */
    public SsDormitoryInformation selectSsDormitoryInformationByDormitoryId(Long dormitoryId);

    /**
     * 查询宿舍信息列表
     * 
     * @param ssDormitoryInformation 宿舍信息
     * @return 宿舍信息集合
     */
    public List<SsDormitoryInformation> selectSsDormitoryInformationList(SsDormitoryInformation ssDormitoryInformation);

    /**
     * 新增宿舍信息
     * 
     * @param ssDormitoryInformation 宿舍信息
     * @return 结果
     */
    public int insertSsDormitoryInformation(SsDormitoryInformation ssDormitoryInformation);

    /**
     * 修改宿舍信息
     * 
     * @param ssDormitoryInformation 宿舍信息
     * @return 结果
     */
    public int updateSsDormitoryInformation(SsDormitoryInformation ssDormitoryInformation);

    /**
     * 删除宿舍信息
     * 
     * @param dormitoryId 宿舍信息主键
     * @return 结果
     */
    public int deleteSsDormitoryInformationByDormitoryId(Long dormitoryId);

    /**
     * 批量删除宿舍信息
     * 
     * @param dormitoryIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSsDormitoryInformationByDormitoryIds(Long[] dormitoryIds);
}
