package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CsScheduleMapper;
import com.ruoyi.system.domain.CsSchedule;
import com.ruoyi.system.service.ICsScheduleService;
import com.ruoyi.common.core.text.Convert;

/**
 * 排班管理模块，用于管理医生的排班信息。Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-08-15
 */
@Service
public class CsScheduleServiceImpl implements ICsScheduleService 
{
    @Autowired
    private CsScheduleMapper csScheduleMapper;

    /**
     * 查询排班管理模块，用于管理医生的排班信息。
     * 
     * @param id 排班管理模块，用于管理医生的排班信息。主键
     * @return 排班管理模块，用于管理医生的排班信息。
     */
    @Override
    public CsSchedule selectCsScheduleById(Long id)
    {
        return csScheduleMapper.selectCsScheduleById(id);
    }

    /**
     * 查询排班管理模块，用于管理医生的排班信息。列表
     * 
     * @param csSchedule 排班管理模块，用于管理医生的排班信息。
     * @return 排班管理模块，用于管理医生的排班信息。
     */
    @Override
    public List<CsSchedule> selectCsScheduleList(CsSchedule csSchedule)
    {
        return csScheduleMapper.selectCsScheduleList(csSchedule);
    }

    /**
     * 新增排班管理模块，用于管理医生的排班信息。
     * 
     * @param csSchedule 排班管理模块，用于管理医生的排班信息。
     * @return 结果
     */
    @Override
    public int insertCsSchedule(CsSchedule csSchedule)
    {
        return csScheduleMapper.insertCsSchedule(csSchedule);
    }

    /**
     * 修改排班管理模块，用于管理医生的排班信息。
     * 
     * @param csSchedule 排班管理模块，用于管理医生的排班信息。
     * @return 结果
     */
    @Override
    public int updateCsSchedule(CsSchedule csSchedule)
    {
        return csScheduleMapper.updateCsSchedule(csSchedule);
    }

    /**
     * 批量删除排班管理模块，用于管理医生的排班信息。
     * 
     * @param ids 需要删除的排班管理模块，用于管理医生的排班信息。主键
     * @return 结果
     */
    @Override
    public int deleteCsScheduleByIds(String ids)
    {
        return csScheduleMapper.deleteCsScheduleByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除排班管理模块，用于管理医生的排班信息。信息
     * 
     * @param id 排班管理模块，用于管理医生的排班信息。主键
     * @return 结果
     */
    @Override
    public int deleteCsScheduleById(Long id)
    {
        return csScheduleMapper.deleteCsScheduleById(id);
    }
}
