package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 挂号管理模块，用于管理患者的挂号信息。对象 cs_registration
 * 
 * @author ruoyi
 * @date 2023-08-15
 */
public class CsRegistration extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 挂号ID */
    private Long id;

    /** 患者ID */
    @Excel(name = "患者ID")
    private Long patientId;

    /** 医生ID */
    @Excel(name = "医生ID")
    private Long doctorId;

    /** 科室ID */
    @Excel(name = "科室ID")
    private Long departmentId;

    /** 挂号日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "挂号日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date date;

    /** 时间段 */
    @Excel(name = "时间段")
    private String timeSlot;

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
    public void setDepartmentId(Long departmentId) 
    {
        this.departmentId = departmentId;
    }

    public Long getDepartmentId() 
    {
        return departmentId;
    }
    public void setDate(Date date) 
    {
        this.date = date;
    }

    public Date getDate() 
    {
        return date;
    }
    public void setTimeSlot(String timeSlot) 
    {
        this.timeSlot = timeSlot;
    }

    public String getTimeSlot() 
    {
        return timeSlot;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("patientId", getPatientId())
            .append("doctorId", getDoctorId())
            .append("departmentId", getDepartmentId())
            .append("date", getDate())
            .append("timeSlot", getTimeSlot())
            .toString();
    }
}
