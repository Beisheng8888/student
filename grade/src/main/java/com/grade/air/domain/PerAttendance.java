package com.grade.air.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 课程考勤对象 per_attendance
 * 
 * @author l
 * @date 2023-06-04
 */
public class PerAttendance extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 课程 */
    @Excel(name = "课程")
    private String courseName;

    /** 学员姓名 */
    @Excel(name = "学员姓名")
    private String studentName;

    /** 上课日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "上课日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date attendanceStatus;

    /** 考勤 */
    @Excel(name = "考勤")
    private Integer salary;

    /** 班级 */
    @Excel(name = "班级")
    private String gradeName;

    /** 学院 */
    @Excel(name = "学院")
    private String xueyuan;

    /** 用户id */
    @Excel(name = "用户id")
    private Object userId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCourseName(String courseName) 
    {
        this.courseName = courseName;
    }

    public String getCourseName() 
    {
        return courseName;
    }
    public void setStudentName(String studentName) 
    {
        this.studentName = studentName;
    }

    public String getStudentName() 
    {
        return studentName;
    }
    public void setAttendanceStatus(Date attendanceStatus) 
    {
        this.attendanceStatus = attendanceStatus;
    }

    public Date getAttendanceStatus() 
    {
        return attendanceStatus;
    }
    public void setSalary(Integer salary) 
    {
        this.salary = salary;
    }

    public Integer getSalary() 
    {
        return salary;
    }
    public void setGradeName(String gradeName) 
    {
        this.gradeName = gradeName;
    }

    public String getGradeName() 
    {
        return gradeName;
    }
    public void setXueyuan(String xueyuan) 
    {
        this.xueyuan = xueyuan;
    }

    public String getXueyuan() 
    {
        return xueyuan;
    }
    public void setUserId(Object userId)
    {
        this.userId = userId;
    }

    public Object getUserId()
    {
        return userId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("courseName", getCourseName())
            .append("studentName", getStudentName())
            .append("attendanceStatus", getAttendanceStatus())
            .append("salary", getSalary())
            .append("gradeName", getGradeName())
            .append("xueyuan", getXueyuan())
            .append("userId", getUserId())
            .toString();
    }
}
