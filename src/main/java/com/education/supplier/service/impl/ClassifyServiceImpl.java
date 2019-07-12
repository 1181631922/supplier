package com.education.supplier.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.education.supplier.dao.GradeDao;
import com.education.supplier.dao.SubjectDao;
import com.education.supplier.service.ClassifyService;
import com.education.supplier.util.CommonUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Author： fanyafeng
 * Data： 2019-07-04 10:28
 * Email: fanyafeng@live.cn
 */
@Service
public class ClassifyServiceImpl implements ClassifyService {

    @Resource
    private GradeDao gradeDao;

    @Resource
    private SubjectDao subjectDao;

    @Override
    public JSONObject listGrade() {
        return CommonUtil.successJson(gradeDao.listGrade());
    }

    @Override
    public JSONObject listSubject() {
        return CommonUtil.successJson(subjectDao.listSubject());
    }
}
