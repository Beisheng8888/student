package com.grade.air.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学员奖惩对象 gz_rewardspunishments
 * 
 * @author l
 * @date 2023-06-04
 */
public class GzRewardspunishments extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long recordID;

    /** 学生姓名 */
    @Excel(name = "学生姓名")
    private String studentName;

    /** 奖惩类型 */
    @Excel(name = "奖惩类型")
    private String type;

    /** 奖惩日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "奖惩日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date date;

    /** 奖惩原因 */
    @Excel(name = "奖惩原因")
    private String reason;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    public void setRecordID(Long recordID) 
    {
        this.recordID = recordID;
    }

    public Long getRecordID() 
    {
        return recordID;
    }
    public void setStudentName(String studentName) 
    {
        this.studentName = studentName;
    }

    public String getStudentName() 
    {
        return studentName;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setDate(Date date) 
    {
        this.date = date;
    }

    public Date getDate() 
    {
        return date;
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
            .append("recordID", getRecordID())
            .append("studentName", getStudentName())
            .append("type", getType())
            .append("date", getDate())
            .append("reason", getReason())
            .append("userId", getUserId())
            .toString();
    }
}
