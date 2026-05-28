package com.ruoyi.system.domain;

import java.util.Date;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 采购申请对象 cs_purchase_requests
 * 
 * @author tang
 * @date 2024-03-19
 */
public class CsPurchaseRequests extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 采购申请ID */
    private Long id;

    /** 提交采购申请的用户ID */
    @Excel(name = "提交采购申请的用户ID")
    private Long userId;

    /** 物品名称 */
    @Excel(name = "物品名称")
    private String itemName;

    /** 物品数量 */
    @Excel(name = "物品数量")
    private Integer quantity;

    /** 预计单价 */
    @Excel(name = "预计单价")
    private BigDecimal estimatedPrice;

    /** 总价 */
    @Excel(name = "总价")
    private BigDecimal totalPrice;

    /** 用途说明 */
    @Excel(name = "用途说明")
    private String purposeDescription;

    /** 申请日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "申请日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date requestDate;

    /** 申请状态 */
    @Excel(name = "申请状态")
    private String status;

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

    public void setItemName(String itemName) 
    {
        this.itemName = itemName;
    }

    public String getItemName() 
    {
        return itemName;
    }

    public void setQuantity(Integer quantity) 
    {
        this.quantity = quantity;
    }

    public Integer getQuantity() 
    {
        return quantity;
    }

    public void setEstimatedPrice(BigDecimal estimatedPrice) 
    {
        this.estimatedPrice = estimatedPrice;
    }

    public BigDecimal getEstimatedPrice() 
    {
        return estimatedPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) 
    {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getTotalPrice() 
    {
        return totalPrice;
    }

    public void setPurposeDescription(String purposeDescription) 
    {
        this.purposeDescription = purposeDescription;
    }

    public String getPurposeDescription() 
    {
        return purposeDescription;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("itemName", getItemName())
            .append("quantity", getQuantity())
            .append("estimatedPrice", getEstimatedPrice())
            .append("totalPrice", getTotalPrice())
            .append("purposeDescription", getPurposeDescription())
            .append("requestDate", getRequestDate())
            .append("status", getStatus())
            .toString();
    }
} 