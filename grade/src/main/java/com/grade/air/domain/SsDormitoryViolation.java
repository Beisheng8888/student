package com.grade.air.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 宿舍违纪对象 ss_dormitory_violation
 * 
 * @author l
 * @date 2023-06-04
 */
public class SsDormitoryViolation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long violationId;

    /** 学生姓名 */
    @Excel(name = "学生姓名")
    private String studentName;

    /** 违纪日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "违纪日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date violationDate;

    /** 违纪描述 */
    @Excel(name = "违纪描述")
    private String description;

    /** 用户id */
    @Excel(name = "用户id")
    private Object userId;

    public void setViolationId(Long violationId) 
    {
        this.violationId = violationId;
    }

    public Long getViolationId() 
    {
        return violationId;
    }
    public void setStudentName(String studentName) 
    {
        this.studentName = studentName;
    }

    public String getStudentName() 
    {
        return studentName;
    }
    public void setViolationDate(Date violationDate) 
    {
        this.violationDate = violationDate;
    }

    public Date getViolationDate() 
    {
        return violationDate;
    }
    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
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
            .append("violationId", getViolationId())
            .append("studentName", getStudentName())
            .append("violationDate", getViolationDate())
            .append("description", getDescription())
            .append("userId", getUserId())
            .toString();
    }
}
