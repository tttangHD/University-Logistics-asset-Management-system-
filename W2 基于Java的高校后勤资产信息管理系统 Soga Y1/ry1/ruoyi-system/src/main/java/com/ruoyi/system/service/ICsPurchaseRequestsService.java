package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.CsPurchaseRequests;

/**
 * 采购申请Service接口
 * 
 * @author ruoyi
 * @date 2024-03-19
 */
public interface ICsPurchaseRequestsService 
{
    /**
     * 查询采购申请
     * 
     * @param id 采购申请主键
     * @return 采购申请
     */
    public CsPurchaseRequests selectCsPurchaseRequestsById(Long id);

    /**
     * 查询采购申请列表
     * 
     * @param csPurchaseRequests 采购申请
     * @return 采购申请集合
     */
    public List<CsPurchaseRequests> selectCsPurchaseRequestsList(CsPurchaseRequests csPurchaseRequests);

    /**
     * 新增采购申请
     * 
     * @param csPurchaseRequests 采购申请
     * @return 结果
     */
    public int insertCsPurchaseRequests(CsPurchaseRequests csPurchaseRequests);

    /**
     * 修改采购申请
     * 
     * @param csPurchaseRequests 采购申请
     * @return 结果
     */
    public int updateCsPurchaseRequests(CsPurchaseRequests csPurchaseRequests);

    /**
     * 批量删除采购申请
     * 
     * @param ids 需要删除的采购申请主键集合
     * @return 结果
     */
    public int deleteCsPurchaseRequestsByIds(String ids);

    /**
     * 删除采购申请信息
     * 
     * @param id 采购申请主键
     * @return 结果
     */
    public int deleteCsPurchaseRequestsById(Long id);
} 