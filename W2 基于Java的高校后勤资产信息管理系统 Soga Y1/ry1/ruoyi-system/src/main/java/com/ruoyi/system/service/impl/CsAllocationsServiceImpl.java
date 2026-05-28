package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CsAllocationsMapper;
import com.ruoyi.system.domain.CsAllocations;
import com.ruoyi.system.domain.CsAssetDetails;
import com.ruoyi.system.service.ICsAllocationsService;
import com.ruoyi.system.service.ICsAssetDetailsService;
import com.ruoyi.common.core.text.Convert;

/**
 * 资产分配Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-08-20
 */
@Service
public class CsAllocationsServiceImpl implements ICsAllocationsService 
{
    @Autowired
    private CsAllocationsMapper csAllocationsMapper;
    
    @Autowired
    private ICsAssetDetailsService csAssetDetailsService;

    /**
     * 查询资产分配
     * 
     * @param id 资产分配主键
     * @return 资产分配
     */
    @Override
    public CsAllocations selectCsAllocationsById(Long id)
    {
        return csAllocationsMapper.selectCsAllocationsById(id);
    }

    /**
     * 查询资产分配列表
     * 
     * @param csAllocations 资产分配
     * @return 资产分配
     */
    @Override
    public List<CsAllocations> selectCsAllocationsList(CsAllocations csAllocations)
    {
        return csAllocationsMapper.selectCsAllocationsList(csAllocations);
    }

    /**
     * 新增资产分配
     * 
     * @param csAllocations 资产分配
     * @return 结果
     */
    @Override
    public int insertCsAllocations(CsAllocations csAllocations)
    {
        int rows = csAllocationsMapper.insertCsAllocations(csAllocations);
        // 如果有资产ID，更新资产状态为正常（1）
        if (csAllocations.getAssetId() != null) {
            updateAssetStatus(csAllocations.getAssetId());
        }
        return rows;
    }

    /**
     * 修改资产分配
     * 
     * @param csAllocations 资产分配
     * @return 结果
     */
    @Override
    public int updateCsAllocations(CsAllocations csAllocations)
    {
        int rows = csAllocationsMapper.updateCsAllocations(csAllocations);
        // 如果有资产ID，更新资产状态为正常（1）
        if (csAllocations.getAssetId() != null) {
            updateAssetStatus(csAllocations.getAssetId());
        }
        return rows;
    }

    /**
     * 批量删除资产分配
     * 
     * @param ids 需要删除的资产分配主键
     * @return 结果
     */
    @Override
    public int deleteCsAllocationsByIds(String ids)
    {
        return csAllocationsMapper.deleteCsAllocationsByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除资产分配信息
     * 
     * @param id 资产分配主键
     * @return 结果
     */
    @Override
    public int deleteCsAllocationsById(Long id)
    {
        return csAllocationsMapper.deleteCsAllocationsById(id);
    }
    
    /**
     * 更新所有已分配资产的状态为正常（1）
     * 
     * @return 更新成功的记录数
     */
    @Override
    public int updateAllAllocatedAssetsStatus() {
        // 获取所有资产分配记录
        List<CsAllocations> allocationsList = csAllocationsMapper.selectCsAllocationsList(new CsAllocations());
        int successCount = 0;
        
        System.out.println("开始批量更新资产状态，共有" + allocationsList.size() + "条记录");
        
        // 遍历每条记录并更新对应资产的状态
        for (CsAllocations allocation : allocationsList) {
            if (allocation.getAssetId() != null) {
                try {
                    updateAssetStatus(allocation.getAssetId());
                    successCount++;
                } catch (Exception e) {
                    System.out.println("更新资产ID为" + allocation.getAssetId() + "的状态时出错: " + e.getMessage());
                }
            }
        }
        
        System.out.println("批量更新资产状态完成，成功更新" + successCount + "条记录");
        return successCount;
    }

    /**
     * 更新资产状态为正常（1）
     * 
     * @param assetId 资产ID
     */
    private void updateAssetStatus(Long assetId) {
        // 根据资产ID查询资产详情
        CsAssetDetails csAssetDetails = new CsAssetDetails();
        csAssetDetails.setAssetId(assetId);
        List<CsAssetDetails> detailsList = csAssetDetailsService.selectCsAssetDetailsList(csAssetDetails);
        
        System.out.println("更新状态为正常 - 资产ID: " + assetId);
        System.out.println("查询结果数量: " + (detailsList != null ? detailsList.size() : 0));
        
        if (detailsList != null && !detailsList.isEmpty()) {
            CsAssetDetails details = detailsList.get(0);
            System.out.println("更新前状态: " + details.getStatus());
            // 将状态更新为1（正常）
            details.setStatus("1");
            int rows = csAssetDetailsService.updateCsAssetDetails(details);
            System.out.println("更新影响行数: " + rows);
        } else {
            System.out.println("未找到对应的资产详情记录");
        }
    }
}
