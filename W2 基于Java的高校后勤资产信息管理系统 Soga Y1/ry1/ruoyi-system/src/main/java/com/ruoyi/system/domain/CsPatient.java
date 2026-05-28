package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 患者管理模块，用于管理患者的信息。对象 cs_patient
 * 
 * @author ruoyi
 * @date 2023-08-15
 */
public class CsPatient extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 患者ID */
    private Long id;

    /** 患者姓名 */
    @Excel(name = "患者姓名")
    private String name;

    /** 患者年龄 */
    @Excel(name = "患者年龄")
    private Long age;

    /** 患者性别 */
    @Excel(name = "患者性别")
    private String gender;

    /** 患者地址 */
    @Excel(name = "患者地址")
    private String address;

    /** 患者联系方式 */
    @Excel(name = "患者联系方式")
    private String contactNumber;

    /** 病历记录 */
    @Excel(name = "病历记录")
    private String medicalHistory;

    /** 就诊历史 */
    @Excel(name = "就诊历史")
    private String visitHistory;

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
    public void setAge(Long age) 
    {
        this.age = age;
    }

    public Long getAge() 
    {
        return age;
    }
    public void setGender(String gender) 
    {
        this.gender = gender;
    }

    public String getGender() 
    {
        return gender;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setContactNumber(String contactNumber) 
    {
        this.contactNumber = contactNumber;
    }

    public String getContactNumber() 
    {
        return contactNumber;
    }
    public void setMedicalHistory(String medicalHistory) 
    {
        this.medicalHistory = medicalHistory;
    }

    public String getMedicalHistory() 
    {
        return medicalHistory;
    }
    public void setVisitHistory(String visitHistory) 
    {
        this.visitHistory = visitHistory;
    }

    public String getVisitHistory() 
    {
        return visitHistory;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("age", getAge())
            .append("gender", getGender())
            .append("address", getAddress())
            .append("contactNumber", getContactNumber())
            .append("medicalHistory", getMedicalHistory())
            .append("visitHistory", getVisitHistory())
            .toString();
    }
}
