package com.education.supplier.dao;

import com.education.supplier.model.Shopping;

public interface ShoppingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Shopping record);

    int insertSelective(Shopping record);

    Shopping selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Shopping record);

    int updateByPrimaryKey(Shopping record);
}