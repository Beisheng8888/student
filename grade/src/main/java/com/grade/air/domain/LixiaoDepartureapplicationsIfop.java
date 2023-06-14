package com.grade.air.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 离校审核结果对象 lixiao_departureapplications_ifop
 * 
 * @author l
 * @date 2023-06-04
 */
public class LixiaoDepartureapplicationsIfop extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

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

    /** 审核状态 */
    @Excel(name = "审核状态")
    private String status;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** 审核结果 */
    @Excel(name = "审核结果")
    private String statusSjfh;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
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
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setStatusSjfh(String statusSjfh) 
    {
        this.statusSjfh = statusSjfh;
    }

    public String getStatusSjfh() 
    {
        return statusSjfh;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("studentName", getStudentName())
            .append("applicationDate", getApplicationDate())
            .append("departureDate", getDepartureDate())
            .append("reason", getReason())
            .append("status", getStatus())
            .append("userId", getUserId())
            .append("statusSjfh", getStatusSjfh())
            .toString();
    }
}
