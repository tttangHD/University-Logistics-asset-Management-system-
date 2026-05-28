package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.CsPrescription;

/**
 * 处方管理模块，用于管理医生开具的处方信息。Service接口
 * 
 * @author ruoyi
 * @date 2023-08-15
 */
public interface ICsPrescriptionService 
{
    /**
     * 查询处方管理模块，用于管理医生开具的处方信息。
     * 
     * @param id 处方管理模块，用于管理医生开具的处方信息。主键
     * @return 处方管理模块，用于管理医生开具的处方信息。
     */
    public CsPrescription selectCsPrescriptionById(Long id);

    /**
     * 查询处方管理模块，用于管理医生开具的处方信息。列表
     * 
     * @param csPrescription 处方管理模块，用于管理医生开具的处方信息。
     * @return 处方管理模块，用于管理医生开具的处方信息。集合
     */
    public List<CsPrescription> selectCsPrescriptionList(CsPrescription csPrescription);

    /**
     * 新增处方管理模块，用于管理医生开具的处方信息。
     * 
     * @param csPrescription 处方管理模块，用于管理医生开具的处方信息。
     * @return 结果
     */
    public int insertCsPrescription(CsPrescription csPrescription);

    /**
     * 修改处方管理模块，用于管理医生开具的处方信息。
     * 
     * @param csPrescription 处方管理模块，用于管理医生开具的处方信息。
     * @return 结果
     */
    public int updateCsPrescription(CsPrescription csPrescription);

    /**
     * 批量删除处方管理模块，用于管理医生开具的处方信息。
     * 
     * @param ids 需要删除的处方管理模块，用于管理医生开具的处方信息。主键集合
     * @return 结果
     */
    public int deleteCsPrescriptionByIds(String ids);

    /**
     * 删除处方管理模块，用于管理医生开具的处方信息。信息
     * 
     * @param id 处方管理模块，用于管理医生开具的处方信息。主键
     * @return 结果
     */
    public int deleteCsPrescriptionById(Long id);
}
