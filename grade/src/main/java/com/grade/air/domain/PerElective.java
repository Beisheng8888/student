package com.grade.air.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学员成绩对象 per_elective
 * 
 * @author l
 * @date 2023-06-04
 */
public class PerElective extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 通识教育 */
    @Excel(name = "通识教育")
    private Long liberal;

    /** 专业必修 */
    @Excel(name = "专业必修")
    private Long major;

    /** 选修课程 */
    @Excel(name = "选修课程")
    private Long elective;

    /** 班级 */
    @Excel(name = "班级")
    private String gradeName;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setLiberal(Long liberal) 
    {
        this.liberal = liberal;
    }

    public Long getLiberal() 
    {
        return liberal;
    }
    public void setMajor(Long major) 
    {
        this.major = major;
    }

    public Long getMajor() 
    {
        return major;
    }
    public void setElective(Long elective) 
    {
        this.elective = elective;
    }

    public Long getElective() 
    {
        return elective;
    }
    public void setGradeName(String gradeName) 
    {
        this.gradeName = gradeName;
    }

    public String getGradeName() 
    {
        return gradeName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("liberal", getLiberal())
            .append("major", getMajor())
            .append("elective", getElective())
            .append("gradeName", getGradeName())
            .toString();
    }
}
