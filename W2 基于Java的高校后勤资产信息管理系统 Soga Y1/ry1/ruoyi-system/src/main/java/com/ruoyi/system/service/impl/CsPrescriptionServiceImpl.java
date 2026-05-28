package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CsPrescriptionMapper;
import com.ruoyi.system.domain.CsPrescription;
import com.ruoyi.system.service.ICsPrescriptionService;
import com.ruoyi.common.core.text.Convert;

/**
 * 处方管理模块，用于管理医生开具的处方信息。Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-08-15
 */
@Service
public class CsPrescriptionServiceImpl implements ICsPrescriptionService 
{
    @Autowired
    private CsPrescriptionMapper csPrescriptionMapper;

    /**
     * 查询处方管理模块，用于管理医生开具的处方信息。
     * 
     * @param id 处方管理模块，用于管理医生开具的处方信息。主键
     * @return 处方管理模块，用于管理医生开具的处方信息。
     */
    @Override
    public CsPrescription selectCsPrescriptionById(Long id)
    {
        return csPrescriptionMapper.selectCsPrescriptionById(id);
    }

    /**
     * 查询处方管理模块，用于管理医生开具的处方信息。列表
     * 
     * @param csPrescription 处方管理模块，用于管理医生开具的处方信息。
     * @return 处方管理模块，用于管理医生开具的处方信息。
     */
    @Override
    public List<CsPrescription> selectCsPrescriptionList(CsPrescription csPrescription)
    {
        return csPrescriptionMapper.selectCsPrescriptionList(csPrescription);
    }

    /**
     * 新增处方管理模块，用于管理医生开具的处方信息。
     * 
     * @param csPrescription 处方管理模块，用于管理医生开具的处方信息。
     * @return 结果
     */
    @Override
    public int insertCsPrescription(CsPrescription csPrescription)
    {
        return csPrescriptionMapper.insertCsPrescription(csPrescription);
    }

    /**
     * 修改处方管理模块，用于管理医生开具的处方信息。
     * 
     * @param csPrescription 处方管理模块，用于管理医生开具的处方信息。
     * @return 结果
     */
    @Override
    public int updateCsPrescription(CsPrescription csPrescription)
    {
        return csPrescriptionMapper.updateCsPrescription(csPrescription);
    }

    /**
     * 批量删除处方管理模块，用于管理医生开具的处方信息。
     * 
     * @param ids 需要删除的处方管理模块，用于管理医生开具的处方信息。主键
     * @return 结果
     */
    @Override
    public int deleteCsPrescriptionByIds(String ids)
    {
        return csPrescriptionMapper.deleteCsPrescriptionByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除处方管理模块，用于管理医生开具的处方信息。信息
     * 
     * @param id 处方管理模块，用于管理医生开具的处方信息。主键
     * @return 结果
     */
    @Override
    public int deleteCsPrescriptionById(Long id)
    {
        return csPrescriptionMapper.deleteCsPrescriptionById(id);
    }
}
