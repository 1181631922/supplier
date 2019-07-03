package com.education.supplier.fuzzyTest;

import com.alibaba.fastjson.JSONObject;
import com.education.supplier.dao.GoodsDao;
import com.education.supplier.service.GoodsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Author： fanyafeng
 * Data： 2019-07-03 20:22
 * Email: fanyafeng@live.cn
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FuzzyTests {

    @Resource
    private GoodsService goodsService;

    @Resource
    private GoodsDao goodsDao;

    @Test
    public void getResult(){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("pageNum",1);
        jsonObject.put("name","79");
//        System.out.println(goodsService.fuzzySearch(jsonObject));
        System.out.println(goodsDao.countFuzzyGoods(jsonObject));
    }

}
