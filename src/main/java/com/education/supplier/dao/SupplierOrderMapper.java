package com.education.supplier.dao;

import com.education.supplier.model.SupplierOrder;

public interface SupplierOrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SupplierOrder record);

    int insertSelective(SupplierOrder record);

    SupplierOrder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SupplierOrder record);

    int updateByPrimaryKey(SupplierOrder record);
}