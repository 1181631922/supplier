package com.education.supplier.goodsTest;

import com.alibaba.fastjson.JSONObject;
import com.education.supplier.dao.*;
import com.education.supplier.model.Goods;
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

    @Test
    public void addGood() {
        Goods goods = new Goods();
        goods.setGoodsName("三角函数");
        goods.setGoodsUrl("http://220.194.238.108/13/j/r/y/q/jryqujooljwzxpmyjumfuarxoguwld/hc.yinyuetai.com/81E9016B6454B2ADD09AE8853E6A7824.mp4?sc=ef957d6fd8824b68&br=779&vid=3386199&aid=39878&area=ML&vst=3");
        goods.setGoodsDesc("三角函数描述");
        goods.setSupplierId(2);
        goods.setImg("https://pics1.baidu.com/feed/810a19d8bc3eb135a61aecec3949a4d6fc1f4460.jpeg?token=bdc1255e05eba4ce9f590b8d7fcdf4d2&s=67222BE74B481B511AF0A917030060C3");
        goods.setGradeId(1);
        goods.setSubjectId(1);
        for (int i = 0; i < 20; i++) {
            goodsMapper.insertSelective(goods);
        }
    }
}
