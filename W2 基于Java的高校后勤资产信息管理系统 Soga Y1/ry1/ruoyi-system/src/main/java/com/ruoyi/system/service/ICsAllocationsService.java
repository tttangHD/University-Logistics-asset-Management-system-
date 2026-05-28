package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.CsAllocations;

/**
 * 资产分配Service接口
 * 
 * @author ruoyi
 * @date 2024-08-20
 */
public interface ICsAllocationsService 
{
    /**
     * 查询资产分配
     * 
     * @param id 资产分配主键
     * @return 资产分配
     */
    public CsAllocations selectCsAllocationsById(Long id);

    /**
     * 查询资产分配列表
     * 
     * @param csAllocations 资产分配
     * @return 资产分配集合
     */
    public List<CsAllocations> selectCsAllocationsList(CsAllocations csAllocations);

    /**
     * 新增资产分配
     * 
     * @param csAllocations 资产分配
     * @return 结果
     */
    public int insertCsAllocations(CsAllocations csAllocations);

    /**
     * 修改资产分配
     * 
     * @param csAllocations 资产分配
     * @return 结果
     */
    public int updateCsAllocations(CsAllocations csAllocations);

    /**
     * 批量删除资产分配
     * 
     * @param ids 需要删除的资产分配主键集合
     * @return 结果
     */
    public int deleteCsAllocationsByIds(String ids);

    /**
     * 删除资产分配信息
     * 
     * @param id 资产分配主键
     * @return 结果
     */
    public int deleteCsAllocationsById(Long id);
    
    /**
     * 更新所有已分配资产的状态为正常（1）
     * 
     * @return 更新成功的记录数
     */
    public int updateAllAllocatedAssetsStatus();
}
