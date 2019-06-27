package com.education.supplier.dao;

import com.alibaba.fastjson.JSONObject;

import java.util.Set;

/**
 * Author： fanyafeng
 * Data： 2019-06-24 18:27
 * Email: fanyafeng@live.cn
 */
public interface PermissionDao {
    /**
     * 查询用户的角色 菜单 权限
     */
    JSONObject getUserPermission(String name);

    /**
     * 查询所有的菜单
     */
    Set<String> getAllMenu();

    /**
     * 查询所有权限
     */
    Set<String> getAllPermission();
}
