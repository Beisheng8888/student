package com.grade.air.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 报到行政流程反馈对象 yx_op_registration_process
 * 
 * @author l
 * @date 2023-06-04
 */
public class YxOpRegistrationProcess extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long recordId;

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

    /** 审核状态 */
    @Excel(name = "审核状态")
    private String approvalStatus;

    /** 审核人 */
    @Excel(name = "审核人")
    private String approver;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    public void setRecordId(Long recordId) 
    {
        this.recordId = recordId;
    }

    public Long getRecordId() 
    {
        return recordId;
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
    public void setApprovalStatus(String approvalStatus) 
    {
        this.approvalStatus = approvalStatus;
    }

    public String getApprovalStatus() 
    {
        return approvalStatus;
    }
    public void setApprover(String approver) 
    {
        this.approver = approver;
    }

    public String getApprover() 
    {
        return approver;
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
            .append("recordId", getRecordId())
            .append("name", getName())
            .append("studentNumber", getStudentNumber())
            .append("submissionTime", getSubmissionTime())
            .append("arrivalTime", getArrivalTime())
            .append("arrivalLocation", getArrivalLocation())
            .append("approvalStatus", getApprovalStatus())
            .append("approver", getApprover())
            .append("userId", getUserId())
            .toString();
    }
}
