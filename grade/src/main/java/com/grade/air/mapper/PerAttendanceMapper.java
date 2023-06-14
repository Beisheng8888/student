package com.grade.air.mapper;

import java.util.List;
import com.grade.air.domain.PerAttendance;

/**
 * 课程考勤Mapper接口
 * 
 * @author l
 * @date 2023-06-04
 */
public interface PerAttendanceMapper 
{
    /**
     * 查询课程考勤
     * 
     * @param id 课程考勤主键
     * @return 课程考勤
     */
    public PerAttendance selectPerAttendanceById(Long id);

    /**
     * 查询课程考勤列表
     * 
     * @param perAttendance 课程考勤
     * @return 课程考勤集合
     */
    public List<PerAttendance> selectPerAttendanceList(PerAttendance perAttendance);

    /**
     * 新增课程考勤
     * 
     * @param perAttendance 课程考勤
     * @return 结果
     */
    public int insertPerAttendance(PerAttendance perAttendance);

    /**
     * 修改课程考勤
     * 
     * @param perAttendance 课程考勤
     * @return 结果
     */
    public int updatePerAttendance(PerAttendance perAttendance);

    /**
     * 删除课程考勤
     * 
     * @param id 课程考勤主键
     * @return 结果
     */
    public int deletePerAttendanceById(Long id);

    /**
     * 批量删除课程考勤
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePerAttendanceByIds(Long[] ids);
}
