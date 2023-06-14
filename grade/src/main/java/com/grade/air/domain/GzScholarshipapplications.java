package com.grade.air.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 资助申请对象 gz_scholarshipapplications
 * 
 * @author l
 * @date 2023-06-04
 */
public class GzScholarshipapplications extends BaseEntity
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

    /** 申请金额 */
    @Excel(name = "申请金额")
    private BigDecimal amount;

    /** 用户id */
    @Excel(name = "用户id")
    private Object userId;

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
    public void setAmount(BigDecimal amount) 
    {
        this.amount = amount;
    }

    public BigDecimal getAmount() 
    {
        return amount;
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
            .append("applicationID", getApplicationID())
            .append("studentName", getStudentName())
            .append("applicationDate", getApplicationDate())
            .append("amount", getAmount())
            .append("userId", getUserId())
            .toString();
    }
}
