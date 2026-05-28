package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.CsPatient;

/**
 * 患者管理模块，用于管理患者的信息。Service接口
 * 
 * @author ruoyi
 * @date 2023-08-15
 */
public interface ICsPatientService 
{
    /**
     * 查询患者管理模块，用于管理患者的信息。
     * 
     * @param id 患者管理模块，用于管理患者的信息。主键
     * @return 患者管理模块，用于管理患者的信息。
     */
    public CsPatient selectCsPatientById(Long id);

    /**
     * 查询患者管理模块，用于管理患者的信息。列表
     * 
     * @param csPatient 患者管理模块，用于管理患者的信息。
     * @return 患者管理模块，用于管理患者的信息。集合
     */
    public List<CsPatient> selectCsPatientList(CsPatient csPatient);

    /**
     * 新增患者管理模块，用于管理患者的信息。
     * 
     * @param csPatient 患者管理模块，用于管理患者的信息。
     * @return 结果
     */
    public int insertCsPatient(CsPatient csPatient);

    /**
     * 修改患者管理模块，用于管理患者的信息。
     * 
     * @param csPatient 患者管理模块，用于管理患者的信息。
     * @return 结果
     */
    public int updateCsPatient(CsPatient csPatient);

    /**
     * 批量删除患者管理模块，用于管理患者的信息。
     * 
     * @param ids 需要删除的患者管理模块，用于管理患者的信息。主键集合
     * @return 结果
     */
    public int deleteCsPatientByIds(String ids);

    /**
     * 删除患者管理模块，用于管理患者的信息。信息
     * 
     * @param id 患者管理模块，用于管理患者的信息。主键
     * @return 结果
     */
    public int deleteCsPatientById(Long id);
}
