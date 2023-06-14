package com.grade.air.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 网络故障保修对象 ss_network_fault_repair_application
 * 
 * @author l
 * @date 2023-06-04
 */
public class SsNetworkFaultRepairApplication extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 申请编号 */
    private Long applicationId;

    /** 宿舍名称 */
    @Excel(name = "宿舍名称")
    private String dormitoryName;

    /** 报修日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "报修日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date reportDate;

    /** 报修描述 */
    @Excel(name = "报修描述")
    private String reportDescription;

    public void setApplicationId(Long applicationId) 
    {
        this.applicationId = applicationId;
    }

    public Long getApplicationId() 
    {
        return applicationId;
    }
    public void setDormitoryName(String dormitoryName) 
    {
        this.dormitoryName = dormitoryName;
    }

    public String getDormitoryName() 
    {
        return dormitoryName;
    }
    public void setReportDate(Date reportDate) 
    {
        this.reportDate = reportDate;
    }

    public Date getReportDate() 
    {
        return reportDate;
    }
    public void setReportDescription(String reportDescription) 
    {
        this.reportDescription = reportDescription;
    }

    public String getReportDescription() 
    {
        return reportDescription;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("applicationId", getApplicationId())
            .append("dormitoryName", getDormitoryName())
            .append("reportDate", getReportDate())
            .append("reportDescription", getReportDescription())
            .toString();
    }
}
