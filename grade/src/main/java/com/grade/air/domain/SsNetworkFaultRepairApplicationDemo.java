package com.grade.air.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 网络故障保修反馈对象 ss_network_fault_repair_application_demo
 * 
 * @author l
 * @date 2023-06-04
 */
public class SsNetworkFaultRepairApplicationDemo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

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

    /** 处理状态 */
    @Excel(name = "处理状态")
    private Integer status;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
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
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("dormitoryName", getDormitoryName())
            .append("reportDate", getReportDate())
            .append("reportDescription", getReportDescription())
            .append("status", getStatus())
            .toString();
    }
}
