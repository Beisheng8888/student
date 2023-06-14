package com.grade.air.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学员通报对象 gz_studentdiscipline
 * 
 * @author l
 * @date 2023-06-04
 */
public class GzStudentdiscipline extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long recordID;

    /** 学生姓名 */
    @Excel(name = "学生姓名")
    private String studentName;

    /** 违纪日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "违纪日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date violationDate;

    /** 违纪内容 */
    @Excel(name = "违纪内容")
    private String violationContent;

    /** 处分措施 */
    @Excel(name = "处分措施")
    private String disciplinaryAction;

    /** 用户id */
    @Excel(name = "用户id")
    private Object userId;

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
    public void setViolationDate(Date violationDate) 
    {
        this.violationDate = violationDate;
    }

    public Date getViolationDate() 
    {
        return violationDate;
    }
    public void setViolationContent(String violationContent) 
    {
        this.violationContent = violationContent;
    }

    public String getViolationContent() 
    {
        return violationContent;
    }
    public void setDisciplinaryAction(String disciplinaryAction) 
    {
        this.disciplinaryAction = disciplinaryAction;
    }

    public String getDisciplinaryAction() 
    {
        return disciplinaryAction;
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
            .append("recordID", getRecordID())
            .append("studentName", getStudentName())
            .append("violationDate", getViolationDate())
            .append("violationContent", getViolationContent())
            .append("disciplinaryAction", getDisciplinaryAction())
            .append("userId", getUserId())
            .toString();
    }
}
