package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CsPurchaseRequestsMapper;
import com.ruoyi.system.domain.CsPurchaseRequests;
import com.ruoyi.system.service.ICsPurchaseRequestsService;
import com.ruoyi.common.core.text.Convert;

/**
 * 采购申请Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-03-19
 */
@Service
public class CsPurchaseRequestsServiceImpl implements ICsPurchaseRequestsService 
{
    @Autowired
    private CsPurchaseRequestsMapper csPurchaseRequestsMapper;

    /**
     * 查询采购申请
     * 
     * @param id 采购申请主键
     * @return 采购申请
     */
    @Override
    public CsPurchaseRequests selectCsPurchaseRequestsById(Long id)
    {
        return csPurchaseRequestsMapper.selectCsPurchaseRequestsById(id);
    }

    /**
     * 查询采购申请列表
     * 
     * @param csPurchaseRequests 采购申请
     * @return 采购申请
     */
    @Override
    public List<CsPurchaseRequests> selectCsPurchaseRequestsList(CsPurchaseRequests csPurchaseRequests)
    {
        return csPurchaseRequestsMapper.selectCsPurchaseRequestsList(csPurchaseRequests);
    }

    /**
     * 新增采购申请
     * 
     * @param csPurchaseRequests 采购申请
     * @return 结果
     */
    @Override
    public int insertCsPurchaseRequests(CsPurchaseRequests csPurchaseRequests)
    {
        return csPurchaseRequestsMapper.insertCsPurchaseRequests(csPurchaseRequests);
    }

    /**
     * 修改采购申请
     * 
     * @param csPurchaseRequests 采购申请
     * @return 结果
     */
    @Override
    public int updateCsPurchaseRequests(CsPurchaseRequests csPurchaseRequests)
    {
        return csPurchaseRequestsMapper.updateCsPurchaseRequests(csPurchaseRequests);
    }

    /**
     * 批量删除采购申请
     * 
     * @param ids 需要删除的采购申请主键
     * @return 结果
     */
    @Override
    public int deleteCsPurchaseRequestsByIds(String ids)
    {
        return csPurchaseRequestsMapper.deleteCsPurchaseRequestsByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除采购申请信息
     * 
     * @param id 采购申请主键
     * @return 结果
     */
    @Override
    public int deleteCsPurchaseRequestsById(Long id)
    {
        return csPurchaseRequestsMapper.deleteCsPurchaseRequestsById(id);
    }
} 