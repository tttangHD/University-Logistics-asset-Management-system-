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
import com.ruoyi.system.domain.CsAllocations;
import com.ruoyi.system.service.ICsAllocationsService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 资产分配Controller
 *
 */
@Controller
@RequestMapping("/system/csallocations")
public class CsAllocationsController extends BaseController
{
    private String prefix = "system/csallocations";

    @Autowired
    private ICsAllocationsService csAllocationsService;

    @RequiresPermissions("system:csallocations:view")
    @GetMapping()
    public String csallocations()
    {
        return prefix + "/csallocations";
    }

    /**
     * 查询资产分配列表
     */
    @RequiresPermissions("system:csallocations:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CsAllocations csAllocations)
    {
        startPage();
        List<CsAllocations> list = csAllocationsService.selectCsAllocationsList(csAllocations);
        return getDataTable(list);
    }

    /**
     * 导出资产分配列表
     */
    @RequiresPermissions("system:csallocations:export")
    @Log(title = "资产分配", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CsAllocations csAllocations)
    {
        List<CsAllocations> list = csAllocationsService.selectCsAllocationsList(csAllocations);
        ExcelUtil<CsAllocations> util = new ExcelUtil<CsAllocations>(CsAllocations.class);
        return util.exportExcel(list, "资产分配数据");
    }

    /**
     * 新增资产分配
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存资产分配
     */
    @RequiresPermissions("system:csallocations:add")
    @Log(title = "资产分配", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CsAllocations csAllocations)
    {
        return toAjax(csAllocationsService.insertCsAllocations(csAllocations));
    }

    /**
     * 修改资产分配
     */
    @RequiresPermissions("system:csallocations:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        CsAllocations csAllocations = csAllocationsService.selectCsAllocationsById(id);
        mmap.put("csAllocations", csAllocations);
        return prefix + "/edit";
    }

    /**
     * 修改保存资产分配
     */
    @RequiresPermissions("system:csallocations:edit")
    @Log(title = "资产分配", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CsAllocations csAllocations)
    {
        return toAjax(csAllocationsService.updateCsAllocations(csAllocations));
    }

    /**
     * 删除资产分配
     */
    @RequiresPermissions("system:csallocations:remove")
    @Log(title = "资产分配", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(csAllocationsService.deleteCsAllocationsByIds(ids));
    }
    
    /**
     * 更新所有已分配资产的状态为正常（1）
     */
    @RequiresPermissions("system:csallocations:edit")
    @Log(title = "资产分配", businessType = BusinessType.UPDATE)
    @PostMapping("/updateAllStatus")
    @ResponseBody
    public AjaxResult updateAllStatus()
    {
        int count = csAllocationsService.updateAllAllocatedAssetsStatus();
        return success("成功更新" + count + "个资产的状态为正常(1)");
    }
}
