package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.CsAllocations;

/**
 * 资产分配Mapper接口
 * 
 * @author ruoyi
 * @date 2024-08-20
 */
public interface CsAllocationsMapper 
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
     * 删除资产分配
     * 
     * @param id 资产分配主键
     * @return 结果
     */
    public int deleteCsAllocationsById(Long id);

    /**
     * 批量删除资产分配
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCsAllocationsByIds(String[] ids);
}
