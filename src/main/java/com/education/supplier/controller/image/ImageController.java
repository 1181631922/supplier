package com.education.supplier.controller.image;

import com.alibaba.fastjson.JSONObject;
import com.education.supplier.model.Supplier;
import com.education.supplier.service.ImageService;
import com.education.supplier.util.CommonUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Author： fanyafeng
 * Data： 2019-07-08 12:10
 * Email: fanyafeng@live.cn
 */
@RestController
@RequestMapping("/image")
public class ImageController {

    /**
     * 商品hold图
     */
    final private static String IMAGE_GOODS = "/image";

    /**
     * 头像图
     */
    final private static String IMAGE_AVATAR = "/avatar";

    @Resource
    private ImageService imageService;

    @PostMapping("/add-goods")
    public JSONObject addGoods(@RequestBody JSONObject jsonObject, Supplier supplier) {
        CommonUtil.hasAllRequired(jsonObject, "imageName");
        jsonObject.put("imagePath", IMAGE_GOODS);
        return imageService.addImage(jsonObject);
    }

    @PostMapping("add-avatar")
    public JSONObject addAvatar(@RequestBody JSONObject jsonObject, Supplier supplier) {
        CommonUtil.hasAllRequired(jsonObject, "imageName");
        jsonObject.put("imagePath", IMAGE_AVATAR);
        return imageService.addImage(jsonObject);
    }
}
