package com.education.supplier.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.education.supplier.dao.SupplierOrderDao;
import com.education.supplier.service.SupplierOrderService;
import com.education.supplier.util.CommonUtil;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author： fanyafeng
 * Data： 2019-06-26 20:53
 * Email: fanyafeng@live.cn
 */
public class SupplierOrderServiceImpl implements SupplierOrderService {

    @Resource
    private SupplierOrderDao supplierOrderDao;

    /**
     * 查询订单
     */
    @Override
    public JSONObject listSupplierOrder(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        int count = supplierOrderDao.countSupplierOrder(jsonObject);
        List<JSONObject> list = supplierOrderDao.listSupplierOrder(jsonObject);
        return CommonUtil.successPage(jsonObject, list, count);
    }
}
