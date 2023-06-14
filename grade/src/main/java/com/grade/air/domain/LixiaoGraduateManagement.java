package com.grade.air.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 准毕业生管理数据对象 lixiao_graduate_management
 * 
 * @author l
 * @date 2023-06-04
 */
public class LixiaoGraduateManagement extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long studentId;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 学号 */
    @Excel(name = "学号")
    private String studentNumber;

    /** 专业 */
    @Excel(name = "专业")
    private String major;

    /** 入学日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "入学日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date enrollmentDate;

    /** 毕业日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "毕业日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date graduationDate;

    /** 毕业论文题目 */
    @Excel(name = "毕业论文题目")
    private String thesisTitle;

    /** 指导教师 */
    @Excel(name = "指导教师")
    private String supervisor;

    /** 毕业成绩 */
    @Excel(name = "毕业成绩")
    private BigDecimal gpa;

    /** 毕业证书号码 */
    @Excel(name = "毕业证书号码")
    private String certificateNumber;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    public void setStudentId(Long studentId) 
    {
        this.studentId = studentId;
    }

    public Long getStudentId() 
    {
        return studentId;
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
    public void setMajor(String major) 
    {
        this.major = major;
    }

    public String getMajor() 
    {
        return major;
    }
    public void setEnrollmentDate(Date enrollmentDate) 
    {
        this.enrollmentDate = enrollmentDate;
    }

    public Date getEnrollmentDate() 
    {
        return enrollmentDate;
    }
    public void setGraduationDate(Date graduationDate) 
    {
        this.graduationDate = graduationDate;
    }

    public Date getGraduationDate() 
    {
        return graduationDate;
    }
    public void setThesisTitle(String thesisTitle) 
    {
        this.thesisTitle = thesisTitle;
    }

    public String getThesisTitle() 
    {
        return thesisTitle;
    }
    public void setSupervisor(String supervisor) 
    {
        this.supervisor = supervisor;
    }

    public String getSupervisor() 
    {
        return supervisor;
    }
    public void setGpa(BigDecimal gpa) 
    {
        this.gpa = gpa;
    }

    public BigDecimal getGpa() 
    {
        return gpa;
    }
    public void setCertificateNumber(String certificateNumber) 
    {
        this.certificateNumber = certificateNumber;
    }

    public String getCertificateNumber() 
    {
        return certificateNumber;
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
            .append("studentId", getStudentId())
            .append("name", getName())
            .append("studentNumber", getStudentNumber())
            .append("major", getMajor())
            .append("enrollmentDate", getEnrollmentDate())
            .append("graduationDate", getGraduationDate())
            .append("thesisTitle", getThesisTitle())
            .append("supervisor", getSupervisor())
            .append("gpa", getGpa())
            .append("certificateNumber", getCertificateNumber())
            .append("userId", getUserId())
            .toString();
    }
}
