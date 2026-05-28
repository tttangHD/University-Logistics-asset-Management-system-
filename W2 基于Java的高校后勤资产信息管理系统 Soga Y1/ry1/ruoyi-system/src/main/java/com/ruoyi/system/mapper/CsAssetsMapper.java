package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.CsAssets;

/**
 * 资产管理Mapper接口
 * 
 * @author ruoyi
 * @date 2024-08-20
 */
public interface CsAssetsMapper 
{
    /**
     * 查询资产管理
     * 
     * @param id 资产管理主键
     * @return 资产管理
     */
    public CsAssets selectCsAssetsById(Long id);

    /**
     * 查询资产管理列表
     * 
     * @param csAssets 资产管理
     * @return 资产管理集合
     */
    public List<CsAssets> selectCsAssetsList(CsAssets csAssets);

    /**
     * 新增资产管理
     * 
     * @param csAssets 资产管理
     * @return 结果
     */
    public int insertCsAssets(CsAssets csAssets);

    /**
     * 修改资产管理
     * 
     * @param csAssets 资产管理
     * @return 结果
     */
    public int updateCsAssets(CsAssets csAssets);

    /**
     * 删除资产管理
     * 
     * @param id 资产管理主键
     * @return 结果
     */
    public int deleteCsAssetsById(Long id);

    /**
     * 批量删除资产管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCsAssetsByIds(String[] ids);
}
