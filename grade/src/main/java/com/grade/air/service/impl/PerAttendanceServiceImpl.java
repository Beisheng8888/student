package com.grade.air.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.grade.air.mapper.PerAttendanceMapper;
import com.grade.air.domain.PerAttendance;
import com.grade.air.service.IPerAttendanceService;

/**
 * 课程考勤Service业务层处理
 * 
 * @author l
 * @date 2023-06-04
 */
@Service
public class PerAttendanceServiceImpl implements IPerAttendanceService 
{
    @Autowired
    private PerAttendanceMapper perAttendanceMapper;

    /**
     * 查询课程考勤
     * 
     * @param id 课程考勤主键
     * @return 课程考勤
     */
    @Override
    public PerAttendance selectPerAttendanceById(Long id)
    {
        return perAttendanceMapper.selectPerAttendanceById(id);
    }

    /**
     * 查询课程考勤列表
     * 
     * @param perAttendance 课程考勤
     * @return 课程考勤
     */
    @Override
    public List<PerAttendance> selectPerAttendanceList(PerAttendance perAttendance)
    {
        return perAttendanceMapper.selectPerAttendanceList(perAttendance);
    }

    /**
     * 新增课程考勤
     * 
     * @param perAttendance 课程考勤
     * @return 结果
     */
    @Override
    public int insertPerAttendance(PerAttendance perAttendance)
    {
        return perAttendanceMapper.insertPerAttendance(perAttendance);
    }

    /**
     * 修改课程考勤
     * 
     * @param perAttendance 课程考勤
     * @return 结果
     */
    @Override
    public int updatePerAttendance(PerAttendance perAttendance)
    {
        return perAttendanceMapper.updatePerAttendance(perAttendance);
    }

    /**
     * 批量删除课程考勤
     * 
     * @param ids 需要删除的课程考勤主键
     * @return 结果
     */
    @Override
    public int deletePerAttendanceByIds(Long[] ids)
    {
        return perAttendanceMapper.deletePerAttendanceByIds(ids);
    }

    /**
     * 删除课程考勤信息
     * 
     * @param id 课程考勤主键
     * @return 结果
     */
    @Override
    public int deletePerAttendanceById(Long id)
    {
        return perAttendanceMapper.deletePerAttendanceById(id);
    }
}
