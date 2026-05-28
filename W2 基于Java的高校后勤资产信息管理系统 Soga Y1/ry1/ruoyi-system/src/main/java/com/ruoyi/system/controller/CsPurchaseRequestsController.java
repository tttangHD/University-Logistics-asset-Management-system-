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
import com.ruoyi.system.domain.CsPurchaseRequests;
import com.ruoyi.system.service.ICsPurchaseRequestsService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 采购申请Controller
 * 
 * @author ruoyi
 * @date 2024-03-19
 */
@Controller
@RequestMapping("/system/purchase")
public class CsPurchaseRequestsController extends BaseController
{
    private String prefix = "system/purchase";

    @Autowired
    private ICsPurchaseRequestsService csPurchaseRequestsService;

    @RequiresPermissions("system:purchase:view")
    @GetMapping()
    public String purchase()
    {
        return prefix + "/purchase";
    }

    /**
     * 查询采购申请列表
     */
    @RequiresPermissions("system:purchase:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CsPurchaseRequests csPurchaseRequests)
    {
        startPage();
        List<CsPurchaseRequests> list = csPurchaseRequestsService.selectCsPurchaseRequestsList(csPurchaseRequests);
        return getDataTable(list);
    }

    /**
     * 导出采购申请列表
     */
    @RequiresPermissions("system:purchase:export")
    @Log(title = "采购申请", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CsPurchaseRequests csPurchaseRequests)
    {
        List<CsPurchaseRequests> list = csPurchaseRequestsService.selectCsPurchaseRequestsList(csPurchaseRequests);
        ExcelUtil<CsPurchaseRequests> util = new ExcelUtil<CsPurchaseRequests>(CsPurchaseRequests.class);
        return util.exportExcel(list, "采购申请数据");
    }

    /**
     * 新增采购申请
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存采购申请
     */
    @RequiresPermissions("system:purchase:add")
    @Log(title = "采购申请", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CsPurchaseRequests csPurchaseRequests)
    {
        return toAjax(csPurchaseRequestsService.insertCsPurchaseRequests(csPurchaseRequests));
    }

    /**
     * 修改采购申请
     */
    @RequiresPermissions("system:purchase:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        CsPurchaseRequests csPurchaseRequests = csPurchaseRequestsService.selectCsPurchaseRequestsById(id);
        mmap.put("csPurchaseRequests", csPurchaseRequests);
        return prefix + "/edit";
    }

    /**
     * 修改保存采购申请
     */
    @RequiresPermissions("system:purchase:edit")
    @Log(title = "采购申请", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CsPurchaseRequests csPurchaseRequests)
    {
        return toAjax(csPurchaseRequestsService.updateCsPurchaseRequests(csPurchaseRequests));
    }

    /**
     * 删除采购申请
     */
    @RequiresPermissions("system:purchase:remove")
    @Log(title = "采购申请", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(csPurchaseRequestsService.deleteCsPurchaseRequestsByIds(ids));
    }
} 