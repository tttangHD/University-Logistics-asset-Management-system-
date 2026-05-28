package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.CsRepairRequests1;

/**
 * 报修审核Service接口
 * 
 * @author ruoyi
 * @date 2024-08-20
 */
public interface ICsRepairRequests1Service 
{
    /**
     * 查询报修审核
     * 
     * @param id 报修审核主键
     * @return 报修审核
     */
    public CsRepairRequests1 selectCsRepairRequests1ById(Long id);

    /**
     * 查询报修审核列表
     * 
     * @param csRepairRequests1 报修审核
     * @return 报修审核集合
     */
    public List<CsRepairRequests1> selectCsRepairRequests1List(CsRepairRequests1 csRepairRequests1);

    /**
     * 新增报修审核
     * 
     * @param csRepairRequests1 报修审核
     * @return 结果
     */
    public int insertCsRepairRequests1(CsRepairRequests1 csRepairRequests1);

    /**
     * 修改报修审核
     * 
     * @param csRepairRequests1 报修审核
     * @return 结果
     */
    public int updateCsRepairRequests1(CsRepairRequests1 csRepairRequests1);

    /**
     * 批量删除报修审核
     * 
     * @param ids 需要删除的报修审核主键集合
     * @return 结果
     */
    public int deleteCsRepairRequests1ByIds(String ids);

    /**
     * 删除报修审核信息
     * 
     * @param id 报修审核主键
     * @return 结果
     */
    public int deleteCsRepairRequests1ById(Long id);
}
