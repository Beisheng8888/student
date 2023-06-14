package com.grade.air.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 奖惩通告对象 lq_awardsandpenalties
 * 
 * @author l
 * @date 2023-06-04
 */
public class LqAwardsandpenalties extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long studentID;

    /** 类型（荣誉奖励或违纪处罚） */
    @Excel(name = "类型", readConverterExp = "荣=誉奖励或违纪处罚")
    private String type;

    /** 处理方案 */
    @Excel(name = "处理方案")
    private String description;

    public void setStudentID(Long studentID) 
    {
        this.studentID = studentID;
    }

    public Long getStudentID() 
    {
        return studentID;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("studentID", getStudentID())
            .append("type", getType())
            .append("description", getDescription())
            .toString();
    }
}
