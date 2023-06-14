package com.grade.air.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学籍成绩对象 gz_academicrecords
 * 
 * @author l
 * @date 2023-06-04
 */
public class GzAcademicrecords extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long recordID;

    /** 学生姓名 */
    @Excel(name = "学生姓名")
    private String studentName;

    /** 课程姓名 */
    @Excel(name = "课程姓名")
    private String courseName;

    /** 成绩 */
    @Excel(name = "成绩")
    private BigDecimal grade;

    /** 班级排名 */
    @Excel(name = "班级排名")
    private Long classRank;

    /** 绩点 */
    @Excel(name = "绩点")
    private BigDecimal gpa;

    @Excel(name="姓名")
    private String  name;

    /** 用户id */
    @Excel(name = "用户id")
    private Object userId;
    private String aclass;
    public String getAclass() {
        return aclass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAclass(String aclass) {
        this.aclass = aclass;
    }
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
    public void setCourseName(String courseName) 
    {
        this.courseName = courseName;
    }

    public String getCourseName() 
    {
        return courseName;
    }
    public void setGrade(BigDecimal grade) 
    {
        this.grade = grade;
    }

    public BigDecimal getGrade() 
    {
        return grade;
    }
    public void setClassRank(Long classRank) 
    {
        this.classRank = classRank;
    }

    public Long getClassRank() 
    {
        return classRank;
    }
    public void setGpa(BigDecimal gpa) 
    {
        this.gpa = gpa;
    }

    public BigDecimal getGpa() 
    {
        return gpa;
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
            .append("courseName", getCourseName())
            .append("grade", getGrade())
            .append("classRank", getClassRank())
            .append("gpa", getGpa())
            .append("userId", getUserId())
            .append("aclass",getAclass())
            .append("name",getName())
            .toString();
    }
}
