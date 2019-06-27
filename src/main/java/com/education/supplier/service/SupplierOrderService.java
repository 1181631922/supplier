package com.education.supplier.service;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * Author： fanyafeng
 * Data： 2019-06-26 20:50
 * Email: fanyafeng@live.cn
 */
public interface SupplierOrderService {
    /**
     * 添加订单应该在用户端
     */

    /**
     * 查询订单
     */
    JSONObject listSupplierOrder(JSONObject jsonObject);
}
