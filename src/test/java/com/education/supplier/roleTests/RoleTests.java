package com.education.supplier.roleTests;

import com.alibaba.fastjson.JSONObject;
import com.education.supplier.dao.PermissionMapper;
import com.education.supplier.dao.RoleMapper;
import com.education.supplier.dao.RolePermissionMapper;
import com.education.supplier.dao.UserMapper;
import com.education.supplier.model.Permission;
import com.education.supplier.model.Role;
import com.education.supplier.model.RolePermission;
import com.education.supplier.model.User;
import com.education.supplier.service.LoginService;
import com.education.supplier.service.PermissionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Author： fanyafeng
 * Data： 2019-06-24 15:48
 * Email: fanyafeng@live.cn
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleTests {
    @Resource
    private RoleMapper roleMapper;

    @Resource
    private PermissionMapper permissionMapper;

    @Resource
    private RolePermissionMapper rolePermissionMapper;

    @Resource
    private PermissionService permissionService;

    @Resource
    private LoginService loginService;

    @Resource
    private UserMapper userMapper;

    @Test
    public void getUserInfo(){
//        loginService.getInfo();
    }

    @Test
    public void checkPermission() {
        JSONObject jsonObject = permissionService.getUserPermission("test");
        System.out.println(jsonObject.toString());
    }


    @Test
    public void addRole() {
        Role role = new Role();
        role.setRoleName("教师");
        role.setCreateTime(new Date());
        role.setUpdateTime(new Date());
        roleMapper.insertSelective(role);
    }

    @Test
    public void addPermission() {
        Permission permission = new Permission();
        permission.setId(704);
        permission.setMenuCode("role");
        permission.setMenuName("角色权限");
        permission.setPermissionCode("role:delete");
        permission.setPermissionName("删除");
        permission.setRequiredPermission(true);
        permissionMapper.insertSelective(permission);
    }

    @Test
    public void addRolePermission() {
        RolePermission rolePermission = new RolePermission();
        rolePermission.setRoleId(2);
        rolePermission.setPermissionId(103);
        rolePermission.setCreateTime(new Date());
        rolePermission.setUpdateTime(new Date());
        rolePermissionMapper.insertSelective(rolePermission);
    }

    @Test
    public void addUser(){
        User user=new User();
        user.setMobile("18010479516");
        user.setName("测试");
        user.setPassword("password");
        user.setNickname("测试昵称");
        user.setStatus(0);
        userMapper.insert(user);
    }
}
