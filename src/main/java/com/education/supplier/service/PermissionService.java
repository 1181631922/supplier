package com.education.supplier.service;

import com.alibaba.fastjson.JSONObject;

/**
 * Author： fanyafeng
 * Data： 2019-06-24 18:24
 * Email: fanyafeng@live.cn
 */
public interface PermissionService {
    /**
     * 查询用户的 角色 菜单列表 权限列表
     */
    JSONObject getUserPermission(String name);
}
