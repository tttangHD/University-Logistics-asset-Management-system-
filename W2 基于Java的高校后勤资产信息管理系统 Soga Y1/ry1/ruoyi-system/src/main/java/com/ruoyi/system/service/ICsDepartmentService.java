package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.CsDepartment;

/**
 * 科室管理模块，用于管理医院的科室信息。Service接口
 * 
 * @author ruoyi
 * @date 2023-08-15
 */
public interface ICsDepartmentService 
{
    /**
     * 查询科室管理模块，用于管理医院的科室信息。
     * 
     * @param id 科室管理模块，用于管理医院的科室信息。主键
     * @return 科室管理模块，用于管理医院的科室信息。
     */
    public CsDepartment selectCsDepartmentById(Long id);

    /**
     * 查询科室管理模块，用于管理医院的科室信息。列表
     * 
     * @param csDepartment 科室管理模块，用于管理医院的科室信息。
     * @return 科室管理模块，用于管理医院的科室信息。集合
     */
    public List<CsDepartment> selectCsDepartmentList(CsDepartment csDepartment);

    /**
     * 新增科室管理模块，用于管理医院的科室信息。
     * 
     * @param csDepartment 科室管理模块，用于管理医院的科室信息。
     * @return 结果
     */
    public int insertCsDepartment(CsDepartment csDepartment);

    /**
     * 修改科室管理模块，用于管理医院的科室信息。
     * 
     * @param csDepartment 科室管理模块，用于管理医院的科室信息。
     * @return 结果
     */
    public int updateCsDepartment(CsDepartment csDepartment);

    /**
     * 批量删除科室管理模块，用于管理医院的科室信息。
     * 
     * @param ids 需要删除的科室管理模块，用于管理医院的科室信息。主键集合
     * @return 结果
     */
    public int deleteCsDepartmentByIds(String ids);

    /**
     * 删除科室管理模块，用于管理医院的科室信息。信息
     * 
     * @param id 科室管理模块，用于管理医院的科室信息。主键
     * @return 结果
     */
    public int deleteCsDepartmentById(Long id);
}
