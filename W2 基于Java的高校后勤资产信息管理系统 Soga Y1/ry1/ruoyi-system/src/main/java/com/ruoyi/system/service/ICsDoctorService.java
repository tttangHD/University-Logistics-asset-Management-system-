package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.CsDoctor;

/**
 * 医生管理模块，用于管理医生的信息。Service接口
 * 
 * @author ruoyi
 * @date 2023-08-15
 */
public interface ICsDoctorService 
{
    /**
     * 查询医生管理模块，用于管理医生的信息。
     * 
     * @param id 医生管理模块，用于管理医生的信息。主键
     * @return 医生管理模块，用于管理医生的信息。
     */
    public CsDoctor selectCsDoctorById(Long id);

    /**
     * 查询医生管理模块，用于管理医生的信息。列表
     * 
     * @param csDoctor 医生管理模块，用于管理医生的信息。
     * @return 医生管理模块，用于管理医生的信息。集合
     */
    public List<CsDoctor> selectCsDoctorList(CsDoctor csDoctor);

    /**
     * 新增医生管理模块，用于管理医生的信息。
     * 
     * @param csDoctor 医生管理模块，用于管理医生的信息。
     * @return 结果
     */
    public int insertCsDoctor(CsDoctor csDoctor);

    /**
     * 修改医生管理模块，用于管理医生的信息。
     * 
     * @param csDoctor 医生管理模块，用于管理医生的信息。
     * @return 结果
     */
    public int updateCsDoctor(CsDoctor csDoctor);

    /**
     * 批量删除医生管理模块，用于管理医生的信息。
     * 
     * @param ids 需要删除的医生管理模块，用于管理医生的信息。主键集合
     * @return 结果
     */
    public int deleteCsDoctorByIds(String ids);

    /**
     * 删除医生管理模块，用于管理医生的信息。信息
     * 
     * @param id 医生管理模块，用于管理医生的信息。主键
     * @return 结果
     */
    public int deleteCsDoctorById(Long id);
}
