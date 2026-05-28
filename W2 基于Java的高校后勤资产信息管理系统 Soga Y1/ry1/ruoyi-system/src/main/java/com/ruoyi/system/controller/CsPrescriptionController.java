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
import com.ruoyi.system.domain.CsPrescription;
import com.ruoyi.system.service.ICsPrescriptionService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 处方管理模块，用于管理医生开具的处方信息。Controller
 * 
 * @author ruoyi
 * @date 2023-08-15
 */
@Controller
@RequestMapping("/system/prescription")
public class CsPrescriptionController extends BaseController
{
    private String prefix = "system/prescription";

    @Autowired
    private ICsPrescriptionService csPrescriptionService;

    @RequiresPermissions("system:prescription:view")
    @GetMapping()
    public String prescription()
    {
        return prefix + "/prescription";
    }

    /**
     * 查询处方管理模块，用于管理医生开具的处方信息。列表
     */
    @RequiresPermissions("system:prescription:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CsPrescription csPrescription)
    {
        startPage();
        List<CsPrescription> list = csPrescriptionService.selectCsPrescriptionList(csPrescription);
        return getDataTable(list);
    }

    /**
     * 导出处方管理模块，用于管理医生开具的处方信息。列表
     */
    @RequiresPermissions("system:prescription:export")
    @Log(title = "处方管理模块，用于管理医生开具的处方信息。", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CsPrescription csPrescription)
    {
        List<CsPrescription> list = csPrescriptionService.selectCsPrescriptionList(csPrescription);
        ExcelUtil<CsPrescription> util = new ExcelUtil<CsPrescription>(CsPrescription.class);
        return util.exportExcel(list, "处方管理模块，用于管理医生开具的处方信息。数据");
    }

    /**
     * 新增处方管理模块，用于管理医生开具的处方信息。
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存处方管理模块，用于管理医生开具的处方信息。
     */
    @RequiresPermissions("system:prescription:add")
    @Log(title = "处方管理模块，用于管理医生开具的处方信息。", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CsPrescription csPrescription)
    {
        return toAjax(csPrescriptionService.insertCsPrescription(csPrescription));
    }

    /**
     * 修改处方管理模块，用于管理医生开具的处方信息。
     */
    @RequiresPermissions("system:prescription:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        CsPrescription csPrescription = csPrescriptionService.selectCsPrescriptionById(id);
        mmap.put("csPrescription", csPrescription);
        return prefix + "/edit";
    }

    /**
     * 修改保存处方管理模块，用于管理医生开具的处方信息。
     */
    @RequiresPermissions("system:prescription:edit")
    @Log(title = "处方管理模块，用于管理医生开具的处方信息。", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CsPrescription csPrescription)
    {
        return toAjax(csPrescriptionService.updateCsPrescription(csPrescription));
    }

    /**
     * 删除处方管理模块，用于管理医生开具的处方信息。
     */
    @RequiresPermissions("system:prescription:remove")
    @Log(title = "处方管理模块，用于管理医生开具的处方信息。", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(csPrescriptionService.deleteCsPrescriptionByIds(ids));
    }
}
