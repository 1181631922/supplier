package com.education.supplier.supplierTest;

import com.education.supplier.model.Supplier;
import com.education.supplier.service.SupplierService;
import com.education.supplier.util.Base64Util;
import com.education.supplier.util.SnowflakeUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Base64Utils;
import sun.security.provider.MD5;

import javax.annotation.Resource;
import java.util.Base64;

/**
 * Author： fanyafeng
 * Data： 2019-06-20 20:48
 * Email: fanyafeng@live.cn
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SupplierTests {
    @Resource
    private SupplierService supplierService;

    @Test
    public void testOrderId() {
        try {
            SnowflakeUtil snowflakeUtil = SnowflakeUtil.getInstanceSnowflake();
            for (int i = 0; i < 100; i++) {
                System.out.println(snowflakeUtil.nextId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void addSupplier() {
        Supplier supplier = new Supplier();
        supplier.setName("吴大明");
        supplier.setPassword("password");
        supplier.setStatus(1);
        supplierService.addSupplier(supplier);
    }

    @Test
    public void testPassword() {
//        String str = "02";
//        byte[] bytes = str.getBytes();
//
//        //Base64 加密
//        String encoded = Base64.getEncoder().encodeToString(bytes);
//        System.out.println("Base 64 加密后：" + encoded);
//
//        //Base64 解密
//        byte[] decoded = Base64.getDecoder().decode(encoded);
//
//        String decodeStr = new String(decoded);
//        System.out.println("Base 64 解密后：" + decodeStr);
//
//        System.out.println();

        String src = Base64Util.encode("01");
        System.out.println(src);
        String out = Base64Util.decode(src);
        System.out.println(out);
    }
}
