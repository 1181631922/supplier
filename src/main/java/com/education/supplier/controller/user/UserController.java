package com.education.supplier.controller.user;

import com.education.supplier.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author： fanyafeng
 * Data： 2019-06-17 17:59
 * Email: fanyafeng@live.cn
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/list")
    public User listUser() {
        User user = new User();
        user.setName("樊亚风");
        user.setNickname("昵称");
        user.setPassword("testpassword");
        user.setMobile("18010479518");
        return user;
    }
}
