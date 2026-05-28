package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 资产分配对象 cs_allocations
 * 
 * @author ruoyi
 * @date 2024-08-20
 */
public class CsAllocations extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 分配ID */
    private Long id;

    /** 资产ID */
    @Excel(name = "资产ID")
    private Long assetId;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long userId;

    /** 分配日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "分配日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date allocationDate;

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
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setAllocationDate(Date allocationDate) 
    {
        this.allocationDate = allocationDate;
    }

    public Date getAllocationDate() 
    {
        return allocationDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("assetId", getAssetId())
            .append("userId", getUserId())
            .append("allocationDate", getAllocationDate())
            .toString();
    }
}
