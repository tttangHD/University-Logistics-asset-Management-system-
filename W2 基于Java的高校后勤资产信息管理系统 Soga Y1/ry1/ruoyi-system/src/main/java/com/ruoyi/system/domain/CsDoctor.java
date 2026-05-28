package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 医生管理模块，用于管理医生的信息。对象 cs_doctor
 * 
 * @author ruoyi
 * @date 2023-08-15
 */
public class CsDoctor extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 医生ID */
    private Long id;

    /** 医生姓名 */
    @Excel(name = "医生姓名")
    private String name;

    /** 医生专长 */
    @Excel(name = "医生专长")
    private String specialization;

    /** 医生联系方式 */
    @Excel(name = "医生联系方式")
    private String contactNumber;

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
    public void setSpecialization(String specialization) 
    {
        this.specialization = specialization;
    }

    public String getSpecialization() 
    {
        return specialization;
    }
    public void setContactNumber(String contactNumber) 
    {
        this.contactNumber = contactNumber;
    }

    public String getContactNumber() 
    {
        return contactNumber;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("specialization", getSpecialization())
            .append("contactNumber", getContactNumber())
            .toString();
    }
}
