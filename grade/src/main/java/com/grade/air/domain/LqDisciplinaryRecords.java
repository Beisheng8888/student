package com.grade.air.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 个人违纪处分对象 lq_disciplinary_records
 * 
 * @author l
 * @date 2023-06-04
 */
public class LqDisciplinaryRecords extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long recordId;

    /** 学生姓名 */
    @Excel(name = "学生姓名")
    private String studentName;

    /** 违纪日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "违纪日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date recordDate;

    /** 违纪行为 */
    @Excel(name = "违纪行为")
    private String behavior;

    /** 违纪地点 */
    @Excel(name = "违纪地点")
    private String location;

    /** 处罚措施 */
    @Excel(name = "处罚措施")
    private String punishment;

    /** 责任人 */
    @Excel(name = "责任人")
    private String responsiblePerson;

    /** 处理结果 */
    @Excel(name = "处理结果")
    private String result;

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
    public void setRecordDate(Date recordDate) 
    {
        this.recordDate = recordDate;
    }

    public Date getRecordDate() 
    {
        return recordDate;
    }
    public void setBehavior(String behavior) 
    {
        this.behavior = behavior;
    }

    public String getBehavior() 
    {
        return behavior;
    }
    public void setLocation(String location) 
    {
        this.location = location;
    }

    public String getLocation() 
    {
        return location;
    }
    public void setPunishment(String punishment) 
    {
        this.punishment = punishment;
    }

    public String getPunishment() 
    {
        return punishment;
    }
    public void setResponsiblePerson(String responsiblePerson) 
    {
        this.responsiblePerson = responsiblePerson;
    }

    public String getResponsiblePerson() 
    {
        return responsiblePerson;
    }
    public void setResult(String result) 
    {
        this.result = result;
    }

    public String getResult() 
    {
        return result;
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
            .append("recordDate", getRecordDate())
            .append("behavior", getBehavior())
            .append("location", getLocation())
            .append("punishment", getPunishment())
            .append("responsiblePerson", getResponsiblePerson())
            .append("result", getResult())
            .append("userId", getUserId())
            .toString();
    }
}
