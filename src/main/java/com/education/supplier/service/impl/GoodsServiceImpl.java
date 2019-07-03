package com.education.supplier.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.education.supplier.dao.GoodsDao;
import com.education.supplier.dao.GoodsMapper;
import com.education.supplier.model.Goods;
import com.education.supplier.model.Supplier;
import com.education.supplier.service.GoodsService;
import com.education.supplier.service.LoginService;
import com.education.supplier.util.CommonUtil;
import com.education.supplier.util.StringTools;
import com.education.supplier.util.constants.ErrorEnum;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author： fanyafeng
 * Data： 2019-06-22 13:17
 * Email: fanyafeng@live.cn
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Resource
    private GoodsMapper goodsMapper;

    @Resource
    private GoodsDao goodsDao;

    /**
     * 添加商品
     *
     * @param jsonObject
     */
    @Override
    public JSONObject addGoods(JSONObject jsonObject) {
        Goods goods = new Goods();
        String name = jsonObject.getString("name");
        goods.setGoodsName(name);
        String desc = jsonObject.getString("desc");
        if (desc == null) {
            goods.setGoodsDesc(name.length() > 10 ? name.substring(0, 10) : name);
        } else {
            goods.setGoodsDesc(desc);
        }
        String url = jsonObject.getString("goodsUrl");
        if (!StringTools.isNullOrEmpty(url)) {
            goods.setGoodsUrl(url);
        }
        int supplierId = jsonObject.getIntValue("supplierId");
        goods.setSupplierId(supplierId);
        goodsMapper.insertSelective(goods);
        return CommonUtil.successJson();
    }

    /**
     * 删除商品
     *
     * @param jsonObject
     */
    @Override
    public JSONObject delGoods(JSONObject jsonObject) {
        Goods goods = new Goods();
        Integer id = jsonObject.getIntValue("goodsId");
        goods.setId(id);
        goods.setDeleteStatus(true);
        if (goodsDao.countGoodsById(jsonObject) > 0) {
            goodsMapper.updateByPrimaryKeySelective(goods);
            return CommonUtil.successJson();
        } else {
            return CommonUtil.errorJson(ErrorEnum.E_600);
        }
    }

    /**
     * 修改商品，status为上架下架状态
     *
     * @param jsonObject
     */
    @Override
    public JSONObject update(JSONObject jsonObject) {
        Goods goods = new Goods();
        Integer id = jsonObject.getIntValue("goodsId");
        goods.setId(id);
//        String goodsCode = jsonObject.getString("goodsCode");
//        goods.setGoodsCode(goodsCode);
        String goodsName = jsonObject.getString("goodsName");
        goods.setGoodsName(goodsName);
        Integer status = jsonObject.getIntValue("status");
        goods.setStatus(status);
        String goodsUrl = jsonObject.getString("goodsUrl");
        goods.setGoodsUrl(goodsUrl);
        String goodsDesc = jsonObject.getString("goodsDesc");
        goods.setGoodsDesc(goodsDesc);
        Long salePrice = jsonObject.getLong("salePrice");
        goods.setSalePrice(salePrice);
        String img = jsonObject.getString("imgUrl");
        goods.setImg(img);
        Integer gradeId = jsonObject.getIntValue("gradeId");
        goods.setGradeId(gradeId);
        Integer subjectId = jsonObject.getIntValue("subjectId");
        goods.setSubjectId(subjectId);
        if (goodsDao.countGoodsById(jsonObject) > 0) {
            goodsMapper.updateByPrimaryKeySelective(goods);
            return CommonUtil.successJson();
        } else {
            return CommonUtil.errorJson(ErrorEnum.E_800);
        }
    }

    /**
     * 根据id列出商品
     *
     * @param jsonObject
     */
    @Override
    public JSONObject listGoods(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        int count = goodsDao.countGoods(jsonObject);
        List<JSONObject> list = goodsDao.listGoods(jsonObject);
        return CommonUtil.successPage(jsonObject, list, count);
    }

    /**
     * 获取商品状态
     *
     */
    @Override
    public JSONObject getStatus() {
        List<JSONObject> list = goodsDao.getStatus();
        return CommonUtil.successPage(list);
    }

    /**
     * 根据商品名称模糊搜索
     *
     * @param jsonObject
     */
    @Override
    public JSONObject fuzzySearch(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        int count = goodsDao.countFuzzyGoods(jsonObject);
        List<JSONObject> list = goodsDao.getFuzzyGoods(jsonObject);
        return CommonUtil.successPage(jsonObject, list, count);
    }
}
