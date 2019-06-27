package com.education.supplier.service;

import com.alibaba.fastjson.JSONObject;
import com.education.supplier.model.Supplier;

/**
 * Author： fanyafeng
 * Data： 2019-06-18 18:55
 * Email: fanyafeng@live.cn
 */
public interface LoginService {

    /**
     * 登录表单提交
     * @param jsonObject
     * @return
     */
    JSONObject authLogin(JSONObject jsonObject);

    /**
     * 根据手机号和密码获取对应用户
     */
    JSONObject getSupplier(String name, String password);

    /**
     * 退出登录
     */
    JSONObject logout();

    /**
     * 查询当前用户的权限等信息
     */
    JSONObject getInfo(Supplier supplier);
}
