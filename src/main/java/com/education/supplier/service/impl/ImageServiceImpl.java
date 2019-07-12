package com.education.supplier.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.education.supplier.dao.ImageMapper;
import com.education.supplier.model.Image;
import com.education.supplier.service.ImageService;
import com.education.supplier.util.CommonUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;

/**
 * Author： fanyafeng
 * Data： 2019-07-08 11:32
 * Email: fanyafeng@live.cn
 */
@Service
public class ImageServiceImpl implements ImageService {

    @Resource
    private ImageMapper imageMapper;

    /**
     * 添加商品图片
     *
     * @return
     */
    @Override
    public synchronized JSONObject addImage(JSONObject jsonObject) {
        Image image = new Image();
        String imagePath=jsonObject.getString("imagePath");
        image.setImgPath(imagePath);
        String imageName = jsonObject.getString("imageName");
        image.setImgName(imageName);
        image.setFilePath(imagePath + imageName);
        image.setCreateTime(new Date());
        imageMapper.insertSelective(image);
        return CommonUtil.successJson(image.getId());
    }
}
