package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.CsRepairRequests;

/**
 * 报修请求Service接口
 * 
 * @author ruoyi
 * @date 2024-08-20
 */
public interface ICsRepairRequestsService 
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
     * 批量删除报修请求
     * 
     * @param ids 需要删除的报修请求主键集合
     * @return 结果
     */
    public int deleteCsRepairRequestsByIds(String ids);

    /**
     * 删除报修请求信息
     * 
     * @param id 报修请求主键
     * @return 结果
     */
    public int deleteCsRepairRequestsById(Long id);
}
