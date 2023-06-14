package com.grade.air.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学习情况对象 lq_academicrecords
 * 
 * @author l
 * @date 2023-06-04
 */
public class LqAcademicrecords extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long studentID;

    /** 学科 */
    @Excel(name = "学科")
    private String subject;

    /** 成绩 */
    @Excel(name = "成绩")
    private String grade;

    /** 绩点 */
    @Excel(name = "绩点")
    private String gpa;

    /** 排名 */
    @Excel(name = "排名")
    private Long rank;

    /** 学分 */
    @Excel(name = "学分")
    private Long credits;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** 学生姓名 */
    @Excel(name = "学生姓名")
    private String studentName;

    public void setStudentID(Long studentID) 
    {
        this.studentID = studentID;
    }

    public Long getStudentID() 
    {
        return studentID;
    }
    public void setSubject(String subject) 
    {
        this.subject = subject;
    }

    public String getSubject() 
    {
        return subject;
    }
    public void setGrade(String grade) 
    {
        this.grade = grade;
    }

    public String getGrade() 
    {
        return grade;
    }
    public void setGpa(String gpa) 
    {
        this.gpa = gpa;
    }

    public String getGpa() 
    {
        return gpa;
    }
    public void setRank(Long rank) 
    {
        this.rank = rank;
    }

    public Long getRank() 
    {
        return rank;
    }
    public void setCredits(Long credits) 
    {
        this.credits = credits;
    }

    public Long getCredits() 
    {
        return credits;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setStudentName(String studentName) 
    {
        this.studentName = studentName;
    }

    public String getStudentName() 
    {
        return studentName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("studentID", getStudentID())
            .append("subject", getSubject())
            .append("grade", getGrade())
            .append("gpa", getGpa())
            .append("rank", getRank())
            .append("credits", getCredits())
            .append("userId", getUserId())
            .append("studentName", getStudentName())
            .toString();
    }
}
