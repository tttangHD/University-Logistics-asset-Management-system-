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
import com.ruoyi.system.domain.CsDoctor;
import com.ruoyi.system.service.ICsDoctorService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 医生管理模块，用于管理医生的信息。Controller
 * 
 * @author ruoyi
 * @date 2023-08-15
 */
@Controller
@RequestMapping("/system/doctor")
public class CsDoctorController extends BaseController
{
    private String prefix = "system/doctor";

    @Autowired
    private ICsDoctorService csDoctorService;

    @RequiresPermissions("system:doctor:view")
    @GetMapping()
    public String doctor()
    {
        return prefix + "/doctor";
    }

    /**
     * 查询医生管理模块，用于管理医生的信息。列表
     */
    @RequiresPermissions("system:doctor:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CsDoctor csDoctor)
    {
        startPage();
        List<CsDoctor> list = csDoctorService.selectCsDoctorList(csDoctor);
        return getDataTable(list);
    }

    /**
     * 导出医生管理模块，用于管理医生的信息。列表
     */
    @RequiresPermissions("system:doctor:export")
    @Log(title = "医生管理模块，用于管理医生的信息。", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CsDoctor csDoctor)
    {
        List<CsDoctor> list = csDoctorService.selectCsDoctorList(csDoctor);
        ExcelUtil<CsDoctor> util = new ExcelUtil<CsDoctor>(CsDoctor.class);
        return util.exportExcel(list, "医生管理模块，用于管理医生的信息。数据");
    }

    /**
     * 新增医生管理模块，用于管理医生的信息。
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存医生管理模块，用于管理医生的信息。
     */
    @RequiresPermissions("system:doctor:add")
    @Log(title = "医生管理模块，用于管理医生的信息。", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CsDoctor csDoctor)
    {
        return toAjax(csDoctorService.insertCsDoctor(csDoctor));
    }

    /**
     * 修改医生管理模块，用于管理医生的信息。
     */
    @RequiresPermissions("system:doctor:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        CsDoctor csDoctor = csDoctorService.selectCsDoctorById(id);
        mmap.put("csDoctor", csDoctor);
        return prefix + "/edit";
    }

    /**
     * 修改保存医生管理模块，用于管理医生的信息。
     */
    @RequiresPermissions("system:doctor:edit")
    @Log(title = "医生管理模块，用于管理医生的信息。", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CsDoctor csDoctor)
    {
        return toAjax(csDoctorService.updateCsDoctor(csDoctor));
    }

    /**
     * 删除医生管理模块，用于管理医生的信息。
     */
    @RequiresPermissions("system:doctor:remove")
    @Log(title = "医生管理模块，用于管理医生的信息。", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(csDoctorService.deleteCsDoctorByIds(ids));
    }
}
