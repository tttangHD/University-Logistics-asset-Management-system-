package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CsRegistrationMapper;
import com.ruoyi.system.domain.CsRegistration;
import com.ruoyi.system.service.ICsRegistrationService;
import com.ruoyi.common.core.text.Convert;

/**
 * 挂号管理模块，用于管理患者的挂号信息。Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-08-15
 */
@Service
public class CsRegistrationServiceImpl implements ICsRegistrationService 
{
    @Autowired
    private CsRegistrationMapper csRegistrationMapper;

    /**
     * 查询挂号管理模块，用于管理患者的挂号信息。
     * 
     * @param id 挂号管理模块，用于管理患者的挂号信息。主键
     * @return 挂号管理模块，用于管理患者的挂号信息。
     */
    @Override
    public CsRegistration selectCsRegistrationById(Long id)
    {
        return csRegistrationMapper.selectCsRegistrationById(id);
    }

    /**
     * 查询挂号管理模块，用于管理患者的挂号信息。列表
     * 
     * @param csRegistration 挂号管理模块，用于管理患者的挂号信息。
     * @return 挂号管理模块，用于管理患者的挂号信息。
     */
    @Override
    public List<CsRegistration> selectCsRegistrationList(CsRegistration csRegistration)
    {
        return csRegistrationMapper.selectCsRegistrationList(csRegistration);
    }

    /**
     * 新增挂号管理模块，用于管理患者的挂号信息。
     * 
     * @param csRegistration 挂号管理模块，用于管理患者的挂号信息。
     * @return 结果
     */
    @Override
    public int insertCsRegistration(CsRegistration csRegistration)
    {
        return csRegistrationMapper.insertCsRegistration(csRegistration);
    }

    /**
     * 修改挂号管理模块，用于管理患者的挂号信息。
     * 
     * @param csRegistration 挂号管理模块，用于管理患者的挂号信息。
     * @return 结果
     */
    @Override
    public int updateCsRegistration(CsRegistration csRegistration)
    {
        return csRegistrationMapper.updateCsRegistration(csRegistration);
    }

    /**
     * 批量删除挂号管理模块，用于管理患者的挂号信息。
     * 
     * @param ids 需要删除的挂号管理模块，用于管理患者的挂号信息。主键
     * @return 结果
     */
    @Override
    public int deleteCsRegistrationByIds(String ids)
    {
        return csRegistrationMapper.deleteCsRegistrationByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除挂号管理模块，用于管理患者的挂号信息。信息
     * 
     * @param id 挂号管理模块，用于管理患者的挂号信息。主键
     * @return 结果
     */
    @Override
    public int deleteCsRegistrationById(Long id)
    {
        return csRegistrationMapper.deleteCsRegistrationById(id);
    }
}
