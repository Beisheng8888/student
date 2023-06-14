package com.grade.air.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.grade.air.mapper.PerAttendanceTypeMapper;
import com.grade.air.domain.PerAttendanceType;
import com.grade.air.service.IPerAttendanceTypeService;

/**
 * 课程信息Service业务层处理
 * 
 * @author l
 * @date 2023-06-04
 */
@Service
public class PerAttendanceTypeServiceImpl implements IPerAttendanceTypeService 
{
    @Autowired
    private PerAttendanceTypeMapper perAttendanceTypeMapper;

    /**
     * 查询课程信息
     * 
     * @param id 课程信息主键
     * @return 课程信息
     */
    @Override
    public PerAttendanceType selectPerAttendanceTypeById(Long id)
    {
        return perAttendanceTypeMapper.selectPerAttendanceTypeById(id);
    }

    /**
     * 查询课程信息列表
     * 
     * @param perAttendanceType 课程信息
     * @return 课程信息
     */
    @Override
    public List<PerAttendanceType> selectPerAttendanceTypeList(PerAttendanceType perAttendanceType)
    {
        return perAttendanceTypeMapper.selectPerAttendanceTypeList(perAttendanceType);
    }

    /**
     * 新增课程信息
     * 
     * @param perAttendanceType 课程信息
     * @return 结果
     */
    @Override
    public int insertPerAttendanceType(PerAttendanceType perAttendanceType)
    {
        return perAttendanceTypeMapper.insertPerAttendanceType(perAttendanceType);
    }

    /**
     * 修改课程信息
     * 
     * @param perAttendanceType 课程信息
     * @return 结果
     */
    @Override
    public int updatePerAttendanceType(PerAttendanceType perAttendanceType)
    {
        return perAttendanceTypeMapper.updatePerAttendanceType(perAttendanceType);
    }

    /**
     * 批量删除课程信息
     * 
     * @param ids 需要删除的课程信息主键
     * @return 结果
     */
    @Override
    public int deletePerAttendanceTypeByIds(Long[] ids)
    {
        return perAttendanceTypeMapper.deletePerAttendanceTypeByIds(ids);
    }

    /**
     * 删除课程信息信息
     * 
     * @param id 课程信息主键
     * @return 结果
     */
    @Override
    public int deletePerAttendanceTypeById(Long id)
    {
        return perAttendanceTypeMapper.deletePerAttendanceTypeById(id);
    }
}
