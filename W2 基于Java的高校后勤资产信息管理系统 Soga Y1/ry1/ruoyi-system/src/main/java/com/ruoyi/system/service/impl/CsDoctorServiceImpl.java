package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CsDoctorMapper;
import com.ruoyi.system.domain.CsDoctor;
import com.ruoyi.system.service.ICsDoctorService;
import com.ruoyi.common.core.text.Convert;

/**
 * 医生管理模块，用于管理医生的信息。Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-08-15
 */
@Service
public class CsDoctorServiceImpl implements ICsDoctorService 
{
    @Autowired
    private CsDoctorMapper csDoctorMapper;

    /**
     * 查询医生管理模块，用于管理医生的信息。
     * 
     * @param id 医生管理模块，用于管理医生的信息。主键
     * @return 医生管理模块，用于管理医生的信息。
     */
    @Override
    public CsDoctor selectCsDoctorById(Long id)
    {
        return csDoctorMapper.selectCsDoctorById(id);
    }

    /**
     * 查询医生管理模块，用于管理医生的信息。列表
     * 
     * @param csDoctor 医生管理模块，用于管理医生的信息。
     * @return 医生管理模块，用于管理医生的信息。
     */
    @Override
    public List<CsDoctor> selectCsDoctorList(CsDoctor csDoctor)
    {
        return csDoctorMapper.selectCsDoctorList(csDoctor);
    }

    /**
     * 新增医生管理模块，用于管理医生的信息。
     * 
     * @param csDoctor 医生管理模块，用于管理医生的信息。
     * @return 结果
     */
    @Override
    public int insertCsDoctor(CsDoctor csDoctor)
    {
        return csDoctorMapper.insertCsDoctor(csDoctor);
    }

    /**
     * 修改医生管理模块，用于管理医生的信息。
     * 
     * @param csDoctor 医生管理模块，用于管理医生的信息。
     * @return 结果
     */
    @Override
    public int updateCsDoctor(CsDoctor csDoctor)
    {
        return csDoctorMapper.updateCsDoctor(csDoctor);
    }

    /**
     * 批量删除医生管理模块，用于管理医生的信息。
     * 
     * @param ids 需要删除的医生管理模块，用于管理医生的信息。主键
     * @return 结果
     */
    @Override
    public int deleteCsDoctorByIds(String ids)
    {
        return csDoctorMapper.deleteCsDoctorByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除医生管理模块，用于管理医生的信息。信息
     * 
     * @param id 医生管理模块，用于管理医生的信息。主键
     * @return 结果
     */
    @Override
    public int deleteCsDoctorById(Long id)
    {
        return csDoctorMapper.deleteCsDoctorById(id);
    }
}
