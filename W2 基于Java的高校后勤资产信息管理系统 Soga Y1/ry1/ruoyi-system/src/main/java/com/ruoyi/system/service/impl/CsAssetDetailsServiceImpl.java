package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CsAssetDetailsMapper;
import com.ruoyi.system.domain.CsAssetDetails;
import com.ruoyi.system.service.ICsAssetDetailsService;
import com.ruoyi.common.core.text.Convert;

/**
 * 资产数据详情Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-08-20
 */
@Service
public class CsAssetDetailsServiceImpl implements ICsAssetDetailsService 
{
    @Autowired
    private CsAssetDetailsMapper csAssetDetailsMapper;

    /**
     * 查询资产数据详情
     * 
     * @param id 资产数据详情主键
     * @return 资产数据详情
     */
    @Override
    public CsAssetDetails selectCsAssetDetailsById(Long id)
    {
        return csAssetDetailsMapper.selectCsAssetDetailsById(id);
    }

    /**
     * 查询资产数据详情列表
     * 
     * @param csAssetDetails 资产数据详情
     * @return 资产数据详情
     */
    @Override
    public List<CsAssetDetails> selectCsAssetDetailsList(CsAssetDetails csAssetDetails)
    {
        return csAssetDetailsMapper.selectCsAssetDetailsList(csAssetDetails);
    }

    /**
     * 新增资产数据详情
     * 
     * @param csAssetDetails 资产数据详情
     * @return 结果
     */
    @Override
    public int insertCsAssetDetails(CsAssetDetails csAssetDetails)
    {
        return csAssetDetailsMapper.insertCsAssetDetails(csAssetDetails);
    }

    /**
     * 修改资产数据详情
     * 
     * @param csAssetDetails 资产数据详情
     * @return 结果
     */
    @Override
    public int updateCsAssetDetails(CsAssetDetails csAssetDetails)
    {
        return csAssetDetailsMapper.updateCsAssetDetails(csAssetDetails);
    }

    /**
     * 批量删除资产数据详情
     * 
     * @param ids 需要删除的资产数据详情主键
     * @return 结果
     */
    @Override
    public int deleteCsAssetDetailsByIds(String ids)
    {
        return csAssetDetailsMapper.deleteCsAssetDetailsByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除资产数据详情信息
     * 
     * @param id 资产数据详情主键
     * @return 结果
     */
    @Override
    public int deleteCsAssetDetailsById(Long id)
    {
        return csAssetDetailsMapper.deleteCsAssetDetailsById(id);
    }
}
