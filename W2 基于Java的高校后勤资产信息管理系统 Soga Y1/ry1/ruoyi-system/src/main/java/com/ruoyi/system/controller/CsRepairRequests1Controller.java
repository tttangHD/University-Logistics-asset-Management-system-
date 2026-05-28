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
import com.ruoyi.system.domain.CsRepairRequests1;
import com.ruoyi.system.service.ICsRepairRequests1Service;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 报修审核Controller
 * 
 * @author ruoyi
 * @date 2024-08-20
 */
@Controller
@RequestMapping("/system/csrequests1")
public class CsRepairRequests1Controller extends BaseController
{
    private String prefix = "system/csrequests1";

    @Autowired
    private ICsRepairRequests1Service csRepairRequests1Service;

    @RequiresPermissions("system:csrequests1:view")
    @GetMapping()
    public String csrequests1()
    {
        return prefix + "/csrequests1";
    }

    /**
     * 查询报修审核列表
     */
    @RequiresPermissions("system:csrequests1:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CsRepairRequests1 csRepairRequests1)
    {
        startPage();
        List<CsRepairRequests1> list = csRepairRequests1Service.selectCsRepairRequests1List(csRepairRequests1);
        return getDataTable(list);
    }

    /**
     * 导出报修审核列表
     */
    @RequiresPermissions("system:csrequests1:export")
    @Log(title = "报修审核", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CsRepairRequests1 csRepairRequests1)
    {
        List<CsRepairRequests1> list = csRepairRequests1Service.selectCsRepairRequests1List(csRepairRequests1);
        ExcelUtil<CsRepairRequests1> util = new ExcelUtil<CsRepairRequests1>(CsRepairRequests1.class);
        return util.exportExcel(list, "报修审核数据");
    }

    /**
     * 新增报修审核
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存报修审核
     */
    @RequiresPermissions("system:csrequests1:add")
    @Log(title = "报修审核", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CsRepairRequests1 csRepairRequests1)
    {
        return toAjax(csRepairRequests1Service.insertCsRepairRequests1(csRepairRequests1));
    }

    /**
     * 修改报修审核
     */
    @RequiresPermissions("system:csrequests1:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        CsRepairRequests1 csRepairRequests1 = csRepairRequests1Service.selectCsRepairRequests1ById(id);
        mmap.put("csRepairRequests1", csRepairRequests1);
        return prefix + "/edit";
    }

    /**
     * 修改保存报修审核
     */
    @RequiresPermissions("system:csrequests1:edit")
    @Log(title = "报修审核", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CsRepairRequests1 csRepairRequests1)
    {
        return toAjax(csRepairRequests1Service.updateCsRepairRequests1(csRepairRequests1));
    }

    /**
     * 删除报修审核
     */
    @RequiresPermissions("system:csrequests1:remove")
    @Log(title = "报修审核", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(csRepairRequests1Service.deleteCsRepairRequests1ByIds(ids));
    }
}
