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
import com.ruoyi.system.domain.CsAssetDetails;
import com.ruoyi.system.service.ICsAssetDetailsService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.dao.DuplicateKeyException;

/**
 * 资产数据详情Controller
 * 
 * @author ruoyi
 * @date 2024-08-20
 */
@Controller
@RequestMapping("/system/csdetails")
public class CsAssetDetailsController extends BaseController
{
    private String prefix = "system/csdetails";

    @Autowired
    private ICsAssetDetailsService csAssetDetailsService;

    @RequiresPermissions("system:csdetails:view")
    @GetMapping()
    public String csdetails()
    {
        return prefix + "/csdetails";
    }

    /**
     * 查询资产数据详情列表
     */
    @RequiresPermissions("system:csdetails:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CsAssetDetails csAssetDetails)
    {
        startPage();
        List<CsAssetDetails> list = csAssetDetailsService.selectCsAssetDetailsList(csAssetDetails);
        return getDataTable(list);
    }

    /**
     * 导出资产数据详情列表
     */
    @RequiresPermissions("system:csdetails:export")
    @Log(title = "资产数据详情", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CsAssetDetails csAssetDetails)
    {
        List<CsAssetDetails> list = csAssetDetailsService.selectCsAssetDetailsList(csAssetDetails);
        ExcelUtil<CsAssetDetails> util = new ExcelUtil<CsAssetDetails>(CsAssetDetails.class);
        return util.exportExcel(list, "资产数据详情数据");
    }

    /**
     * 新增资产数据详情
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存资产数据详情
     */
    @RequiresPermissions("system:csdetails:add")
    @Log(title = "资产数据详情", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CsAssetDetails csAssetDetails)
    {
        try {
            return toAjax(csAssetDetailsService.insertCsAssetDetails(csAssetDetails));
        } catch (DuplicateKeyException e) {
            return AjaxResult.error("该资产ID已存在，请检查后重新输入");
        } catch (Exception e) {
            return AjaxResult.error("添加失败：" + e.getMessage());
        }
    }

    /**
     * 修改资产数据详情
     */
    @RequiresPermissions("system:csdetails:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        CsAssetDetails csAssetDetails = csAssetDetailsService.selectCsAssetDetailsById(id);
        mmap.put("csAssetDetails", csAssetDetails);
        return prefix + "/edit";
    }

    /**
     * 修改保存资产数据详情
     */
    @RequiresPermissions("system:csdetails:edit")
    @Log(title = "资产数据详情", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CsAssetDetails csAssetDetails)
    {
        try {
            return toAjax(csAssetDetailsService.updateCsAssetDetails(csAssetDetails));
        } catch (DuplicateKeyException e) {
            return AjaxResult.error("该资产ID已存在，请检查后重新输入");
        } catch (Exception e) {
            return AjaxResult.error("修改失败：" + e.getMessage());
        }
    }

    /**
     * 删除资产数据详情
     */
    @RequiresPermissions("system:csdetails:remove")
    @Log(title = "资产数据详情", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(csAssetDetailsService.deleteCsAssetDetailsByIds(ids));
    }
}
