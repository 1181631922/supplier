package com.education.supplier.controller;

import com.education.supplier.model.User;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author： fanyafeng
 * Data： 2019-06-20 19:18
 * Email: fanyafeng@live.cn
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/testBoot")
public class TestBootController {
    @RequestMapping("getUser")
    public User getUser() {
        User user=new User();
        user.setName("樊亚风");
        return user;
    }
}
