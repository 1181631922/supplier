package com.education.supplier.goodsTest;

import com.alibaba.fastjson.JSONObject;
import com.education.supplier.dao.*;
import com.education.supplier.model.SupplierOrder;
import com.education.supplier.service.GoodsService;
import com.education.supplier.service.SupplierOrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Author： fanyafeng
 * Data： 2019-06-22 14:48
 * Email: fanyafeng@live.cn
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodsTests {

    @Resource
    private GoodsMapper goodsMapper;

    @Resource
    private GoodsService goodsService;

    @Resource
    private GradeDao gradeDao;

    @Resource
    private SupplierOrderMapper supplierOrderMapper;

    @Resource
    private SupplierOrderDao supplierOrderDao;

    @Test
    public void addGoods() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "三角函数");
        goodsService.addGoods(jsonObject);
    }

    @Test
    public void listGoods() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("supplierId", 2);
        jsonObject.put("pageNum", 0);
        System.out.println(goodsService.listGoods(jsonObject));
    }

    @Test
    public void listGrader() {
        System.out.println(gradeDao.listGrade());
    }

    @Test
    public void addSupplierMapper() {
//        SupplierOrder order=new SupplierOrder();
//        order.setGoodsId(1);
//        order.setUserId(2);
//        order.setSupplierId(2);
//        supplierOrderMapper.insertSelective(order);

//        System.out.println(supplierOrderDao.listSupplierOrder());
    }
}
