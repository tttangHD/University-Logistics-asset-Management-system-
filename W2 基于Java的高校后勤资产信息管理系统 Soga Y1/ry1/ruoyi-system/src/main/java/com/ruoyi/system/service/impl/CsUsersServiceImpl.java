package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CsUsersMapper;
import com.ruoyi.system.domain.CsUsers;
import com.ruoyi.system.service.ICsUsersService;
import com.ruoyi.common.core.text.Convert;

/**
 * 用户管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-08-20
 */
@Service
public class CsUsersServiceImpl implements ICsUsersService 
{
    @Autowired
    private CsUsersMapper csUsersMapper;

    /**
     * 查询用户管理
     * 
     * @param id 用户管理主键
     * @return 用户管理
     */
    @Override
    public CsUsers selectCsUsersById(Long id)
    {
        return csUsersMapper.selectCsUsersById(id);
    }

    /**
     * 查询用户管理列表
     * 
     * @param csUsers 用户管理
     * @return 用户管理
     */
    @Override
    public List<CsUsers> selectCsUsersList(CsUsers csUsers)
    {
        return csUsersMapper.selectCsUsersList(csUsers);
    }

    /**
     * 新增用户管理
     * 
     * @param csUsers 用户管理
     * @return 结果
     */
    @Override
    public int insertCsUsers(CsUsers csUsers)
    {
        return csUsersMapper.insertCsUsers(csUsers);
    }

    /**
     * 修改用户管理
     * 
     * @param csUsers 用户管理
     * @return 结果
     */
    @Override
    public int updateCsUsers(CsUsers csUsers)
    {
        return csUsersMapper.updateCsUsers(csUsers);
    }

    /**
     * 批量删除用户管理
     * 
     * @param ids 需要删除的用户管理主键
     * @return 结果
     */
    @Override
    public int deleteCsUsersByIds(String ids)
    {
        return csUsersMapper.deleteCsUsersByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除用户管理信息
     * 
     * @param id 用户管理主键
     * @return 结果
     */
    @Override
    public int deleteCsUsersById(Long id)
    {
        return csUsersMapper.deleteCsUsersById(id);
    }
}
