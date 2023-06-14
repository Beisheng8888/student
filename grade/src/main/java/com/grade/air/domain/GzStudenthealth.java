package com.grade.air.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学员健康对象 gz_studenthealth
 * 
 * @author l
 * @date 2023-06-04
 */
public class GzStudenthealth extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long recordID;

    /** 学生姓名 */
    @Excel(name = "学生姓名")
    private String studentName;

    /** 体检日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "体检日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date medicalDate;

    /** 身高 */
    @Excel(name = "身高")
    private BigDecimal height;

    /** 体重 */
    @Excel(name = "体重")
    private BigDecimal weight;

    /** 其他健康信息 */
    @Excel(name = "其他健康信息")
    private String otherHealthInfo;

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
    public void setMedicalDate(Date medicalDate) 
    {
        this.medicalDate = medicalDate;
    }

    public Date getMedicalDate() 
    {
        return medicalDate;
    }
    public void setHeight(BigDecimal height) 
    {
        this.height = height;
    }

    public BigDecimal getHeight() 
    {
        return height;
    }
    public void setWeight(BigDecimal weight) 
    {
        this.weight = weight;
    }

    public BigDecimal getWeight() 
    {
        return weight;
    }
    public void setOtherHealthInfo(String otherHealthInfo) 
    {
        this.otherHealthInfo = otherHealthInfo;
    }

    public String getOtherHealthInfo() 
    {
        return otherHealthInfo;
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
            .append("medicalDate", getMedicalDate())
            .append("height", getHeight())
            .append("weight", getWeight())
            .append("otherHealthInfo", getOtherHealthInfo())
            .append("userId", getUserId())
            .toString();
    }
}
