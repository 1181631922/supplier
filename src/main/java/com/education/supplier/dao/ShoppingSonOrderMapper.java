package com.education.supplier.dao;

import com.education.supplier.model.ShoppingSonOrder;

public interface ShoppingSonOrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ShoppingSonOrder record);

    int insertSelective(ShoppingSonOrder record);

    ShoppingSonOrder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShoppingSonOrder record);

    int updateByPrimaryKey(ShoppingSonOrder record);
}