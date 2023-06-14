package com.grade.air.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学籍情况对象 lq_enrollment
 * 
 * @author l
 * @date 2023-06-04
 */
public class LqEnrollment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long studentID;

    /** 班级 */
    @Excel(name = "班级")
    private String gradeClass;

    /** 入学时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "入学时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date admissionDate;

    /** 学制 */
    @Excel(name = "学制")
    private String academicSystem;

    /** 所属院系 */
    @Excel(name = "所属院系")
    private String department;

    /** 专业 */
    @Excel(name = "专业")
    private String major;

    /** 学生姓名 */
    @Excel(name = "学生姓名")
    private String studentName;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    public void setStudentID(Long studentID) 
    {
        this.studentID = studentID;
    }

    public Long getStudentID() 
    {
        return studentID;
    }
    public void setGradeClass(String gradeClass) 
    {
        this.gradeClass = gradeClass;
    }

    public String getGradeClass() 
    {
        return gradeClass;
    }
    public void setAdmissionDate(Date admissionDate) 
    {
        this.admissionDate = admissionDate;
    }

    public Date getAdmissionDate() 
    {
        return admissionDate;
    }
    public void setAcademicSystem(String academicSystem) 
    {
        this.academicSystem = academicSystem;
    }

    public String getAcademicSystem() 
    {
        return academicSystem;
    }
    public void setDepartment(String department) 
    {
        this.department = department;
    }

    public String getDepartment() 
    {
        return department;
    }
    public void setMajor(String major) 
    {
        this.major = major;
    }

    public String getMajor() 
    {
        return major;
    }
    public void setStudentName(String studentName) 
    {
        this.studentName = studentName;
    }

    public String getStudentName() 
    {
        return studentName;
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
            .append("studentID", getStudentID())
            .append("gradeClass", getGradeClass())
            .append("admissionDate", getAdmissionDate())
            .append("academicSystem", getAcademicSystem())
            .append("department", getDepartment())
            .append("major", getMajor())
            .append("studentName", getStudentName())
            .append("userId", getUserId())
            .toString();
    }
}
