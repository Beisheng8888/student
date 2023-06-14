package com.grade.air.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 预报到登记对象 yx_registration_opgh
 * 
 * @author l
 * @date 2023-06-04
 */
public class YxRegistrationOpgh extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 学生姓名 */
    @Excel(name = "学生姓名")
    private String studentName;

    /** 车次 */
    @Excel(name = "车次")
    private String trainNumber;

    /** 航班号 */
    @Excel(name = "航班号")
    private String flightNumber;

    /** 到达时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "到达时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date arrivalTime;

    /** 接站地点 */
    @Excel(name = "接站地点")
    private String pickupLocation;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setStudentName(String studentName) 
    {
        this.studentName = studentName;
    }

    public String getStudentName() 
    {
        return studentName;
    }
    public void setTrainNumber(String trainNumber) 
    {
        this.trainNumber = trainNumber;
    }

    public String getTrainNumber() 
    {
        return trainNumber;
    }
    public void setFlightNumber(String flightNumber) 
    {
        this.flightNumber = flightNumber;
    }

    public String getFlightNumber() 
    {
        return flightNumber;
    }
    public void setArrivalTime(Date arrivalTime) 
    {
        this.arrivalTime = arrivalTime;
    }

    public Date getArrivalTime() 
    {
        return arrivalTime;
    }
    public void setPickupLocation(String pickupLocation) 
    {
        this.pickupLocation = pickupLocation;
    }

    public String getPickupLocation() 
    {
        return pickupLocation;
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
            .append("id", getId())
            .append("studentName", getStudentName())
            .append("trainNumber", getTrainNumber())
            .append("flightNumber", getFlightNumber())
            .append("arrivalTime", getArrivalTime())
            .append("pickupLocation", getPickupLocation())
            .append("userId", getUserId())
            .toString();
    }
}
