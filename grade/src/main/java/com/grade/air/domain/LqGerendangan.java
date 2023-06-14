package com.grade.air.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学生档案维护对象 lq_gerendangan
 * 
 * @author l
 * @date 2023-06-04
 */
public class LqGerendangan extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 性别 */
    @Excel(name = "性别")
    private String gender;

    /** 出生日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "出生日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date dateBirth;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String idcardNumber;

    /** 家庭住址 */
    @Excel(name = "家庭住址")
    private String homeAddress;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String contactNumber;

    /** 电子邮箱 */
    @Excel(name = "电子邮箱")
    private String email;

    /** 存照 */
    @Excel(name = "存照")
    private String avatar;

    /** 学制 */
    @Excel(name = "学制")
    private String academicSystem;

    /** 所属院系 */
    @Excel(name = "所属院系")
    private String department;

    /** 专业 */
    @Excel(name = "专业")
    private String major;

    /** 是否存在违纪 */
    @Excel(name = "是否存在违纪")
    private String type;

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
    private Object userId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setGender(String gender) 
    {
        this.gender = gender;
    }

    public String getGender() 
    {
        return gender;
    }
    public void setDateBirth(Date dateBirth) 
    {
        this.dateBirth = dateBirth;
    }

    public Date getDateBirth() 
    {
        return dateBirth;
    }
    public void setIdcardNumber(String idcardNumber) 
    {
        this.idcardNumber = idcardNumber;
    }

    public String getIdcardNumber() 
    {
        return idcardNumber;
    }
    public void setHomeAddress(String homeAddress) 
    {
        this.homeAddress = homeAddress;
    }

    public String getHomeAddress() 
    {
        return homeAddress;
    }
    public void setContactNumber(String contactNumber) 
    {
        this.contactNumber = contactNumber;
    }

    public String getContactNumber() 
    {
        return contactNumber;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }
    public void setAvatar(String avatar) 
    {
        this.avatar = avatar;
    }

    public String getAvatar() 
    {
        return avatar;
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
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
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
            .append("id", getId())
            .append("name", getName())
            .append("gender", getGender())
            .append("dateBirth", getDateBirth())
            .append("idcardNumber", getIdcardNumber())
            .append("homeAddress", getHomeAddress())
            .append("contactNumber", getContactNumber())
            .append("email", getEmail())
            .append("avatar", getAvatar())
            .append("academicSystem", getAcademicSystem())
            .append("department", getDepartment())
            .append("major", getMajor())
            .append("type", getType())
            .append("subject", getSubject())
            .append("grade", getGrade())
            .append("gpa", getGpa())
            .append("rank", getRank())
            .append("credits", getCredits())
            .append("userId", getUserId())
            .toString();
    }
}
