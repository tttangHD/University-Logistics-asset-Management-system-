package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CsRepairRequests1Mapper;
import com.ruoyi.system.domain.CsRepairRequests1;
import com.ruoyi.system.domain.CsAssetDetails;
import com.ruoyi.system.service.ICsRepairRequests1Service;
import com.ruoyi.system.service.ICsAssetDetailsService;
import com.ruoyi.common.core.text.Convert;

/**
 * 报修审核Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-08-20
 */
@Service
public class CsRepairRequests1ServiceImpl implements ICsRepairRequests1Service 
{
    @Autowired
    private CsRepairRequests1Mapper csRepairRequests1Mapper;
    
    @Autowired
    private ICsAssetDetailsService csAssetDetailsService;

    /**
     * 查询报修审核
     * 
     * @param id 报修审核主键
     * @return 报修审核
     */
    @Override
    public CsRepairRequests1 selectCsRepairRequests1ById(Long id)
    {
        return csRepairRequests1Mapper.selectCsRepairRequests1ById(id);
    }

    /**
     * 查询报修审核列表
     * 
     * @param csRepairRequests1 报修审核
     * @return 报修审核
     */
    @Override
    public List<CsRepairRequests1> selectCsRepairRequests1List(CsRepairRequests1 csRepairRequests1)
    {
        return csRepairRequests1Mapper.selectCsRepairRequests1List(csRepairRequests1);
    }

    /**
     * 新增报修审核
     * 
     * @param csRepairRequests1 报修审核
     * @return 结果
     */
    @Override
    public int insertCsRepairRequests1(CsRepairRequests1 csRepairRequests1)
    {
        int rows = csRepairRequests1Mapper.insertCsRepairRequests1(csRepairRequests1);
        // 如果有资产ID，更新资产状态为报修中（2）
        if (csRepairRequests1.getAssetId() != null) {
            updateAssetStatus(csRepairRequests1.getAssetId());
        }
        return rows;
    }

    /**
     * 修改报修审核
     * 
     * @param csRepairRequests1 报修审核
     * @return 结果
     */
    @Override
    public int updateCsRepairRequests1(CsRepairRequests1 csRepairRequests1)
    {
        int rows = csRepairRequests1Mapper.updateCsRepairRequests1(csRepairRequests1);
        // 如果有资产ID，更新资产状态为报修中（2）
        if (csRepairRequests1.getAssetId() != null) {
            updateAssetStatus(csRepairRequests1.getAssetId());
        }
        return rows;
    }

    /**
     * 批量删除报修审核
     * 
     * @param ids 需要删除的报修审核主键
     * @return 结果
     */
    @Override
    public int deleteCsRepairRequests1ByIds(String ids)
    {
        return csRepairRequests1Mapper.deleteCsRepairRequests1ByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除报修审核信息
     * 
     * @param id 报修审核主键
     * @return 结果
     */
    @Override
    public int deleteCsRepairRequests1ById(Long id)
    {
        return csRepairRequests1Mapper.deleteCsRepairRequests1ById(id);
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
