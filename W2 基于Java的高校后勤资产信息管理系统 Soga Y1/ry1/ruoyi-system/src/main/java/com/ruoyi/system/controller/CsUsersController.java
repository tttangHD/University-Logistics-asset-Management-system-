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
import com.ruoyi.system.domain.CsUsers;
import com.ruoyi.system.service.ICsUsersService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户管理Controller
 * 
 * @author ruoyi
 * @date 2024-08-20
 */
@Controller
@RequestMapping("/system/users")
public class CsUsersController extends BaseController
{
    private String prefix = "system/users";

    @Autowired
    private ICsUsersService csUsersService;

    @RequiresPermissions("system:users:view")
    @GetMapping()
    public String users()
    {
        return prefix + "/users";
    }

    /**
     * 查询用户管理列表
     */
    @RequiresPermissions("system:users:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CsUsers csUsers)
    {
        startPage();
        List<CsUsers> list = csUsersService.selectCsUsersList(csUsers);
        return getDataTable(list);
    }

    /**
     * 导出用户管理列表
     */
    @RequiresPermissions("system:users:export")
    @Log(title = "用户管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CsUsers csUsers)
    {
        List<CsUsers> list = csUsersService.selectCsUsersList(csUsers);
        ExcelUtil<CsUsers> util = new ExcelUtil<CsUsers>(CsUsers.class);
        return util.exportExcel(list, "用户管理数据");
    }

    /**
     * 新增用户管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存用户管理
     */
    @RequiresPermissions("system:users:add")
    @Log(title = "用户管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CsUsers csUsers)
    {
        return toAjax(csUsersService.insertCsUsers(csUsers));
    }

    /**
     * 修改用户管理
     */
    @RequiresPermissions("system:users:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        CsUsers csUsers = csUsersService.selectCsUsersById(id);
        mmap.put("csUsers", csUsers);
        return prefix + "/edit";
    }

    /**
     * 修改保存用户管理
     */
    @RequiresPermissions("system:users:edit")
    @Log(title = "用户管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CsUsers csUsers)
    {
        return toAjax(csUsersService.updateCsUsers(csUsers));
    }

    /**
     * 删除用户管理
     */
    @RequiresPermissions("system:users:remove")
    @Log(title = "用户管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(csUsersService.deleteCsUsersByIds(ids));
    }
}
