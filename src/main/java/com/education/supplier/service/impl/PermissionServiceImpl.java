package com.education.supplier.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.education.supplier.dao.PermissionDao;
import com.education.supplier.service.PermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;

/**
 * Author： fanyafeng
 * Data： 2019-06-24 18:26
 * Email: fanyafeng@live.cn
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Resource
    private PermissionDao permissionDao;

    /**
     * 查询用户的 角色 菜单列表 权限列表
     *
     * @param name
     */
    @Override
    public JSONObject getUserPermission(String name) {
        JSONObject userPermission = getUserPermissionFromDB(name);
        return userPermission;
    }

    /**
     * 从数据库查询用户权限信息
     */
    private JSONObject getUserPermissionFromDB(String name) {
        JSONObject userPermission = permissionDao.getUserPermission(name);
        //管理员角色id为1
        int adminRoleId = 1;
        //如果是管理员
        String roleIdKey = "roleId";
        if (adminRoleId == userPermission.getIntValue(roleIdKey)) {
            Set<String> menuList = permissionDao.getAllMenu();
            Set<String> permissionList = permissionDao.getAllPermission();
            userPermission.put("menuList", menuList);
            userPermission.put("permissionList", permissionList);
        }
        return userPermission;
    }
}
