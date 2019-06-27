package com.education.supplier.controller.goods;

import com.alibaba.fastjson.JSONObject;
import com.education.supplier.model.Supplier;
import com.education.supplier.service.GoodsService;
import com.education.supplier.util.CommonUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Author： fanyafeng
 * Data： 2019-06-22 15:06
 * Email: fanyafeng@live.cn
 */
@CrossOrigin
@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Resource
    private GoodsService goodsService;

    @PostMapping("/add")
    public JSONObject addGoods(@RequestBody JSONObject requestJson, Supplier supplier) {
        CommonUtil.hasAllRequired(requestJson, "name,goodsUrl");
        requestJson.put("supplierId", supplier.getId());
        return goodsService.addGoods(requestJson);
    }

    @PostMapping("/update")
    public JSONObject updateGoods(@RequestBody JSONObject requestJson, Supplier supplier) {
        CommonUtil.hasAllRequired(requestJson,"goodsId");
        return goodsService.update(requestJson);
    }

    @PostMapping("/list")
    public JSONObject listGoods(@RequestBody JSONObject requestJson,Supplier supplier) {
        CommonUtil.hasAllRequired(requestJson,"pageNum");
        int supplierId=supplier.getId();
        requestJson.put("supplierId",supplierId);
        return goodsService.listGoods(requestJson);
    }
}
