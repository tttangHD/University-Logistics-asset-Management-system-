package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CsDepartmentMapper;
import com.ruoyi.system.domain.CsDepartment;
import com.ruoyi.system.service.ICsDepartmentService;
import com.ruoyi.common.core.text.Convert;

/**
 * 科室管理模块，用于管理医院的科室信息。Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-08-15
 */
@Service
public class CsDepartmentServiceImpl implements ICsDepartmentService 
{
    @Autowired
    private CsDepartmentMapper csDepartmentMapper;

    /**
     * 查询科室管理模块，用于管理医院的科室信息。
     * 
     * @param id 科室管理模块，用于管理医院的科室信息。主键
     * @return 科室管理模块，用于管理医院的科室信息。
     */
    @Override
    public CsDepartment selectCsDepartmentById(Long id)
    {
        return csDepartmentMapper.selectCsDepartmentById(id);
    }

    /**
     * 查询科室管理模块，用于管理医院的科室信息。列表
     * 
     * @param csDepartment 科室管理模块，用于管理医院的科室信息。
     * @return 科室管理模块，用于管理医院的科室信息。
     */
    @Override
    public List<CsDepartment> selectCsDepartmentList(CsDepartment csDepartment)
    {
        return csDepartmentMapper.selectCsDepartmentList(csDepartment);
    }

    /**
     * 新增科室管理模块，用于管理医院的科室信息。
     * 
     * @param csDepartment 科室管理模块，用于管理医院的科室信息。
     * @return 结果
     */
    @Override
    public int insertCsDepartment(CsDepartment csDepartment)
    {
        return csDepartmentMapper.insertCsDepartment(csDepartment);
    }

    /**
     * 修改科室管理模块，用于管理医院的科室信息。
     * 
     * @param csDepartment 科室管理模块，用于管理医院的科室信息。
     * @return 结果
     */
    @Override
    public int updateCsDepartment(CsDepartment csDepartment)
    {
        return csDepartmentMapper.updateCsDepartment(csDepartment);
    }

    /**
     * 批量删除科室管理模块，用于管理医院的科室信息。
     * 
     * @param ids 需要删除的科室管理模块，用于管理医院的科室信息。主键
     * @return 结果
     */
    @Override
    public int deleteCsDepartmentByIds(String ids)
    {
        return csDepartmentMapper.deleteCsDepartmentByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除科室管理模块，用于管理医院的科室信息。信息
     * 
     * @param id 科室管理模块，用于管理医院的科室信息。主键
     * @return 结果
     */
    @Override
    public int deleteCsDepartmentById(Long id)
    {
        return csDepartmentMapper.deleteCsDepartmentById(id);
    }
}
