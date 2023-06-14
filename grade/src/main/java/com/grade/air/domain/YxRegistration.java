package com.grade.air.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 预报到登记反馈对象 yx_registration
 * 
 * @author l
 * @date 2023-06-04
 */
public class YxRegistration extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 预报到登记ID */
    private Long registrationID;

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

    /** 审核结果 */
    @Excel(name = "审核结果")
    private String approvalStatus;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    public void setRegistrationID(Long registrationID) 
    {
        this.registrationID = registrationID;
    }

    public Long getRegistrationID() 
    {
        return registrationID;
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
    public void setApprovalStatus(String approvalStatus) 
    {
        this.approvalStatus = approvalStatus;
    }

    public String getApprovalStatus() 
    {
        return approvalStatus;
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
            .append("registrationID", getRegistrationID())
            .append("studentName", getStudentName())
            .append("trainNumber", getTrainNumber())
            .append("flightNumber", getFlightNumber())
            .append("arrivalTime", getArrivalTime())
            .append("pickupLocation", getPickupLocation())
            .append("approvalStatus", getApprovalStatus())
            .append("userId", getUserId())
            .toString();
    }
}
