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
import com.ruoyi.system.domain.CsRegistration;
import com.ruoyi.system.service.ICsRegistrationService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 挂号管理模块，用于管理患者的挂号信息。Controller
 * 
 * @author ruoyi
 * @date 2023-08-15
 */
@Controller
@RequestMapping("/system/registration")
public class CsRegistrationController extends BaseController
{
    private String prefix = "system/registration";

    @Autowired
    private ICsRegistrationService csRegistrationService;

    @RequiresPermissions("system:registration:view")
    @GetMapping()
    public String registration()
    {
        return prefix + "/registration";
    }

    /**
     * 查询挂号管理模块，用于管理患者的挂号信息。列表
     */
    @RequiresPermissions("system:registration:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CsRegistration csRegistration)
    {
        startPage();
        List<CsRegistration> list = csRegistrationService.selectCsRegistrationList(csRegistration);
        return getDataTable(list);
    }

    /**
     * 导出挂号管理模块，用于管理患者的挂号信息。列表
     */
    @RequiresPermissions("system:registration:export")
    @Log(title = "挂号管理模块，用于管理患者的挂号信息。", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CsRegistration csRegistration)
    {
        List<CsRegistration> list = csRegistrationService.selectCsRegistrationList(csRegistration);
        ExcelUtil<CsRegistration> util = new ExcelUtil<CsRegistration>(CsRegistration.class);
        return util.exportExcel(list, "挂号管理模块，用于管理患者的挂号信息。数据");
    }

    /**
     * 新增挂号管理模块，用于管理患者的挂号信息。
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存挂号管理模块，用于管理患者的挂号信息。
     */
    @RequiresPermissions("system:registration:add")
    @Log(title = "挂号管理模块，用于管理患者的挂号信息。", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CsRegistration csRegistration)
    {
        return toAjax(csRegistrationService.insertCsRegistration(csRegistration));
    }

    /**
     * 修改挂号管理模块，用于管理患者的挂号信息。
     */
    @RequiresPermissions("system:registration:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        CsRegistration csRegistration = csRegistrationService.selectCsRegistrationById(id);
        mmap.put("csRegistration", csRegistration);
        return prefix + "/edit";
    }

    /**
     * 修改保存挂号管理模块，用于管理患者的挂号信息。
     */
    @RequiresPermissions("system:registration:edit")
    @Log(title = "挂号管理模块，用于管理患者的挂号信息。", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CsRegistration csRegistration)
    {
        return toAjax(csRegistrationService.updateCsRegistration(csRegistration));
    }

    /**
     * 删除挂号管理模块，用于管理患者的挂号信息。
     */
    @RequiresPermissions("system:registration:remove")
    @Log(title = "挂号管理模块，用于管理患者的挂号信息。", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(csRegistrationService.deleteCsRegistrationByIds(ids));
    }
}
