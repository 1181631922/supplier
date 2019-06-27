package com.education.supplier.service.impl;

import com.education.supplier.dao.UserMapper;
import com.education.supplier.model.User;
import com.education.supplier.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Author： fanyafeng
 * Data： 2019-06-18 11:34
 * Email: fanyafeng@live.cn
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public int addUser(User user) {
        return userMapper.insertSelective(user);
    }
}
