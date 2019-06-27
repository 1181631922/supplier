package com.education.supplier.dao;

import com.education.supplier.model.Supplier;

/**
 * Author： fanyafeng
 * Data： 2019-06-26 14:28
 * Email: fanyafeng@live.cn
 */
public interface SupplierDao {
    Supplier getSupplierById(String supplierToken);
}
