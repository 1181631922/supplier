package com.education.supplier.service;

import com.alibaba.fastjson.JSONObject;
import com.education.supplier.model.Supplier;

/**
 * Author： fanyafeng
 * Data： 2019-06-22 13:16
 * Email: fanyafeng@live.cn
 */
public interface GoodsService {

    /**
     * 添加商品
     */
    JSONObject addGoods(JSONObject jsonObject);

    /**
     * 删除商品
     */
    JSONObject delGoods(JSONObject jsonObject);

    /**
     * 修改商品，status为上架下架状态
     */
    JSONObject update(JSONObject jsonObject);

    /**
     * 根据id列出商品
     */
    JSONObject listGoods(JSONObject jsonObject);

}
