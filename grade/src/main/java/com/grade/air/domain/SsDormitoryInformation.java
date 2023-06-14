package com.grade.air.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 宿舍信息对象 ss_dormitory_information
 * 
 * @author l
 * @date 2023-06-04
 */
public class SsDormitoryInformation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 宿舍编号 */
    private Long dormitoryId;

    /** 宿舍名称 */
    @Excel(name = "宿舍名称")
    private String dormitoryName;

    /** 楼栋 */
    @Excel(name = "楼栋")
    private String building;

    /** 楼层 */
    @Excel(name = "楼层")
    private Long floor;

    /** 学生姓名 */
    @Excel(name = "学生姓名")
    private String studentName;

    /** 用户id */
    @Excel(name = "用户id")
    private Object userId;

    public void setDormitoryId(Long dormitoryId) 
    {
        this.dormitoryId = dormitoryId;
    }

    public Long getDormitoryId() 
    {
        return dormitoryId;
    }
    public void setDormitoryName(String dormitoryName) 
    {
        this.dormitoryName = dormitoryName;
    }

    public String getDormitoryName() 
    {
        return dormitoryName;
    }
    public void setBuilding(String building) 
    {
        this.building = building;
    }

    public String getBuilding() 
    {
        return building;
    }
    public void setFloor(Long floor) 
    {
        this.floor = floor;
    }

    public Long getFloor() 
    {
        return floor;
    }
    public void setStudentName(String studentName) 
    {
        this.studentName = studentName;
    }

    public String getStudentName() 
    {
        return studentName;
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
            .append("dormitoryId", getDormitoryId())
            .append("dormitoryName", getDormitoryName())
            .append("building", getBuilding())
            .append("floor", getFloor())
            .append("studentName", getStudentName())
            .append("userId", getUserId())
            .toString();
    }
}
