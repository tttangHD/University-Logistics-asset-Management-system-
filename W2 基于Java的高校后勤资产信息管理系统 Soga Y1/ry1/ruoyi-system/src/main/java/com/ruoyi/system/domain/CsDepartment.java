package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 科室管理模块，用于管理医院的科室信息。对象 cs_department
 * 
 * @author ruoyi
 * @date 2023-08-15
 */
public class CsDepartment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 科室ID */
    private Long id;

    /** 科室名称 */
    @Excel(name = "科室名称")
    private String name;

    /** 科室位置 */
    @Excel(name = "科室位置")
    private String location;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setLocation(String location) 
    {
        this.location = location;
    }

    public String getLocation() 
    {
        return location;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("location", getLocation())
            .toString();
    }
}
