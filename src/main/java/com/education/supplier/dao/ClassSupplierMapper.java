package com.education.supplier.dao;

import com.education.supplier.model.ClassSupplier;

public interface ClassSupplierMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ClassSupplier record);

    int insertSelective(ClassSupplier record);

    ClassSupplier selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ClassSupplier record);

    int updateByPrimaryKey(ClassSupplier record);
}