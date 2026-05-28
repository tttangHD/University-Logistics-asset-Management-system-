package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CsAssetsMapper;
import com.ruoyi.system.domain.CsAssets;
import com.ruoyi.system.service.ICsAssetsService;
import com.ruoyi.common.core.text.Convert;

/**
 * 资产管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-08-20
 */
@Service
public class CsAssetsServiceImpl implements ICsAssetsService 
{
    @Autowired
    private CsAssetsMapper csAssetsMapper;

    /**
     * 查询资产管理
     * 
     * @param id 资产管理主键
     * @return 资产管理
     */
    @Override
    public CsAssets selectCsAssetsById(Long id)
    {
        return csAssetsMapper.selectCsAssetsById(id);
    }

    /**
     * 查询资产管理列表
     * 
     * @param csAssets 资产管理
     * @return 资产管理
     */
    @Override
    public List<CsAssets> selectCsAssetsList(CsAssets csAssets)
    {
        return csAssetsMapper.selectCsAssetsList(csAssets);
    }

    /**
     * 新增资产管理
     * 
     * @param csAssets 资产管理
     * @return 结果
     */
    @Override
    public int insertCsAssets(CsAssets csAssets)
    {
        return csAssetsMapper.insertCsAssets(csAssets);
    }

    /**
     * 修改资产管理
     * 
     * @param csAssets 资产管理
     * @return 结果
     */
    @Override
    public int updateCsAssets(CsAssets csAssets)
    {
        return csAssetsMapper.updateCsAssets(csAssets);
    }

    /**
     * 批量删除资产管理
     * 
     * @param ids 需要删除的资产管理主键
     * @return 结果
     */
    @Override
    public int deleteCsAssetsByIds(String ids)
    {
        return csAssetsMapper.deleteCsAssetsByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除资产管理信息
     * 
     * @param id 资产管理主键
     * @return 结果
     */
    @Override
    public int deleteCsAssetsById(Long id)
    {
        return csAssetsMapper.deleteCsAssetsById(id);
    }
}
