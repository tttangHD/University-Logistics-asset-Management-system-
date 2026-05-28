package com.ruoyi.system.domain;

import java.util.Date;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 资产数据详情对象 cs_asset_details
 *
 * @author ruoyi
 * @date 2024-08-20
 */
public class CsAssetDetails extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 资产详情ID */
    private Long id;

    /** 资产ID */
    @Excel(name = "资产ID")
    private Long assetId;

    /** 资产名称 */
    @Excel(name = "资产名称")
    private String assetName;

    /** 资产类型 */
    @Excel(name = "资产类型")
    private String assetType;

    /** 序列号 */
    @Excel(name = "序列号")
    private String serialNumber;

    /** 购买日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "购买日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date purchaseDate;

    /** 保修到期日 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "保修到期日", width = 30, dateFormat = "yyyy-MM-dd")
    private Date warrantyExpiry;

    /** 价值 */
    @Excel(name = "价值")
    private BigDecimal value;

    /** 资产状态 */
    @Excel(name = "资产状态")
    private String status;

    /** 维护记录 */
    @Excel(name = "维护记录")
    private String maintenanceRecords;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }

    public void setAssetId(Long assetId)
    {
        this.assetId = assetId;
    }

    public Long getAssetId()
    {
        return assetId;
    }

    public void setAssetName(String assetName)
    {
        this.assetName = assetName;
    }

    public String getAssetName()
    {
        return assetName;
    }

    public void setAssetType(String assetType)
    {
        this.assetType = assetType;
    }

    public String getAssetType()
    {
        return assetType;
    }

    public void setSerialNumber(String serialNumber)
    {
        this.serialNumber = serialNumber;
    }

    public String getSerialNumber()
    {
        return serialNumber;
    }

    public void setPurchaseDate(Date purchaseDate)
    {
        this.purchaseDate = purchaseDate;
    }

    public Date getPurchaseDate()
    {
        return purchaseDate;
    }

    public void setWarrantyExpiry(Date warrantyExpiry)
    {
        this.warrantyExpiry = warrantyExpiry;
    }

    public Date getWarrantyExpiry()
    {
        return warrantyExpiry;
    }

    public void setValue(BigDecimal value)
    {
        this.value = value;
    }

    public BigDecimal getValue()
    {
        return value;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }

    public void setMaintenanceRecords(String maintenanceRecords)
    {
        this.maintenanceRecords = maintenanceRecords;
    }

    public String getMaintenanceRecords()
    {
        return maintenanceRecords;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("assetId", getAssetId())
                .append("assetName", getAssetName())
                .append("assetType", getAssetType())
                .append("serialNumber", getSerialNumber())
                .append("purchaseDate", getPurchaseDate())
                .append("warrantyExpiry", getWarrantyExpiry())
                .append("value", getValue())
                .append("status", getStatus())
                .append("maintenanceRecords", getMaintenanceRecords())
                .toString();
    }
}