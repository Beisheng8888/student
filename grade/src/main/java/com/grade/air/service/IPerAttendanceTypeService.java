package com.grade.air.service;

import java.util.List;
import com.grade.air.domain.PerAttendanceType;

/**
 * 课程信息Service接口
 * 
 * @author l
 * @date 2023-06-04
 */
public interface IPerAttendanceTypeService 
{
    /**
     * 查询课程信息
     * 
     * @param id 课程信息主键
     * @return 课程信息
     */
    public PerAttendanceType selectPerAttendanceTypeById(Long id);

    /**
     * 查询课程信息列表
     * 
     * @param perAttendanceType 课程信息
     * @return 课程信息集合
     */
    public List<PerAttendanceType> selectPerAttendanceTypeList(PerAttendanceType perAttendanceType);

    /**
     * 新增课程信息
     * 
     * @param perAttendanceType 课程信息
     * @return 结果
     */
    public int insertPerAttendanceType(PerAttendanceType perAttendanceType);

    /**
     * 修改课程信息
     * 
     * @param perAttendanceType 课程信息
     * @return 结果
     */
    public int updatePerAttendanceType(PerAttendanceType perAttendanceType);

    /**
     * 批量删除课程信息
     * 
     * @param ids 需要删除的课程信息主键集合
     * @return 结果
     */
    public int deletePerAttendanceTypeByIds(Long[] ids);

    /**
     * 删除课程信息信息
     * 
     * @param id 课程信息主键
     * @return 结果
     */
    public int deletePerAttendanceTypeById(Long id);
}
