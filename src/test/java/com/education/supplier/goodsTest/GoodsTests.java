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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

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
        goods.setSupplierId(1);
        goods.setPrice(599L);
        goods.setSalePrice(599L);
        goods.setImg("https://pics1.baidu.com/feed/810a19d8bc3eb135a61aecec3949a4d6fc1f4460.jpeg?token=bdc1255e05eba4ce9f590b8d7fcdf4d2&s=67222BE74B481B511AF0A917030060C3");
        goods.setGradeId(1);
        goods.setSubjectId(1);
        for (int i = 0; i < 20; i++) {
            goodsMapper.insertSelective(goods);
        }
    }

    @Test
    public void updateGood() {
//        try {
        Goods goods = new Goods();


        goods.setCreateTime(Calendar.getInstance().getTime());
        goods.setUpdateTime(new Date());
        LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
        System.out.println(new Date().toString());
//            goods.setStartTime(longToDate(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss"));
//            goods.setEndTime(longToDate(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss"));
//            goods.
        goods.setId(1);
        goodsMapper.updateByPrimaryKeySelective(goods);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
    }

    // date类型转换为String类型
    // formatType格式为yyyy-MM-dd HH:mm:ss//yyyy年MM月dd日 HH时mm分ss秒
    // data Date类型的时间
    public static String dateToString(Date data, String formatType) {
        return new SimpleDateFormat(formatType).format(data);
    }

    // long类型转换为String类型
    // currentTime要转换的long类型的时间
    // formatType要转换的string类型的时间格式
    public static String longToString(long currentTime, String formatType)
            throws ParseException {
        Date date = longToDate(currentTime, formatType); // long类型转成Date类型
        String strTime = dateToString(date, formatType); // date类型转成String
        return strTime;
    }

    // string类型转换为date类型
    // strTime要转换的string类型的时间，formatType要转换的格式yyyy-MM-dd HH:mm:ss//yyyy年MM月dd日
    // HH时mm分ss秒，
    // strTime的时间格式必须要与formatType的时间格式相同
    public static Date stringToDate(String strTime, String formatType)
            throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(formatType);
        Date date = null;
        date = formatter.parse(strTime);
        return date;
    }

    // long转换为Date类型
    // currentTime要转换的long类型的时间
    // formatType要转换的时间格式yyyy-MM-dd HH:mm:ss//yyyy年MM月dd日 HH时mm分ss秒
    public static Date longToDate(long currentTime, String formatType)
            throws ParseException {
        Date dateOld = new Date(currentTime); // 根据long类型的毫秒数生命一个date类型的时间
        String sDateTime = dateToString(dateOld, formatType); // 把date类型的时间转换为string
        Date date = stringToDate(sDateTime, formatType); // 把String类型转换为Date类型
        return date;
    }

    // string类型转换为long类型
    // strTime要转换的String类型的时间
    // formatType时间格式
    // strTime的时间格式和formatType的时间格式必须相同
    public static long stringToLong(String strTime, String formatType)
            throws ParseException {
        Date date = stringToDate(strTime, formatType); // String类型转成date类型
        if (date == null) {
            return 0;
        } else {
            long currentTime = dateToLong(date); // date类型转成long类型
            return currentTime;
        }
    }

    // date类型转换为long类型
    // date要转换的date类型的时间
    public static long dateToLong(Date date) {
        return date.getTime();
    }

}
