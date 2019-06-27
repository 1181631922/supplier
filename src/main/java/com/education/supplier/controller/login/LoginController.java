package com.education.supplier.controller.login;

import com.alibaba.fastjson.JSONObject;
import com.education.supplier.interceptor.AccessRequired;
import com.education.supplier.model.Supplier;
import com.education.supplier.service.LoginService;
import com.education.supplier.util.CommonUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Author： fanyafeng
 * Data： 2019-06-18 18:50
 * Email: fanyafeng@live.cn
 */
@CrossOrigin
@RestController
@RequestMapping("/login")
public class LoginController {

    @Resource
    private LoginService loginService;

    @PostMapping("/auth")
    public JSONObject authLogin(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "name,password");
        return loginService.authLogin(requestJson);
    }

    @PostMapping("/getInfo")
    public JSONObject getInfo(Supplier supplier){
        return loginService.getInfo(supplier);
    }

    @PostMapping("/logout")
    public JSONObject logout() {
        return loginService.logout();
    }
}
