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
import com.ruoyi.system.domain.CsPatient;
import com.ruoyi.system.service.ICsPatientService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 患者管理模块，用于管理患者的信息。Controller
 * 
 * @author ruoyi
 * @date 2023-08-15
 */
@Controller
@RequestMapping("/system/patient")
public class CsPatientController extends BaseController
{
    private String prefix = "system/patient";

    @Autowired
    private ICsPatientService csPatientService;

    @RequiresPermissions("system:patient:view")
    @GetMapping()
    public String patient()
    {
        return prefix + "/patient";
    }

    /**
     * 查询患者管理模块，用于管理患者的信息。列表
     */
    @RequiresPermissions("system:patient:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CsPatient csPatient)
    {
        startPage();
        List<CsPatient> list = csPatientService.selectCsPatientList(csPatient);
        return getDataTable(list);
    }

    /**
     * 导出患者管理模块，用于管理患者的信息。列表
     */
    @RequiresPermissions("system:patient:export")
    @Log(title = "患者管理模块，用于管理患者的信息。", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CsPatient csPatient)
    {
        List<CsPatient> list = csPatientService.selectCsPatientList(csPatient);
        ExcelUtil<CsPatient> util = new ExcelUtil<CsPatient>(CsPatient.class);
        return util.exportExcel(list, "患者管理模块，用于管理患者的信息。数据");
    }

    /**
     * 新增患者管理模块，用于管理患者的信息。
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存患者管理模块，用于管理患者的信息。
     */
    @RequiresPermissions("system:patient:add")
    @Log(title = "患者管理模块，用于管理患者的信息。", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CsPatient csPatient)
    {
        return toAjax(csPatientService.insertCsPatient(csPatient));
    }

    /**
     * 修改患者管理模块，用于管理患者的信息。
     */
    @RequiresPermissions("system:patient:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        CsPatient csPatient = csPatientService.selectCsPatientById(id);
        mmap.put("csPatient", csPatient);
        return prefix + "/edit";
    }

    /**
     * 修改保存患者管理模块，用于管理患者的信息。
     */
    @RequiresPermissions("system:patient:edit")
    @Log(title = "患者管理模块，用于管理患者的信息。", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CsPatient csPatient)
    {
        return toAjax(csPatientService.updateCsPatient(csPatient));
    }

    /**
     * 删除患者管理模块，用于管理患者的信息。
     */
    @RequiresPermissions("system:patient:remove")
    @Log(title = "患者管理模块，用于管理患者的信息。", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(csPatientService.deleteCsPatientByIds(ids));
    }
}
