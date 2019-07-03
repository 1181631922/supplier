package com.education.supplier.upyuntest;

import com.UpYun;
import com.upyun.UpException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;

/**
 * Author： fanyafeng
 * Data： 2019-07-03 10:16
 * Email: fanyafeng@live.cn
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UPyunTest {
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
    public void upFile() {
        UpYun upYun = new UpYun("image-handsome", "fanyafeng", "ukrZ497fglYradGPewvbr3uu7liCiCBO");
        upYun.setDebug(true);
        upYun.setTimeout(60);
        upYun.setApiDomain(UpYun.ED_AUTO);

        File file = new File("/Users/fanyafeng/GitProject/supplier/WechatIMG75.jpeg");
        try {
            boolean result = upYun.writeFile("/video/test.jpg", file, true);
            System.out.println("上传是否成功：" + file);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (UpException e) {
            e.printStackTrace();
        }

    }
}
