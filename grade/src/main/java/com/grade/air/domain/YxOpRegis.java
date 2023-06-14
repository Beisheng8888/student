package com.grade.air.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 行政报到对象 yx_op_regis
 * 
 * @author l
 * @date 2023-06-04
 */
public class YxOpRegis extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 学生姓名 */
    @Excel(name = "学生姓名")
    private String name;

    /** 学号 */
    @Excel(name = "学号")
    private String studentNumber;

    /** 提交时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "提交时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date submissionTime;

    /** 抵达时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "抵达时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date arrivalTime;

    /** 抵达地点 */
    @Excel(name = "抵达地点")
    private String arrivalLocation;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setStudentNumber(String studentNumber) 
    {
        this.studentNumber = studentNumber;
    }

    public String getStudentNumber() 
    {
        return studentNumber;
    }
    public void setSubmissionTime(Date submissionTime) 
    {
        this.submissionTime = submissionTime;
    }

    public Date getSubmissionTime() 
    {
        return submissionTime;
    }
    public void setArrivalTime(Date arrivalTime) 
    {
        this.arrivalTime = arrivalTime;
    }

    public Date getArrivalTime() 
    {
        return arrivalTime;
    }
    public void setArrivalLocation(String arrivalLocation) 
    {
        this.arrivalLocation = arrivalLocation;
    }

    public String getArrivalLocation() 
    {
        return arrivalLocation;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("studentNumber", getStudentNumber())
            .append("submissionTime", getSubmissionTime())
            .append("arrivalTime", getArrivalTime())
            .append("arrivalLocation", getArrivalLocation())
            .append("userId", getUserId())
            .toString();
    }
}
