package com.grade.air.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 接送与寄存对象 yx_transportationstorage
 * 
 * @author l
 * @date 2023-06-04
 */
public class YxTransportationstorage extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 接送与寄存ID */
    private Long transportationStorageID;

    /** 学生姓名 */
    @Excel(name = "学生姓名")
    private String studentName;

    /** 服务类型 */
    @Excel(name = "服务类型")
    private String serviceType;

    /** 服务时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "服务时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date serviceTime;

    /** 服务地点 */
    @Excel(name = "服务地点")
    private String serviceLocation;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    public void setTransportationStorageID(Long transportationStorageID) 
    {
        this.transportationStorageID = transportationStorageID;
    }

    public Long getTransportationStorageID() 
    {
        return transportationStorageID;
    }
    public void setStudentName(String studentName) 
    {
        this.studentName = studentName;
    }

    public String getStudentName() 
    {
        return studentName;
    }
    public void setServiceType(String serviceType) 
    {
        this.serviceType = serviceType;
    }

    public String getServiceType() 
    {
        return serviceType;
    }
    public void setServiceTime(Date serviceTime) 
    {
        this.serviceTime = serviceTime;
    }

    public Date getServiceTime() 
    {
        return serviceTime;
    }
    public void setServiceLocation(String serviceLocation) 
    {
        this.serviceLocation = serviceLocation;
    }

    public String getServiceLocation() 
    {
        return serviceLocation;
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
            .append("transportationStorageID", getTransportationStorageID())
            .append("studentName", getStudentName())
            .append("serviceType", getServiceType())
            .append("serviceTime", getServiceTime())
            .append("serviceLocation", getServiceLocation())
            .append("userId", getUserId())
            .toString();
    }
}
