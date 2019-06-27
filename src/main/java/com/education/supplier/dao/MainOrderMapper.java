package com.education.supplier.dao;

import com.education.supplier.model.MainOrder;

public interface MainOrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MainOrder record);

    int insertSelective(MainOrder record);

    MainOrder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MainOrder record);

    int updateByPrimaryKey(MainOrder record);
}