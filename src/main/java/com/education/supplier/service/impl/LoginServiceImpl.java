package com.education.supplier.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.education.supplier.dao.LoginMapper;
import com.education.supplier.model.Supplier;
import com.education.supplier.service.LoginService;
import com.education.supplier.service.PermissionService;
import com.education.supplier.util.Base64Util;
import com.education.supplier.util.CommonUtil;
import com.education.supplier.util.constants.Constants;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Author： fanyafeng
 * Data： 2019-06-18 18:59
 * Email: fanyafeng@live.cn
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    private LoginMapper loginMapper;

    @Resource
    private PermissionService permissionService;

    /**
     * 登录表单提交
     *
     * @param jsonObject
     * @return
     */
    @Override
    public JSONObject authLogin(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        String password = jsonObject.getString("password");
        JSONObject data = new JSONObject();
        Subject currentUser = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken(name, password);
        try {
            currentUser.login(token);
            data.put("result", "success");
            JSONObject token1 = loginMapper.getToken(name, password);
            Integer supplierId = token1.getIntValue("supplierId");
            if (supplierId < 10) {
                token1.put("supplierId", Base64Util.encode("0" + supplierId.toString()));
            } else {
                token1.put("supplierId", Base64Util.encode(supplierId.toString()));
            }
            token1.put("supplierToken", Base64Util.encodeToken(token1.getString("supplierToken")));
            data.put("userInfo", token1);

        } catch (AuthenticationException e) {
            data.put("result", "fail");
        }
        return CommonUtil.successJson(data);
    }

    /**
     * 根据手机号和密码获取对应用户
     *
     * @param name
     * @param password
     */
    @Override
    public JSONObject getSupplier(String name, String password) {
        return loginMapper.getSupplier(name, password);
    }

    /**
     * 退出登录
     */
    @Override
    public JSONObject logout() {
        try {
            Subject currentUser = SecurityUtils.getSubject();
            currentUser.logout();
        } catch (Exception e) {
        }
        return CommonUtil.successJson();
    }

    /**
     * 查询当前用户的权限等信息
     */
    @Override
    public JSONObject getInfo(Supplier supplier) {
        //从session获取用户信息
        Session session = SecurityUtils.getSubject().getSession();
        String name = supplier.getName();
        JSONObject info = new JSONObject();
        JSONObject userPermission = permissionService.getUserPermission(name);
        session.setAttribute(Constants.SESSION_USER_PERMISSION, userPermission);
        info.put("userPermission", userPermission);
        return CommonUtil.successJson(info);
    }


}
