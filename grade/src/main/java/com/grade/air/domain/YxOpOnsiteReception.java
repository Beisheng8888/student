package com.grade.air.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 现场接待数据对象 yx_op_onsite_reception
 * 
 * @author l
 * @date 2023-06-04
 */
public class YxOpOnsiteReception extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long recordId;

    /** 学生姓名 */
    @Excel(name = "学生姓名")
    private String studentName;

    /** 接待人员 */
    @Excel(name = "接待人员")
    private String receptionist;

    /** 接待日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "接待日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date receptionDate;

    /** 接待时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "接待时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date receptionTime;

    /** 问题描述 */
    @Excel(name = "问题描述")
    private String issueDescription;

    /** 接待备注 */
    @Excel(name = "接待备注")
    private String receptionRemarks;

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
    public void setStudentName(String studentName) 
    {
        this.studentName = studentName;
    }

    public String getStudentName() 
    {
        return studentName;
    }
    public void setReceptionist(String receptionist) 
    {
        this.receptionist = receptionist;
    }

    public String getReceptionist() 
    {
        return receptionist;
    }
    public void setReceptionDate(Date receptionDate) 
    {
        this.receptionDate = receptionDate;
    }

    public Date getReceptionDate() 
    {
        return receptionDate;
    }
    public void setReceptionTime(Date receptionTime) 
    {
        this.receptionTime = receptionTime;
    }

    public Date getReceptionTime() 
    {
        return receptionTime;
    }
    public void setIssueDescription(String issueDescription) 
    {
        this.issueDescription = issueDescription;
    }

    public String getIssueDescription() 
    {
        return issueDescription;
    }
    public void setReceptionRemarks(String receptionRemarks) 
    {
        this.receptionRemarks = receptionRemarks;
    }

    public String getReceptionRemarks() 
    {
        return receptionRemarks;
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
            .append("studentName", getStudentName())
            .append("receptionist", getReceptionist())
            .append("receptionDate", getReceptionDate())
            .append("receptionTime", getReceptionTime())
            .append("issueDescription", getIssueDescription())
            .append("receptionRemarks", getReceptionRemarks())
            .append("userId", getUserId())
            .toString();
    }
}
