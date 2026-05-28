package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CsPatientMapper;
import com.ruoyi.system.domain.CsPatient;
import com.ruoyi.system.service.ICsPatientService;
import com.ruoyi.common.core.text.Convert;

/**
 * 患者管理模块，用于管理患者的信息。Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-08-15
 */
@Service
public class CsPatientServiceImpl implements ICsPatientService 
{
    @Autowired
    private CsPatientMapper csPatientMapper;

    /**
     * 查询患者管理模块，用于管理患者的信息。
     * 
     * @param id 患者管理模块，用于管理患者的信息。主键
     * @return 患者管理模块，用于管理患者的信息。
     */
    @Override
    public CsPatient selectCsPatientById(Long id)
    {
        return csPatientMapper.selectCsPatientById(id);
    }

    /**
     * 查询患者管理模块，用于管理患者的信息。列表
     * 
     * @param csPatient 患者管理模块，用于管理患者的信息。
     * @return 患者管理模块，用于管理患者的信息。
     */
    @Override
    public List<CsPatient> selectCsPatientList(CsPatient csPatient)
    {
        return csPatientMapper.selectCsPatientList(csPatient);
    }

    /**
     * 新增患者管理模块，用于管理患者的信息。
     * 
     * @param csPatient 患者管理模块，用于管理患者的信息。
     * @return 结果
     */
    @Override
    public int insertCsPatient(CsPatient csPatient)
    {
        return csPatientMapper.insertCsPatient(csPatient);
    }

    /**
     * 修改患者管理模块，用于管理患者的信息。
     * 
     * @param csPatient 患者管理模块，用于管理患者的信息。
     * @return 结果
     */
    @Override
    public int updateCsPatient(CsPatient csPatient)
    {
        return csPatientMapper.updateCsPatient(csPatient);
    }

    /**
     * 批量删除患者管理模块，用于管理患者的信息。
     * 
     * @param ids 需要删除的患者管理模块，用于管理患者的信息。主键
     * @return 结果
     */
    @Override
    public int deleteCsPatientByIds(String ids)
    {
        return csPatientMapper.deleteCsPatientByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除患者管理模块，用于管理患者的信息。信息
     * 
     * @param id 患者管理模块，用于管理患者的信息。主键
     * @return 结果
     */
    @Override
    public int deleteCsPatientById(Long id)
    {
        return csPatientMapper.deleteCsPatientById(id);
    }
}
