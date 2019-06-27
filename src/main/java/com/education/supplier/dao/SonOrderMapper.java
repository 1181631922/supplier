package com.education.supplier.dao;

import com.education.supplier.model.SonOrder;

public interface SonOrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SonOrder record);

    int insertSelective(SonOrder record);

    SonOrder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SonOrder record);

    int updateByPrimaryKey(SonOrder record);
}