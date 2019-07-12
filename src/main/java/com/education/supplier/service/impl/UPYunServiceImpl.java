package com.education.supplier.service.impl;

import com.UpYun;
import com.education.supplier.dao.ImageMapper;
import com.education.supplier.model.Image;
import com.education.supplier.service.UPYunService;
import com.upyun.UpException;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

/**
 * Author： fanyafeng
 * Data： 2019-07-06 19:41
 * Email: fanyafeng@live.cn
 */
public class UPYunServiceImpl implements UPYunService {

    @Resource
    private ImageMapper imageMapper;

    @Override
    public synchronized boolean upImage(File file, boolean auto) {

        UpYun upYun = new UpYun("image-handsome", "fanyafeng", "ukrZ497fglYradGPewvbr3uu7liCiCBO");
        upYun.setDebug(true);
        upYun.setTimeout(60);
        upYun.setApiDomain(UpYun.ED_AUTO);

//        File file = new File("/Users/fanyafeng/GitProject/supplier/WechatIMG75.jpeg");
        try {
            upYun.setContentMD5(UpYun.md5(file));
            String filePath = "/video/";
            String fileName = UUID.randomUUID() + ".jpg";
            boolean result = upYun.writeFile(filePath + fileName, file, auto);

            Image image = new Image();
            image.setCreateTime(new Date());
            image.setFilePath(filePath);
            image.setImgName(fileName);
            image.setImgPath(filePath + fileName);
            if (result) {
                int id = imageMapper.insertSelective(image);
                System.out.println("获取输入后的id:" + id);
                System.out.println("获取插入后的id:" + image.getId());
            }

            System.out.println("上传是否成功：" + file);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (UpException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean upImage(File file) {
        return upImage(file,true);
    }
}
