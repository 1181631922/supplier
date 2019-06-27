package com.education.supplier.service.impl;

import com.education.supplier.dao.SupplierDao;
import com.education.supplier.dao.SupplierMapper;
import com.education.supplier.model.Supplier;
import com.education.supplier.service.AuthService;
import com.education.supplier.util.Base64Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Author： fanyafeng
 * Data： 2019-06-26 14:27
 * Email: fanyafeng@live.cn
 */
@Service
public class AuthServiceImpl implements AuthService {

    @Resource
    private SupplierMapper supplierMapper;

    @Override
    public Supplier authByToken(String token) {
        String[] strings = token.split("%");
        if (strings.length != 2) {
            return null;
        }
        String supplierId = Base64Util.decode(strings[0]);
        String supplierToken = Base64Util.decodeToken(strings[1]);
        Supplier supplier = supplierMapper.selectByPrimaryKey(Integer.parseInt(supplierId));
        if (supplier != null && supplierToken.equals(supplier.getSupplierToken())) {
            return supplier;
        } else {
            return null;
        }
    }
}
