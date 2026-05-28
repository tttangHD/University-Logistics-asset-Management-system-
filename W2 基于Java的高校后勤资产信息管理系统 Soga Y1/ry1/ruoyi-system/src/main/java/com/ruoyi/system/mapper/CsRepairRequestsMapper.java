package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.CsRepairRequests;

/**
 * 报修请求Mapper接口
 * 
 * @author ruoyi
 * @date 2024-08-20
 */
public interface CsRepairRequestsMapper 
{
    /**
     * 查询报修请求
     * 
     * @param id 报修请求主键
     * @return 报修请求
     */
    public CsRepairRequests selectCsRepairRequestsById(Long id);

    /**
     * 查询报修请求列表
     * 
     * @param csRepairRequests 报修请求
     * @return 报修请求集合
     */
    public List<CsRepairRequests> selectCsRepairRequestsList(CsRepairRequests csRepairRequests);

    /**
     * 新增报修请求
     * 
     * @param csRepairRequests 报修请求
     * @return 结果
     */
    public int insertCsRepairRequests(CsRepairRequests csRepairRequests);

    /**
     * 修改报修请求
     * 
     * @param csRepairRequests 报修请求
     * @return 结果
     */
    public int updateCsRepairRequests(CsRepairRequests csRepairRequests);

    /**
     * 删除报修请求
     * 
     * @param id 报修请求主键
     * @return 结果
     */
    public int deleteCsRepairRequestsById(Long id);

    /**
     * 批量删除报修请求
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCsRepairRequestsByIds(String[] ids);
}
