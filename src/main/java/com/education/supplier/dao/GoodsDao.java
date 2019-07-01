package com.education.supplier.dao;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * Author： fanyafeng
 * Data： 2019-06-22 13:01
 * Email: fanyafeng@live.cn
 */
public interface GoodsDao {
    /**
     * 统计商品数量
     */
    int countGoods(JSONObject jsonObject);

    /**
     * 获取商品列表
     */
    List<JSONObject> listGoods(JSONObject jsonObject);

    /**
     * 根据goodId和supplierId查看是否存在此商品
     */
    int countGoodsById(JSONObject jsonObject);

    /**
     * 获取商品状态
     */
    List<JSONObject> getStatus();
}
