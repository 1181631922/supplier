package com.education.supplier.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.education.supplier.dao.SupplierMapper;
import com.education.supplier.model.Supplier;
import com.education.supplier.service.SupplierService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Author： fanyafeng
 * Data： 2019-06-20 20:49
 * Email: fanyafeng@live.cn
 */
@Service("supplierService")
public class SupplierServiceImpl implements SupplierService {
    @Resource
    private SupplierMapper supplierMapper;

    @Override
    public int addSupplier(Supplier supplier) {

        return supplierMapper.insertSelective(supplier);
    }
}
