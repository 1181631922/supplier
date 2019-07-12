package com.education.supplier.service;

import java.io.File;

/**
 * Author： fanyafeng
 * Data： 2019-07-06 19:37
 * Email: fanyafeng@live.cn
 */
public interface UPYunService {

    boolean upImage(File file, boolean auto);

    boolean upImage(File file);
}
