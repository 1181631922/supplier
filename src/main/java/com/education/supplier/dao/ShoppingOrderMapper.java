package com.education.supplier.dao;

import com.education.supplier.model.ShoppingOrder;

public interface ShoppingOrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ShoppingOrder record);

    int insertSelective(ShoppingOrder record);

    ShoppingOrder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShoppingOrder record);

    int updateByPrimaryKey(ShoppingOrder record);
}