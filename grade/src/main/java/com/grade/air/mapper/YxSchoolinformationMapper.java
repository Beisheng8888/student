package com.grade.air.mapper;

import java.util.List;
import com.grade.air.domain.YxSchoolinformation;

/**
 * 学校信息Mapper接口
 * 
 * @author l
 * @date 2023-06-04
 */
public interface YxSchoolinformationMapper 
{
    /**
     * 查询学校信息
     * 
     * @param informationID 学校信息主键
     * @return 学校信息
     */
    public YxSchoolinformation selectYxSchoolinformationByInformationID(Long informationID);

    /**
     * 查询学校信息列表
     * 
     * @param yxSchoolinformation 学校信息
     * @return 学校信息集合
     */
    public List<YxSchoolinformation> selectYxSchoolinformationList(YxSchoolinformation yxSchoolinformation);

    /**
     * 新增学校信息
     * 
     * @param yxSchoolinformation 学校信息
     * @return 结果
     */
    public int insertYxSchoolinformation(YxSchoolinformation yxSchoolinformation);

    /**
     * 修改学校信息
     * 
     * @param yxSchoolinformation 学校信息
     * @return 结果
     */
    public int updateYxSchoolinformation(YxSchoolinformation yxSchoolinformation);

    /**
     * 删除学校信息
     * 
     * @param informationID 学校信息主键
     * @return 结果
     */
    public int deleteYxSchoolinformationByInformationID(Long informationID);

    /**
     * 批量删除学校信息
     * 
     * @param informationIDs 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteYxSchoolinformationByInformationIDs(Long[] informationIDs);
}
