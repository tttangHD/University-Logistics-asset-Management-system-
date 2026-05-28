package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CsRepairRequestsMapper;
import com.ruoyi.system.domain.CsRepairRequests;
import com.ruoyi.system.domain.CsAssetDetails;
import com.ruoyi.system.service.ICsRepairRequestsService;
import com.ruoyi.system.service.ICsAssetDetailsService;
import com.ruoyi.common.core.text.Convert;

/**
 * 报修请求Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-08-20
 */
@Service
public class CsRepairRequestsServiceImpl implements ICsRepairRequestsService 
{
    @Autowired
    private CsRepairRequestsMapper csRepairRequestsMapper;
    
    @Autowired
    private ICsAssetDetailsService csAssetDetailsService;

    /**
     * 查询报修请求
     * 
     * @param id 报修请求主键
     * @return 报修请求
     */
    @Override
    public CsRepairRequests selectCsRepairRequestsById(Long id)
    {
        return csRepairRequestsMapper.selectCsRepairRequestsById(id);
    }

    /**
     * 查询报修请求列表
     * 
     * @param csRepairRequests 报修请求
     * @return 报修请求
     */
    @Override
    public List<CsRepairRequests> selectCsRepairRequestsList(CsRepairRequests csRepairRequests)
    {
        return csRepairRequestsMapper.selectCsRepairRequestsList(csRepairRequests);
    }

    /**
     * 新增报修请求
     * 
     * @param csRepairRequests 报修请求
     * @return 结果
     */
    @Override
    public int insertCsRepairRequests(CsRepairRequests csRepairRequests)
    {
        int rows = csRepairRequestsMapper.insertCsRepairRequests(csRepairRequests);
        // 如果有资产ID，更新资产状态为报修中（2）
        if (csRepairRequests.getAssetId() != null) {
            updateAssetStatus(csRepairRequests.getAssetId());
        }
        return rows;
    }

    /**
     * 修改报修请求
     * 
     * @param csRepairRequests 报修请求
     * @return 结果
     */
    @Override
    public int updateCsRepairRequests(CsRepairRequests csRepairRequests)
    {
        int rows = csRepairRequestsMapper.updateCsRepairRequests(csRepairRequests);
        // 如果有资产ID，更新资产状态为报修中（2）
        if (csRepairRequests.getAssetId() != null) {
            updateAssetStatus(csRepairRequests.getAssetId());
        }
        return rows;
    }

    /**
     * 批量删除报修请求
     * 
     * @param ids 需要删除的报修请求主键
     * @return 结果
     */
    @Override
    public int deleteCsRepairRequestsByIds(String ids)
    {
        return csRepairRequestsMapper.deleteCsRepairRequestsByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除报修请求信息
     * 
     * @param id 报修请求主键
     * @return 结果
     */
    @Override
    public int deleteCsRepairRequestsById(Long id)
    {
        return csRepairRequestsMapper.deleteCsRepairRequestsById(id);
    }
    
    /**
     * 更新资产状态为报修中（2）
     * 
     * @param assetId 资产ID
     */
    private void updateAssetStatus(Long assetId) {
        // 根据资产ID查询资产详情
        CsAssetDetails csAssetDetails = new CsAssetDetails();
        csAssetDetails.setAssetId(assetId);
        List<CsAssetDetails> detailsList = csAssetDetailsService.selectCsAssetDetailsList(csAssetDetails);
        
        System.out.println("资产ID: " + assetId);
        System.out.println("查询结果数量: " + (detailsList != null ? detailsList.size() : 0));
        
        if (detailsList != null && !detailsList.isEmpty()) {
            CsAssetDetails details = detailsList.get(0);
            System.out.println("更新前状态: " + details.getStatus());
            // 将状态更新为2（报修中）
            details.setStatus("2");
            int rows = csAssetDetailsService.updateCsAssetDetails(details);
            System.out.println("更新影响行数: " + rows);
        } else {
            System.out.println("未找到对应的资产详情记录");
        }
    }
}
