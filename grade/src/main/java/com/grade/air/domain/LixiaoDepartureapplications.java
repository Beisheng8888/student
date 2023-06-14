package com.grade.air.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 离校申请对象 lixiao_departureapplications
 * 
 * @author l
 * @date 2023-06-04
 */
public class LixiaoDepartureapplications extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long applicationID;

    /** 学生姓名 */
    @Excel(name = "学生姓名")
    private String studentName;

    /** 申请日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "申请日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date applicationDate;

    /** 离校日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "离校日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date departureDate;

    /** 离校事由 */
    @Excel(name = "离校事由")
    private String reason;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    public void setApplicationID(Long applicationID) 
    {
        this.applicationID = applicationID;
    }

    public Long getApplicationID() 
    {
        return applicationID;
    }
    public void setStudentName(String studentName) 
    {
        this.studentName = studentName;
    }

    public String getStudentName() 
    {
        return studentName;
    }
    public void setApplicationDate(Date applicationDate) 
    {
        this.applicationDate = applicationDate;
    }

    public Date getApplicationDate() 
    {
        return applicationDate;
    }
    public void setDepartureDate(Date departureDate) 
    {
        this.departureDate = departureDate;
    }

    public Date getDepartureDate() 
    {
        return departureDate;
    }
    public void setReason(String reason) 
    {
        this.reason = reason;
    }

    public String getReason() 
    {
        return reason;
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
            .append("applicationID", getApplicationID())
            .append("studentName", getStudentName())
            .append("applicationDate", getApplicationDate())
            .append("departureDate", getDepartureDate())
            .append("reason", getReason())
            .append("userId", getUserId())
            .toString();
    }
}
