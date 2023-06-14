package com.grade.air.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 档案查询对象 student_records
 * 
 * @author l
 * @date 2023-06-05
 */
public class StudentRecords extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long studentId;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 性别 */
    @Excel(name = "性别")
    private String gender;

    /**  学生出生日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = " 学生出生日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date dateOfBirth;

    /** 学生地址 */
    @Excel(name = "学生地址")
    private String address;

    /** 学生联系电话 */
    @Excel(name = "学生联系电话")
    private String phoneNumber;

    /** 学生电子邮件地址 */
    @Excel(name = "学生电子邮件地址")
    private String email;

    /** 学生监护人姓名 */
    @Excel(name = "学生监护人姓名")
    private String guardianName;

    /** 学生监护人联系电话 */
    @Excel(name = "学生监护人联系电话")
    private String guardianPhone;

    /** 入学日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "入学日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date admissionDate;

    /** 毕业日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "毕业日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date graduationDate;

    /** 学生所属班级 */
    @Excel(name = "学生所属班级")
    private String aclass;

    /** 学生所修专业 */
    @Excel(name = "学生所修专业")
    private String major;

    /** 先前就读学校 */
    @Excel(name = "先前就读学校")
    private String previousSchool;

    /** 学生所属学年 */
    @Excel(name = "学生所属学年")
    private Long academicYear;

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
    public void setGender(String gender) 
    {
        this.gender = gender;
    }

    public String getGender() 
    {
        return gender;
    }
    public void setDateOfBirth(Date dateOfBirth) 
    {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getDateOfBirth() 
    {
        return dateOfBirth;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setPhoneNumber(String phoneNumber) 
    {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() 
    {
        return phoneNumber;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }
    public void setGuardianName(String guardianName) 
    {
        this.guardianName = guardianName;
    }

    public String getGuardianName() 
    {
        return guardianName;
    }
    public void setGuardianPhone(String guardianPhone) 
    {
        this.guardianPhone = guardianPhone;
    }

    public String getGuardianPhone() 
    {
        return guardianPhone;
    }
    public void setAdmissionDate(Date admissionDate) 
    {
        this.admissionDate = admissionDate;
    }

    public Date getAdmissionDate() 
    {
        return admissionDate;
    }
    public void setGraduationDate(Date graduationDate) 
    {
        this.graduationDate = graduationDate;
    }

    public Date getGraduationDate() 
    {
        return graduationDate;
    }
    public void setAclass(String aclass) 
    {
        this.aclass = aclass;
    }

    public String getAclass() 
    {
        return aclass;
    }
    public void setMajor(String major) 
    {
        this.major = major;
    }

    public String getMajor() 
    {
        return major;
    }
    public void setPreviousSchool(String previousSchool) 
    {
        this.previousSchool = previousSchool;
    }

    public String getPreviousSchool() 
    {
        return previousSchool;
    }
    public void setAcademicYear(Long academicYear) 
    {
        this.academicYear = academicYear;
    }

    public Long getAcademicYear() 
    {
        return academicYear;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("studentId", getStudentId())
            .append("name", getName())
            .append("gender", getGender())
            .append("dateOfBirth", getDateOfBirth())
            .append("address", getAddress())
            .append("phoneNumber", getPhoneNumber())
            .append("email", getEmail())
            .append("guardianName", getGuardianName())
            .append("guardianPhone", getGuardianPhone())
            .append("admissionDate", getAdmissionDate())
            .append("graduationDate", getGraduationDate())
            .append("aclass", getAclass())
            .append("major", getMajor())
            .append("previousSchool", getPreviousSchool())
            .append("academicYear", getAcademicYear())
            .toString();
    }
}
