package com.education.supplier.dao;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * Author： fanyafeng
 * Data： 2019-06-26 20:55
 * Email: fanyafeng@live.cn
 */
public interface SupplierOrderDao {

    int countSupplierOrder(JSONObject jsonObject);

    List<JSONObject> listSupplierOrder(JSONObject jsonObject);
}
