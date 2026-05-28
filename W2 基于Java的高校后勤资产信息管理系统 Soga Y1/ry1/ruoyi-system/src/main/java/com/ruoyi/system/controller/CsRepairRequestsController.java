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
import com.ruoyi.system.domain.CsRepairRequests;
import com.ruoyi.system.service.ICsRepairRequestsService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 报修请求Controller
 * 

 */
@Controller
@RequestMapping("/system/csrequests")
public class CsRepairRequestsController extends BaseController
{
    private String prefix = "system/csrequests";

    @Autowired
    private ICsRepairRequestsService csRepairRequestsService;

    @RequiresPermissions("system:csrequests:view")
    @GetMapping()
    public String csrequests()
    {
        return prefix + "/csrequests";
    }

    /**
     * 查询报修请求列表
     */
    @RequiresPermissions("system:csrequests:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CsRepairRequests csRepairRequests)
    {
        startPage();
        List<CsRepairRequests> list = csRepairRequestsService.selectCsRepairRequestsList(csRepairRequests);
        return getDataTable(list);
    }

    /**
     * 导出报修请求列表
     */
    @RequiresPermissions("system:csrequests:export")
    @Log(title = "报修请求", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CsRepairRequests csRepairRequests)
    {
        List<CsRepairRequests> list = csRepairRequestsService.selectCsRepairRequestsList(csRepairRequests);
        ExcelUtil<CsRepairRequests> util = new ExcelUtil<CsRepairRequests>(CsRepairRequests.class);
        return util.exportExcel(list, "报修请求数据");
    }

    /**
     * 新增报修请求
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存报修请求
     */
    @RequiresPermissions("system:csrequests:add")
    @Log(title = "报修请求", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CsRepairRequests csRepairRequests)
    {
        return toAjax(csRepairRequestsService.insertCsRepairRequests(csRepairRequests));
    }

    /**
     * 修改报修请求
     */
    @RequiresPermissions("system:csrequests:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        CsRepairRequests csRepairRequests = csRepairRequestsService.selectCsRepairRequestsById(id);
        mmap.put("csRepairRequests", csRepairRequests);
        return prefix + "/edit";
    }

    /**
     * 修改保存报修请求
     */
    @RequiresPermissions("system:csrequests:edit")
    @Log(title = "报修请求", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CsRepairRequests csRepairRequests)
    {
        return toAjax(csRepairRequestsService.updateCsRepairRequests(csRepairRequests));
    }

    /**
     * 删除报修请求
     */
    @RequiresPermissions("system:csrequests:remove")
    @Log(title = "报修请求", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(csRepairRequestsService.deleteCsRepairRequestsByIds(ids));
    }
}
