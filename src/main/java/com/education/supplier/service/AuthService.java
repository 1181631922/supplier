package com.education.supplier.service;

import com.education.supplier.model.Supplier;

/**
 * Author： fanyafeng
 * Data： 2019-06-26 14:23
 * Email: fanyafeng@live.cn
 */
public interface AuthService {
    Supplier authByToken(String token);
}
