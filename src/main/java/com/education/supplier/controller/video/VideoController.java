package com.education.supplier.controller.video;

import com.alibaba.fastjson.JSONObject;
import com.education.supplier.model.Supplier;
import com.education.supplier.service.VideoService;
import com.education.supplier.util.CommonUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Author： fanyafeng
 * Data： 2019-07-08 19:39
 * Email: fanyafeng@live.cn
 */
@RestController
@RequestMapping("/video")
public class VideoController {
    /**
     * 商品hold图
     */
    final private static String VIDEO_GOODS = "/video";

    @Resource
    private VideoService videoService;

    @PostMapping("/add-video")
    public JSONObject addGoods(@RequestBody JSONObject jsonObject, Supplier supplier) {
        CommonUtil.hasAllRequired(jsonObject, "videoName");
        jsonObject.put("videoPath", VIDEO_GOODS);
        return videoService.addVideo(jsonObject);
    }
}
