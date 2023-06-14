package com.grade.air.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 数据集成对象 per_integration
 * 
 * @author l
 * @date 2023-06-04
 */
public class PerIntegration extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 民族 */
    @Excel(name = "民族")
    private Long ethnicity;

    /** 人数 */
    @Excel(name = "人数")
    private Long nnt;

    /** 成绩 */
    @Excel(name = "成绩")
    private Long result;

    /** 课程 */
    @Excel(name = "课程")
    private Long elective;

    /** 班级 */
    @Excel(name = "班级")
    private String gradeName;

    /** 学院 */
    @Excel(name = "学院")
    private String 学院;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setEthnicity(Long ethnicity) 
    {
        this.ethnicity = ethnicity;
    }

    public Long getEthnicity() 
    {
        return ethnicity;
    }
    public void setNnt(Long nnt) 
    {
        this.nnt = nnt;
    }

    public Long getNnt() 
    {
        return nnt;
    }
    public void setResult(Long result) 
    {
        this.result = result;
    }

    public Long getResult() 
    {
        return result;
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
    public void set学院(String 学院) 
    {
        this.学院 = 学院;
    }

    public String get学院() 
    {
        return 学院;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("ethnicity", getEthnicity())
            .append("nnt", getNnt())
            .append("result", getResult())
            .append("elective", getElective())
            .append("gradeName", getGradeName())
            .append("学院", get学院())
            .toString();
    }
}
