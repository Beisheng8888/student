package com.grade.air.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学校信息对象 yx_schoolinformation
 * 
 * @author l
 * @date 2023-06-04
 */
public class YxSchoolinformation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 信息ID */
    private Long informationID;

    /** 学校概况 */
    @Excel(name = "学校概况")
    private String studentTitle;

    /** 学校政策 */
    @Excel(name = "学校政策")
    private String studentContent;

    /** 学校活动 */
    @Excel(name = "学校活动")
    private String studentName;

    public void setInformationID(Long informationID) 
    {
        this.informationID = informationID;
    }

    public Long getInformationID() 
    {
        return informationID;
    }
    public void setStudentTitle(String studentTitle) 
    {
        this.studentTitle = studentTitle;
    }

    public String getStudentTitle() 
    {
        return studentTitle;
    }
    public void setStudentContent(String studentContent) 
    {
        this.studentContent = studentContent;
    }

    public String getStudentContent() 
    {
        return studentContent;
    }
    public void setStudentName(String studentName) 
    {
        this.studentName = studentName;
    }

    public String getStudentName() 
    {
        return studentName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("informationID", getInformationID())
            .append("studentTitle", getStudentTitle())
            .append("studentContent", getStudentContent())
            .append("studentName", getStudentName())
            .toString();
    }
}
