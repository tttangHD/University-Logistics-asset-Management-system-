package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 报修审核对象 cs_repair_requests1
 * 
 * @author ruoyi
 * @date 2024-08-20
 */
public class CsRepairRequests1 extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 报修请求ID */
    private Long id;

    /** 提交报修请求的用户ID */
    @Excel(name = "提交报修请求的用户ID")
    private Long userId;

    /** 设备名称 */
    @Excel(name = "设备名称")
    private String equipmentName;

    /** 问题描述 */
    @Excel(name = "问题描述")
    private String problemDescription;

    /** 请求日期和时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "请求日期和时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date requestDate;

    /** 请求状态 */
    @Excel(name = "请求状态")
    private String status;
    
    /** 资产ID */
    @Excel(name = "资产ID")
    private Long assetId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setEquipmentName(String equipmentName) 
    {
        this.equipmentName = equipmentName;
    }

    public String getEquipmentName() 
    {
        return equipmentName;
    }
    public void setProblemDescription(String problemDescription) 
    {
        this.problemDescription = problemDescription;
    }

    public String getProblemDescription() 
    {
        return problemDescription;
    }
    public void setRequestDate(Date requestDate) 
    {
        this.requestDate = requestDate;
    }

    public Date getRequestDate() 
    {
        return requestDate;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    public void setAssetId(Long assetId) 
    {
        this.assetId = assetId;
    }

    public Long getAssetId() 
    {
        return assetId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("equipmentName", getEquipmentName())
            .append("problemDescription", getProblemDescription())
            .append("requestDate", getRequestDate())
            .append("status", getStatus())
            .append("assetId", getAssetId())
            .toString();
    }
}
