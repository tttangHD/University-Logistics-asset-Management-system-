package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.CsAssetDetails;

/**
 * 资产数据详情Service接口
 * 
 * @author ruoyi
 * @date 2024-08-20
 */
public interface ICsAssetDetailsService 
{
    /**
     * 查询资产数据详情
     * 
     * @param id 资产数据详情主键
     * @return 资产数据详情
     */
    public CsAssetDetails selectCsAssetDetailsById(Long id);

    /**
     * 查询资产数据详情列表
     * 
     * @param csAssetDetails 资产数据详情
     * @return 资产数据详情集合
     */
    public List<CsAssetDetails> selectCsAssetDetailsList(CsAssetDetails csAssetDetails);

    /**
     * 新增资产数据详情
     * 
     * @param csAssetDetails 资产数据详情
     * @return 结果
     */
    public int insertCsAssetDetails(CsAssetDetails csAssetDetails);

    /**
     * 修改资产数据详情
     * 
     * @param csAssetDetails 资产数据详情
     * @return 结果
     */
    public int updateCsAssetDetails(CsAssetDetails csAssetDetails);

    /**
     * 批量删除资产数据详情
     * 
     * @param ids 需要删除的资产数据详情主键集合
     * @return 结果
     */
    public int deleteCsAssetDetailsByIds(String ids);

    /**
     * 删除资产数据详情信息
     * 
     * @param id 资产数据详情主键
     * @return 结果
     */
    public int deleteCsAssetDetailsById(Long id);
}
