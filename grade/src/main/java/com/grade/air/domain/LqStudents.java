package com.grade.air.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学生信息对象 lq_students
 * 
 * @author l
 * @date 2023-06-04
 */
public class LqStudents extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long studentID;

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

    /** 民族 */
    @Excel(name = "民族")
    private String ethnicity;

    /** 籍贯 */
    @Excel(name = "籍贯")
    private String hometown;

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
    public void setEthnicity(String ethnicity) 
    {
        this.ethnicity = ethnicity;
    }

    public String getEthnicity() 
    {
        return ethnicity;
    }
    public void setHometown(String hometown) 
    {
        this.hometown = hometown;
    }

    public String getHometown() 
    {
        return hometown;
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
            .append("name", getName())
            .append("gender", getGender())
            .append("dateBirth", getDateBirth())
            .append("idcardNumber", getIdcardNumber())
            .append("ethnicity", getEthnicity())
            .append("hometown", getHometown())
            .append("homeAddress", getHomeAddress())
            .append("contactNumber", getContactNumber())
            .append("email", getEmail())
            .append("avatar", getAvatar())
            .append("userId", getUserId())
            .toString();
    }
}
