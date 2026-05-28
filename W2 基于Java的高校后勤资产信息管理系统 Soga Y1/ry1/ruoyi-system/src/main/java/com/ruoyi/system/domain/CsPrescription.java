package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 处方管理模块，用于管理医生开具的处方信息。对象 cs_prescription
 * 
 * @author ruoyi
 * @date 2023-08-15
 */
public class CsPrescription extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 处方ID */
    private Long id;

    /** 患者ID */
    @Excel(name = "患者ID")
    private Long patientId;

    /** 医生ID */
    @Excel(name = "医生ID")
    private Long doctorId;

    /** 药品 */
    @Excel(name = "药品")
    private String medication;

    /** 剂量 */
    @Excel(name = "剂量")
    private String dosage;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setPatientId(Long patientId) 
    {
        this.patientId = patientId;
    }

    public Long getPatientId() 
    {
        return patientId;
    }
    public void setDoctorId(Long doctorId) 
    {
        this.doctorId = doctorId;
    }

    public Long getDoctorId() 
    {
        return doctorId;
    }
    public void setMedication(String medication) 
    {
        this.medication = medication;
    }

    public String getMedication() 
    {
        return medication;
    }
    public void setDosage(String dosage) 
    {
        this.dosage = dosage;
    }

    public String getDosage() 
    {
        return dosage;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("patientId", getPatientId())
            .append("doctorId", getDoctorId())
            .append("medication", getMedication())
            .append("dosage", getDosage())
            .toString();
    }
}
