package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.CsRegistration;

/**
 * 挂号管理模块，用于管理患者的挂号信息。Service接口
 * 
 * @author ruoyi
 * @date 2023-08-15
 */
public interface ICsRegistrationService 
{
    /**
     * 查询挂号管理模块，用于管理患者的挂号信息。
     * 
     * @param id 挂号管理模块，用于管理患者的挂号信息。主键
     * @return 挂号管理模块，用于管理患者的挂号信息。
     */
    public CsRegistration selectCsRegistrationById(Long id);

    /**
     * 查询挂号管理模块，用于管理患者的挂号信息。列表
     * 
     * @param csRegistration 挂号管理模块，用于管理患者的挂号信息。
     * @return 挂号管理模块，用于管理患者的挂号信息。集合
     */
    public List<CsRegistration> selectCsRegistrationList(CsRegistration csRegistration);

    /**
     * 新增挂号管理模块，用于管理患者的挂号信息。
     * 
     * @param csRegistration 挂号管理模块，用于管理患者的挂号信息。
     * @return 结果
     */
    public int insertCsRegistration(CsRegistration csRegistration);

    /**
     * 修改挂号管理模块，用于管理患者的挂号信息。
     * 
     * @param csRegistration 挂号管理模块，用于管理患者的挂号信息。
     * @return 结果
     */
    public int updateCsRegistration(CsRegistration csRegistration);

    /**
     * 批量删除挂号管理模块，用于管理患者的挂号信息。
     * 
     * @param ids 需要删除的挂号管理模块，用于管理患者的挂号信息。主键集合
     * @return 结果
     */
    public int deleteCsRegistrationByIds(String ids);

    /**
     * 删除挂号管理模块，用于管理患者的挂号信息。信息
     * 
     * @param id 挂号管理模块，用于管理患者的挂号信息。主键
     * @return 结果
     */
    public int deleteCsRegistrationById(Long id);
}
