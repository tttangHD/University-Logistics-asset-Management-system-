package com.ruoyi.system.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.CsSchedule;
import com.ruoyi.system.service.ICsScheduleService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 排班管理模块，用于管理医生的排班信息。Controller
 * 
 * @author ruoyi
 * @date 2023-08-15
 */
@Controller
@RequestMapping("/system/schedule")
public class CsScheduleController extends BaseController
{
    private String prefix = "system/schedule";

    @Autowired
    private ICsScheduleService csScheduleService;

    @RequiresPermissions("system:schedule:view")
    @GetMapping()
    public String schedule()
    {
        return prefix + "/schedule";
    }

    /**
     * 查询排班管理模块，用于管理医生的排班信息。列表
     */
    @RequiresPermissions("system:schedule:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CsSchedule csSchedule)
    {
        startPage();
        List<CsSchedule> list = csScheduleService.selectCsScheduleList(csSchedule);
        return getDataTable(list);
    }

    /**
     * 导出排班管理模块，用于管理医生的排班信息。列表
     */
    @RequiresPermissions("system:schedule:export")
    @Log(title = "排班管理模块，用于管理医生的排班信息。", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CsSchedule csSchedule)
    {
        List<CsSchedule> list = csScheduleService.selectCsScheduleList(csSchedule);
        ExcelUtil<CsSchedule> util = new ExcelUtil<CsSchedule>(CsSchedule.class);
        return util.exportExcel(list, "排班管理模块，用于管理医生的排班信息。数据");
    }

    /**
     * 新增排班管理模块，用于管理医生的排班信息。
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存排班管理模块，用于管理医生的排班信息。
     */
    @RequiresPermissions("system:schedule:add")
    @Log(title = "排班管理模块，用于管理医生的排班信息。", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CsSchedule csSchedule)
    {
        return toAjax(csScheduleService.insertCsSchedule(csSchedule));
    }

    /**
     * 修改排班管理模块，用于管理医生的排班信息。
     */
    @RequiresPermissions("system:schedule:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        CsSchedule csSchedule = csScheduleService.selectCsScheduleById(id);
        mmap.put("csSchedule", csSchedule);
        return prefix + "/edit";
    }

    /**
     * 修改保存排班管理模块，用于管理医生的排班信息。
     */
    @RequiresPermissions("system:schedule:edit")
    @Log(title = "排班管理模块，用于管理医生的排班信息。", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CsSchedule csSchedule)
    {
        return toAjax(csScheduleService.updateCsSchedule(csSchedule));
    }

    /**
     * 删除排班管理模块，用于管理医生的排班信息。
     */
    @RequiresPermissions("system:schedule:remove")
    @Log(title = "排班管理模块，用于管理医生的排班信息。", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(csScheduleService.deleteCsScheduleByIds(ids));
    }
}
