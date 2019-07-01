package com.education.supplier.dao;

import com.education.supplier.model.Status;

public interface StatusMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Status record);

    int insertSelective(Status record);

    Status selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Status record);

    int updateByPrimaryKey(Status record);
}