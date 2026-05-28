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
import com.ruoyi.system.domain.CsAssets;
import com.ruoyi.system.service.ICsAssetsService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.dao.DuplicateKeyException;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 * 资产管理Controller
 * 
 * @author ruoyi
 * @date 2024-08-20
 */
@Controller
@RequestMapping("/system/csassets")
public class CsAssetsController extends BaseController
{
    private String prefix = "system/csassets";

    @Autowired
    private ICsAssetsService csAssetsService;

    @RequiresPermissions("system:csassets:view")
    @GetMapping()
    public String csassets()
    {
        return prefix + "/csassets";
    }

    /**
     * 查询资产管理列表
     */
    @RequiresPermissions("system:csassets:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CsAssets csAssets)
    {
        startPage();
        List<CsAssets> list = csAssetsService.selectCsAssetsList(csAssets);
        return getDataTable(list);
    }

    /**
     * 导出资产管理列表
     */
    @RequiresPermissions("system:csassets:export")
    @Log(title = "资产管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CsAssets csAssets)
    {
        List<CsAssets> list = csAssetsService.selectCsAssetsList(csAssets);
        ExcelUtil<CsAssets> util = new ExcelUtil<CsAssets>(CsAssets.class);
        return util.exportExcel(list, "资产管理数据");
    }

    /**
     * 新增资产管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存资产管理
     */
    @RequiresPermissions("system:csassets:add")
    @Log(title = "资产管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CsAssets csAssets)
    {
        try {
            return toAjax(csAssetsService.insertCsAssets(csAssets));
        } catch (DuplicateKeyException e) {
            return AjaxResult.error("该资产ID已存在，请检查后重新输入");
        } catch (Exception e) {
            if (e.getCause() instanceof SQLIntegrityConstraintViolationException) {
                return AjaxResult.error("该资产ID已存在，请检查后重新输入");
            }
            return AjaxResult.error("添加失败：" + e.getMessage());
        }
    }

    /**
     * 修改资产管理
     */
    @RequiresPermissions("system:csassets:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        CsAssets csAssets = csAssetsService.selectCsAssetsById(id);
        mmap.put("csAssets", csAssets);
        return prefix + "/edit";
    }

    /**
     * 修改保存资产管理
     */
    @RequiresPermissions("system:csassets:edit")
    @Log(title = "资产管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CsAssets csAssets)
    {
        try {
            return toAjax(csAssetsService.updateCsAssets(csAssets));
        } catch (DuplicateKeyException e) {
            return AjaxResult.error("该资产ID已存在，请检查后重新输入");
        } catch (Exception e) {
            if (e.getCause() instanceof SQLIntegrityConstraintViolationException) {
                return AjaxResult.error("该资产ID已存在，请检查后重新输入");
            }
            return AjaxResult.error("修改失败：" + e.getMessage());
        }
    }

    /**
     * 删除资产管理
     */
    @RequiresPermissions("system:csassets:remove")
    @Log(title = "资产管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(csAssetsService.deleteCsAssetsByIds(ids));
    }
}
