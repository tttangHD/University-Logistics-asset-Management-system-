package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.CsSchedule;

/**
 * 排班管理模块，用于管理医生的排班信息。Service接口
 * 
 * @author ruoyi
 * @date 2023-08-15
 */
public interface ICsScheduleService 
{
    /**
     * 查询排班管理模块，用于管理医生的排班信息。
     * 
     * @param id 排班管理模块，用于管理医生的排班信息。主键
     * @return 排班管理模块，用于管理医生的排班信息。
     */
    public CsSchedule selectCsScheduleById(Long id);

    /**
     * 查询排班管理模块，用于管理医生的排班信息。列表
     * 
     * @param csSchedule 排班管理模块，用于管理医生的排班信息。
     * @return 排班管理模块，用于管理医生的排班信息。集合
     */
    public List<CsSchedule> selectCsScheduleList(CsSchedule csSchedule);

    /**
     * 新增排班管理模块，用于管理医生的排班信息。
     * 
     * @param csSchedule 排班管理模块，用于管理医生的排班信息。
     * @return 结果
     */
    public int insertCsSchedule(CsSchedule csSchedule);

    /**
     * 修改排班管理模块，用于管理医生的排班信息。
     * 
     * @param csSchedule 排班管理模块，用于管理医生的排班信息。
     * @return 结果
     */
    public int updateCsSchedule(CsSchedule csSchedule);

    /**
     * 批量删除排班管理模块，用于管理医生的排班信息。
     * 
     * @param ids 需要删除的排班管理模块，用于管理医生的排班信息。主键集合
     * @return 结果
     */
    public int deleteCsScheduleByIds(String ids);

    /**
     * 删除排班管理模块，用于管理医生的排班信息。信息
     * 
     * @param id 排班管理模块，用于管理医生的排班信息。主键
     * @return 结果
     */
    public int deleteCsScheduleById(Long id);
}
