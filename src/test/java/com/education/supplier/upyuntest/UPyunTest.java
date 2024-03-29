package com.education.supplier.upyuntest;

import com.UpYun;
import com.education.supplier.dao.ImageMapper;
import com.education.supplier.model.Image;
import com.upyun.UpException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Author： fanyafeng
 * Data： 2019-07-03 10:16
 * Email: fanyafeng@live.cn
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UPyunTest {

    @Resource
    private ImageMapper imageMapper;

    /**
     * 可读取，可写入
     * xiaofantongxue
     * 7KRlqU5dTFMxlCysui03AgdiV4LAxPal
     * <p>
     * 可读取，可写入，可删除
     * fanyafeng
     * ukrZ497fglYradGPewvbr3uu7liCiCBO
     */
    @Test
    public void upImageFile() {
        UpYun upYun = new UpYun("image-handsome", "fanyafeng", "ukrZ497fglYradGPewvbr3uu7liCiCBO");
        upYun.setDebug(true);
        upYun.setTimeout(60);
        upYun.setApiDomain(UpYun.ED_AUTO);

        File file = new File("/Users/fanyafeng/GitProject/supplier/WechatIMG75.jpeg");
        try {
            upYun.setContentMD5(UpYun.md5(file));
            String filePath = "/video/";
            String fileName = UUID.randomUUID() + ".jpg";
            boolean result = upYun.writeFile(filePath + fileName, file, true);

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

    }

    /**
     * 获取文件列表
     */
    @Test
    public void getImageFileList() {
        UpYun upYun = new UpYun("image-handsome", "fanyafeng", "ukrZ497fglYradGPewvbr3uu7liCiCBO");
        try {
            List<UpYun.FolderItem> folderItemList = upYun.readDir("/image/", null);
            for (int i = 0; i < folderItemList.size(); i++) {
                System.out.println(folderItemList.get(i).toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UpException e) {
            e.printStackTrace();
        }
    }
}
