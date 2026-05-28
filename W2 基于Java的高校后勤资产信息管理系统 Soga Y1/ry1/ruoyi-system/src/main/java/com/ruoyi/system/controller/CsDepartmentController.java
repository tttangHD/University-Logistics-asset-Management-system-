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
import com.ruoyi.system.domain.CsDepartment;
import com.ruoyi.system.service.ICsDepartmentService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 科室管理模块，用于管理医院的科室信息。Controller
 * 
 * @author ruoyi
 * @date 2023-08-15
 */
@Controller
@RequestMapping("/system/department")
public class CsDepartmentController extends BaseController
{
    private String prefix = "system/department";

    @Autowired
    private ICsDepartmentService csDepartmentService;

    @RequiresPermissions("system:department:view")
    @GetMapping()
    public String department()
    {
        return prefix + "/department";
    }

    /**
     * 查询科室管理模块，用于管理医院的科室信息。列表
     */
    @RequiresPermissions("system:department:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CsDepartment csDepartment)
    {
        startPage();
        List<CsDepartment> list = csDepartmentService.selectCsDepartmentList(csDepartment);
        return getDataTable(list);
    }

    /**
     * 导出科室管理模块，用于管理医院的科室信息。列表
     */
    @RequiresPermissions("system:department:export")
    @Log(title = "科室管理模块，用于管理医院的科室信息。", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CsDepartment csDepartment)
    {
        List<CsDepartment> list = csDepartmentService.selectCsDepartmentList(csDepartment);
        ExcelUtil<CsDepartment> util = new ExcelUtil<CsDepartment>(CsDepartment.class);
        return util.exportExcel(list, "科室管理模块，用于管理医院的科室信息。数据");
    }

    /**
     * 新增科室管理模块，用于管理医院的科室信息。
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存科室管理模块，用于管理医院的科室信息。
     */
    @RequiresPermissions("system:department:add")
    @Log(title = "科室管理模块，用于管理医院的科室信息。", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CsDepartment csDepartment)
    {
        return toAjax(csDepartmentService.insertCsDepartment(csDepartment));
    }

    /**
     * 修改科室管理模块，用于管理医院的科室信息。
     */
    @RequiresPermissions("system:department:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        CsDepartment csDepartment = csDepartmentService.selectCsDepartmentById(id);
        mmap.put("csDepartment", csDepartment);
        return prefix + "/edit";
    }

    /**
     * 修改保存科室管理模块，用于管理医院的科室信息。
     */
    @RequiresPermissions("system:department:edit")
    @Log(title = "科室管理模块，用于管理医院的科室信息。", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CsDepartment csDepartment)
    {
        return toAjax(csDepartmentService.updateCsDepartment(csDepartment));
    }

    /**
     * 删除科室管理模块，用于管理医院的科室信息。
     */
    @RequiresPermissions("system:department:remove")
    @Log(title = "科室管理模块，用于管理医院的科室信息。", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(csDepartmentService.deleteCsDepartmentByIds(ids));
    }
}
