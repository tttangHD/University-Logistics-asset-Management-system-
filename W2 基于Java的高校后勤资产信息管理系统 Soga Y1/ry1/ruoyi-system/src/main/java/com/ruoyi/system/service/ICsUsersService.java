package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.CsUsers;

/**
 * 用户管理Service接口
 * 
 * @author ruoyi
 * @date 2024-08-20
 */
public interface ICsUsersService 
{
    /**
     * 查询用户管理
     * 
     * @param id 用户管理主键
     * @return 用户管理
     */
    public CsUsers selectCsUsersById(Long id);

    /**
     * 查询用户管理列表
     * 
     * @param csUsers 用户管理
     * @return 用户管理集合
     */
    public List<CsUsers> selectCsUsersList(CsUsers csUsers);

    /**
     * 新增用户管理
     * 
     * @param csUsers 用户管理
     * @return 结果
     */
    public int insertCsUsers(CsUsers csUsers);

    /**
     * 修改用户管理
     * 
     * @param csUsers 用户管理
     * @return 结果
     */
    public int updateCsUsers(CsUsers csUsers);

    /**
     * 批量删除用户管理
     * 
     * @param ids 需要删除的用户管理主键集合
     * @return 结果
     */
    public int deleteCsUsersByIds(String ids);

    /**
     * 删除用户管理信息
     * 
     * @param id 用户管理主键
     * @return 结果
     */
    public int deleteCsUsersById(Long id);
}
