package com.education.supplier.dao;

import com.education.supplier.model.SupplierSonOrder;

public interface SupplierSonOrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SupplierSonOrder record);

    int insertSelective(SupplierSonOrder record);

    SupplierSonOrder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SupplierSonOrder record);

    int updateByPrimaryKey(SupplierSonOrder record);
}